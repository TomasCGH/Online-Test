package co.edu.uco.onlinetest.data.dao.entity.pais.impl.azuresql;

import co.edu.uco.onlinetest.crosscutting.excepciones.DataOnlineTestException;
import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.onlinetest.data.dao.entity.pais.PaisDao;
import co.edu.uco.onlinetest.entity.PaisEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaisAzureSQLDAO implements PaisDao {

    private Connection conexion;


    public PaisAzureSQLDAO(Connection conexion) {
        this.conexion = conexion;
    }


    @Override
    public void create(PaisEntity entity) throws OnlineTestException {


        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("INSERT INTO Pais(id,nombre) VALUES(?,?);");

        try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

            sentenciaPreparada.setObject(1, entity.getId());
            sentenciaPreparada.setObject(2, entity.getNombre());

            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción  de tipo SQLException tratando de REGISTRAR la información de un nuevo país en la base de datos. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema tratando de registrar la información de un nuevo país.";
            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción  de tipo exception NO CONTROLADA tratando de REGISTRAR la información de un nuevo país en la base de datos. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema INESPERADO tratando de registrar la información de un nuevo país.";

            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);
        }


    }

    @Override
    public void delete(UUID uuid)  throws OnlineTestException {

        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("DELETE FROM Pais WHERE id=?");

        try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

            sentenciaPreparada.setObject(1, uuid);


            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeTecnico = "Error al abrir la conexion y no se puede obtener los datos de la BD";
            var mensajeUsuario = "Se presento una excpecion de tipoSQLexception tratando de obtener los datos de la BD";

            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        } catch (Exception exception) {
            var mensajeTecnico = "Error al abrir la conexion y no se puede obtener los datos de la BD";
            var mensajeUsuario = "Se presento una excpecion de tipoSQLexception tratando de obtener los datos de la BD";


            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);
        }

    }

    @Override
    public List<PaisEntity> listByFilter(PaisEntity entity) throws OnlineTestException {
        var listaPaises = new ArrayList<PaisEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre FROM Pais WHERE 1=1");

        boolean filtrarPorId = entity != null && entity.getId() != null;
        boolean filtrarPorNombre = entity != null && entity.getNombre() != null && !entity.getNombre().isBlank();

        if (filtrarPorId) {
            sentenciaSQL.append(" AND id = ?");
        }
        if (filtrarPorNombre) {
            sentenciaSQL.append(" AND nombre LIKE ?");
        }

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {
            int parametroIndex = 1;

            if (filtrarPorId) {
                sentenciaPreparada.setObject(parametroIndex++, entity.getId());
            }
            if (filtrarPorNombre) {
                sentenciaPreparada.setString(parametroIndex++, "%" + entity.getNombre().trim() + "%");
            }

            try (var cursorResultados = sentenciaPreparada.executeQuery()) {
                while (cursorResultados.next()) {
                    var pais = new PaisEntity();
                    pais.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    pais.setNombre(cursorResultados.getString("nombre"));
                    listaPaises.add(pais);
                }
            }
        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de listar países filtrados.";
            var mensajeUsuario = "Se ha producido un problema tratando de obtener la lista de países filtrados.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de listar países filtrados.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de obtener la lista de países filtrados.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaPaises;
    }


    @Override
    public List<PaisEntity> listAll() throws OnlineTestException {
        var listaPaises = new ArrayList<PaisEntity>();
        var sentenciaSQL = new StringBuilder();
        sentenciaSQL.append("SELECT id, nombre FROM Pais");

        try (var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString());
             var cursorResultados = sentenciaPreparada.executeQuery()) {

            while (cursorResultados.next()) {
                var pais = new PaisEntity();
                pais.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                pais.setNombre(cursorResultados.getString("nombre"));
                listaPaises.add(pais);
            }

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de listar todos los países en la base de datos.";
            var mensajeUsuario = "Se ha producido un problema tratando de obtener la lista de países.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de listar todos los países en la base de datos.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de obtener la lista de países.";
            throw DataOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        }

        return listaPaises;
    }


    @Override
    public PaisEntity listById(UUID id) throws OnlineTestException {

        var paisEntityRetorno = new PaisEntity();

        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, nombre FROM Pais WHERE id=?");

        try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {

            sentenciaPreparada.setObject(1, id);

            try (var cursorResultados = sentenciaPreparada.executeQuery()) {

                if (cursorResultados.next()) {
                    paisEntityRetorno.setId(UtilUUID.convertirAUUID(cursorResultados.getString("id")));
                    paisEntityRetorno.setNombre(cursorResultados.getString("nombre"));

                }
            }


        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de de hacer SELECT  en al tabla pais por id";
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la infomacion del pais con el identificador deseado";

            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo SQLException tratando de de hacer SELECT  en al tabla pais por id";
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de consultar la infomacion del pais con el identificador deseado";


            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);
        }
        return paisEntityRetorno;
    }

    @Override
    public void update(UUID id, PaisEntity entity) throws OnlineTestException {

        var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("UPDATE  Pais SET nombre=? WHERE id=?");

        try(var sentenciaPreparada = conexion.prepareStatement(sentenciaSQL.toString())) {


            sentenciaPreparada.setObject(1, entity.getNombre());
            sentenciaPreparada.setObject(2, id);



            sentenciaPreparada.executeUpdate();

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción  de tipo SQLException tratando de MODIFICAR la información de un país deseado en la base de datos. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema tratando de modificar la información de un nuevo país.";
            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        } catch (Exception exception) {

            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo exception tratando de MODIFICAR la información de un país deseado en la base de datos. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema INESPERADO tratando de modificar la información de un nuevo país.";

            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);
        }


    }

    @Override
    public void updateById(UUID uuid, PaisEntity entity) {

    }
}
