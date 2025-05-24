package co.edu.uco.onlinetest.data.dao.entity.departamento.impl.azuresql;

import co.edu.uco.onlinetest.crosscutting.excepciones.DataOnlineTestException;
import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.onlinetest.data.dao.entity.departamento.DepartamentoDao;
import co.edu.uco.onlinetest.entity.DepartamentoEntity;
import co.edu.uco.onlinetest.entity.PaisEntity;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DepartamentoAzureSQLDAO implements DepartamentoDao {

    private Connection conexion;

    public DepartamentoAzureSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void create(DepartamentoEntity entity) throws OnlineTestException {


        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("INSERT INTO Departamento(id, nombre, pais) VALUES (?, ?, ?)");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setString(2, entity.getNombre());

            // Aquí usamos el UUID del PaisEntity relacionado
            sentenciaPreparada.setObject(3, entity.getPais().getId());

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de REGISTRAR la información de un nuevo departamento en la base de datos. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema tratando de registrar la información de un nuevo departamento.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo exception NO CONTROLADA tratando de REGISTRAR la información de un nuevo departamento en la base de datos. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de registrar la información de un nuevo departamento.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }


    @Override
    public void delete(UUID id) throws OnlineTestException {
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("DELETE FROM Departamento WHERE id=?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            sentenciaPreparada.setObject(1, id);
            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de ELIMINAR un departamento en la base de datos.";
            var mensajeUsuario = "Se ha producido un problema tratando de eliminar el departamento.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de ELIMINAR un departamento en la base de datos.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de eliminar el departamento.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }


    @Override
    public List<DepartamentoEntity> listByFilter(DepartamentoEntity entity) throws OnlineTestException {
        var listaDepartamentos = new ArrayList<DepartamentoEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre, pais FROM Departamento WHERE 1=1");

        boolean filtrarPorId = entity != null && entity.getId() != null;
        boolean filtrarPorNombre = entity != null && entity.getNombre() != null && !entity.getNombre().isBlank();
        boolean filtrarPorPais = entity != null && entity.getPais() != null && entity.getPais().getId() != null;

        if (filtrarPorId) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (filtrarPorNombre) {
            sentenciaSQL.append(" AND nombre LIKE ?");
        }
        if (filtrarPorPais) {
            sentenciaSQL.append(" AND pais = ?");
        }

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            int parametroIndex = 1;

            if (filtrarPorId) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getId());
            }
            if (filtrarPorNombre) {
                sentenciaPreparada.setString(parametroIndex++, "%" + entity.getNombre().trim() + "%");
            }
            if (filtrarPorPais) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getPais().getId());
            }

            try (var cursorResultados = sentenciaPreparada.executeQuery()) {
                while (cursorResultados.next()) {
                    var departamento = new DepartamentoEntity();
                    departamento.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    departamento.setNombre(cursorResultados.getString("nombre"));

                    // Crear el PaisEntity y asignar el id
                    var pais = new PaisEntity();
                    pais.setId(UtilUUID.convertirAUUID(cursorResultados.getString("pais")));
                    departamento.setPais(pais);

                    listaDepartamentos.add(departamento);
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de listar departamentos filtrados.";
            var mensajeUsuario = "Se ha producido un problema tratando de obtener la lista de departamentos filtrados.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de listar departamentos filtrados.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de obtener la lista de departamentos filtrados.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaDepartamentos;
    }


    @Override
    public List<DepartamentoEntity> listAll() throws OnlineTestException {
        var listaDepartamentos = new ArrayList<DepartamentoEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre, pais FROM Departamento");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var resultado = sentenciaPreparada.executeQuery()) {

            while (resultado.next()) {
                var departamento = new DepartamentoEntity();
                departamento.setId(UtilUUID.convertirAUUID(resultado.getString("id")));
                departamento.setNombre(resultado.getString("nombre"));

                var pais = new PaisEntity();
                pais.setId(UtilUUID.convertirAUUID(resultado.getString("pais")));
                departamento.setPais(pais);

                listaDepartamentos.add(departamento);
            }

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de listar todos los departamentos en la base de datos.";
            var mensajeUsuario = "Se ha producido un problema tratando de obtener la lista de departamentos.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de listar todos los departamentos en la base de datos.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de obtener la lista de departamentos.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaDepartamentos;
    }



    @Override
    public DepartamentoEntity listById(UUID id) throws OnlineTestException {

        var departamentoRetorno = new DepartamentoEntity();

        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre, pais FROM Departamento WHERE id=?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

            sentenciaPreparada.setObject(1, id);

            try (var cursorResultados = sentenciaPreparada.executeQuery()) {

                if (cursorResultados.next()) {
                    departamentoRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    departamentoRetorno.setNombre(cursorResultados.getString("nombre"));

                    var pais = new PaisEntity();
                    pais.setId(UtilUUID.convertirAUUID(cursorResultados.getString("pais")));
                    departamentoRetorno.setPais(pais);
                }
            }

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de hacer SELECT en la tabla Departamento por id";
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la información del departamento con el identificador deseado";

            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de hacer SELECT en la tabla Departamento por id";
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la información del departamento con el identificador deseado";

            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return departamentoRetorno;
    }


    @Override
    public void update(UUID id, DepartamentoEntity entity) throws OnlineTestException {

        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("UPDATE Departamento SET nombre = ?, pais = ? WHERE id = ?");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

            sentenciaPreparada.setString(1, entity.getNombre());
            sentenciaPreparada.setObject(2, entity.getPais().getId());
            sentenciaPreparada.setObject(3, id);

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de MODIFICAR la información de un departamento en la base de datos. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema tratando de modificar la información del departamento.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de MODIFICAR la información de un departamento en la base de datos. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de modificar la información del departamento.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }
    }


    @Override
    public void updateById(UUID uuid, DepartamentoEntity entity) {

    }
}
