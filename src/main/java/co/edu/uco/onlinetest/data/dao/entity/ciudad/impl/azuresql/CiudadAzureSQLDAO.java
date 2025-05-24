package co.edu.uco.onlinetest.data.dao.entity.ciudad.impl.azuresql;

import co.edu.uco.onlinetest.crosscutting.excepciones.DataOnlineTestException;
import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.onlinetest.data.dao.entity.ciudad.CiudadDao;
import co.edu.uco.onlinetest.entity.CiudadEntity;
import co.edu.uco.onlinetest.entity.DepartamentoEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CiudadAzureSQLDAO  implements CiudadDao {

    private Connection conexion;

    public CiudadAzureSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }


    @Override
    public void create(CiudadEntity entity) throws OnlineTestException {

        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO Ciudad(id, nombre, departamento) VALUES (?, ?, ?)");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setString(2, entity.getNombre());

            // Aquí usamos el UUID del DepartamentoEntity relacionado
            sentenciaPreparada.setObject(3, entity.getDepartamento().getId());

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de REGISTRAR la información de una nueva ciudad en la base de datos. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema tratando de registrar la información de una nueva ciudad.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo exception NO CONTROLADA tratando de REGISTRAR la información de una nueva ciudad en la base de datos. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de registrar la información de una nueva ciudad.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }


    @Override
    public void delete(UUID id) throws OnlineTestException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM Ciudad WHERE id=?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);
            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de ELIMINAR una ciudad en la base de datos.Para mas detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema tratando de eliminar la ciudad en la base de datos.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de ELIMINAR la infomacion de  una ciudad  en la base de datos. para mas detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de eliminar la ciudad.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }


    @Override
    public List<CiudadEntity> listByFilter(CiudadEntity entity) throws OnlineTestException {
        var listaCiudades = new ArrayList<CiudadEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre, departamento FROM Ciudad WHERE 1=1");

        boolean filtrarPorId = entity != null && entity.getId() != null;
        boolean filtrarPorNombre = entity != null && entity.getNombre() != null && !entity.getNombre().isBlank();
        boolean filtrarPorDepartamento = entity != null && entity.getDepartamento() != null && entity.getDepartamento().getId() != null;

        if (filtrarPorId) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (filtrarPorNombre) {
            sentenciaSQL.append(" AND nombre LIKE ?");
        }
        if (filtrarPorDepartamento) {
            sentenciaSQL.append(" AND departamento = ?");
        }

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            int parametroIndex = 1;

            if (filtrarPorId) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getId());
            }
            if (filtrarPorNombre) {
                sentenciaPreparada.setString(parametroIndex++, "%" + entity.getNombre().trim() + "%");
            }
            if (filtrarPorDepartamento) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getDepartamento().getId());
            }

            try (var cursorResultados = sentenciaPreparada.executeQuery()) {

                while (cursorResultados.next()) {
                    var ciudad = new CiudadEntity();
                    ciudad.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    ciudad.setNombre(cursorResultados.getString("nombre"));

                    var departamento = new DepartamentoEntity();
                    departamento.setId(UtilUUID.convertirAUUID(cursorResultados.getString("departamento")));
                    ciudad.setDepartamento(departamento);

                    listaCiudades.add(ciudad);
                }
            }

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de listar ciudades filtradas.";
            var mensajeUsuario = "Se ha producido un problema tratando de obtener la lista de ciudades filtradas.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de listar ciudades filtradas.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de obtener la lista de ciudades filtradas.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaCiudades;
    }


    @Override
    public List<CiudadEntity> listAll() throws OnlineTestException {
        var listaCiudades = new ArrayList<CiudadEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre, departamento FROM Ciudad");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var resultado = sentenciaPreparada.executeQuery()) {

            while (resultado.next()) {
                var ciudad = new CiudadEntity();
                ciudad.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                ciudad.setNombre(resultado.getString("nombre"));

                var departamento = new DepartamentoEntity();
                departamento.setId(UtilUUID.convertirAUUID(resultado.getString("departamento")));
                ciudad.setDepartamento(departamento);

                listaCiudades.add(ciudad);
            }

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de listar todas las ciudades en la base de datos.";
            var mensajeUsuario = "Se ha producido un problema tratando de obtener la lista de ciudades.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de listar todas las ciudades en la base de datos.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de obtener la lista de ciudades.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaCiudades;
    }


    @Override
    public CiudadEntity listById(UUID id) throws OnlineTestException {
        CiudadEntity ciudadRetorno = new CiudadEntity();

        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre, departamento FROM Ciudad WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);

            try (var cursorResultados = sentenciaPreparada.executeQuery()) {
                if (cursorResultados.next()) {
                    ciudadRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    ciudadRetorno.setNombre(cursorResultados.getString("nombre"));

                    var departamento = new DepartamentoEntity();
                    departamento.setId(UtilUUID.convertirAUUID(cursorResultados.getString("departamento")));
                    ciudadRetorno.setDepartamento(departamento);
                }
            }

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer SELECT en la tabla Ciudad por id.";
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información de la ciudad con el identificador deseado.";

            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de hacer SELECT en la tabla Ciudad por id.";
            var mensajeUsuario = "Se ha presentado un problema inesperado tratando de consultar la información de la ciudad con el identificador deseado.";

            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return ciudadRetorno;
    }

    @Override
    public void update(UUID id, CiudadEntity entity) throws OnlineTestException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("UPDATE Ciudad SET nombre = ?, departamento = ? WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setString(1, entity.getNombre());
            sentenciaPreparada.setObject(2, entity.getDepartamento().getId());
            sentenciaPreparada.setObject(3, id);

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de MODIFICAR la información de una ciudad en la base de datos. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema tratando de modificar la información de la ciudad.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de MODIFICAR la información de una ciudad en la base de datos. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de modificar la información de la ciudad.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }

    @Override
    public void updateById(UUID uuid, CiudadEntity entity) {

    }
}
