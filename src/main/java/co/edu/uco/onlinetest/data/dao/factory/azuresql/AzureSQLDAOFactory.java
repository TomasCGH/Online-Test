package co.edu.uco.onlinetest.data.dao.factory.azuresql;

import co.edu.uco.onlinetest.crosscutting.excepciones.DataOnlineTestException;
import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;
import co.edu.uco.onlinetest.data.dao.entity.departamento.impl.azuresql.DepartamentoAzureSQLDAO;
import co.edu.uco.onlinetest.data.dao.entity.ciudad.CiudadDao;
import co.edu.uco.onlinetest.data.dao.entity.ciudad.impl.azuresql.CiudadAzureSQLDAO;
import co.edu.uco.onlinetest.data.dao.entity.pais.impl.azuresql.PaisAzureSQLDAO;
import co.edu.uco.onlinetest.data.dao.factory.DAOFactory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AzureSQLDAOFactory extends DAOFactory {

    private Connection conexion;
    private boolean transaccionEstaIniciada = false;
    private boolean connexionEstaAbierta = false;



    public AzureSQLDAOFactory() throws OnlineTestException {
        abrirConexion();
        transaccionEstaIniciada = false;
        connexionEstaAbierta = false;

    }


    @Override
    public void abrirConexion() throws OnlineTestException {
        var baseDatos = "ONLOINTTEST";
        var servidor = "ORION.UCO.CO";

        try {
            DriverManager.getConnection("");
            connexionEstaAbierta = true;

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presento una excepcion de tipo  SQLException tratando de obtener la conexion con la base de datos "
                    +baseDatos +" EN LE SERVIDOR "+servidor+" para tener mas detalles revise el log de errores ";
            var mensajeUsuario = "Se ha presentado un problema tratando de obtener la conexion con la fuente de datos para llevar a cabo la operacion deseada";


            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        } catch (Exception exception) {
            var mensajeTecnico = "Se presento una excepcion  NO CONTROLADA de tipo  SQLException tratando de obtener la conexion con la base de datos "
                    +baseDatos +" EN LE SERVIDOR "+servidor+" para tener mas detalles revise el log de errores ";
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de obtener la conexion con la fuente de datos para llevar a cabo la operacion deseada";


            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        }


    }

    @Override
    public void iniciartransaccion() throws OnlineTestException {

        try {
            asegurarConexionAbierta();
            asegurarTransaccionIniciada();
            conexion.setAutoCommit(false);


        } catch (OnlineTestException exception) {
            throw exception;

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presento una excepcion  de tipo  SQLException tratando de iniciar la transaccion sobre la conexion con la base de datos, para tener mas detalles revise el log de errores ";
            var mensajeUsuario = "Se ha presentado un problema  tratando de iniciar la transaccion con la fuente de datos para llevar a cabo la operacion deseada";


            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        } catch (Exception exception) {
            var mensajeTecnico = "Se presento una excepcion NO CONTROLADA de tipo  SQLException tratando de iniciar la transaccion sobre la conexion con la base de datos, para tener mas detalles revise el log de errores ";
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de iniciar la transaccion con la fuente de datos para llevar a cabo la operacion deseada";


            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        }




    }

    @Override
    public void confirmartransaccion() throws OnlineTestException {

        try {
            asegurarConexionAbierta();
            asegurarTransaccionIniciada();
            conexion.commit();

        }catch (OnlineTestException exception){
            throw exception;


        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción de tipo SQLException tratando de CONFIRMAR la transacción sobre la conexión con la base de datos, para tener más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema  tratando de confirmar la transacción con la fuente de datos para llevar a cabo la operación deseada";

            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo SQLException tratando de CONFIRMAR la transacción sobre la conexión con la base de datos, para tener más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de confirmar la transacción con la fuente de datos para llevar a cabo la operación deseada";


            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        }

    }

    @Override
    public void cancelartransaccion() throws OnlineTestException{



        try {
            asegurarConexionAbierta();
            asegurarTransaccionIniciada();
            conexion.rollback();

        }catch (OnlineTestException exception){
            throw exception;



        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción  de tipo SQLException tratando de CANCELAR la transacción sobre la conexión con la base de datos, para tener más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema  tratando de cancelar la transacción con la fuente de datos para revertir la operación realizada";


             throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo SQLException tratando de CANCELAR la transacción sobre la conexión con la base de datos, para tener más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de cancelar la transacción con la fuente de datos para revertir la operación realizada";

            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        }

    }

    @Override
    public void iniciarTransacion() {

    }

    @Override
    public void confirmarTransacion() {

    }

    @Override
    public void cancelarTransacion() {

    }

    @Override
    public void cerrarConexion() throws OnlineTestException {

        try {
            asegurarConexionAbierta();
            asegurarTransaccionIniciada();
            conexion.close();

        } catch (OnlineTestException exception) {
            throw exception;

        } catch (SQLException exception) {
            var mensajeTecnico = "Se presentó una excepción  de tipo SQLException tratando de CERRAR la conexión con la base de datos, para tener más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema  tratando de cerrar la conexión con la fuente de datos luego de realizar la operación";

            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA de tipo SQLException tratando de CERRAR la conexión con la base de datos, para tener más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de cerrar la conexión con la fuente de datos luego de realizar la operación";

            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);


        }

    }

    private void asegurarTransaccionIniciada() throws OnlineTestException {

        if (!transaccionEstaIniciada) {
            var mensajeTecnico = "Se presentó una excepción tratando de gestionar(COMMIT,ROLLBACK la conexión con la base de datos, para tener más detalles revise el log de errores";
            var mensajeUsuario = "Se ha presentado un problema INESPERADO tratando de gestionar la conexión con la fuente de datos luego de realizar la operación";

           throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico);


        }
    }


    private void asegurarConexionAbierta() throws OnlineTestException {

        if (!connexionEstaAbierta) {
            var mensajeTecnico = "Se intento llevar a cabo una operacion que requeria una conexion abierta, pero al momento de validarla esta cerrada";
            var mensajeUsuario = "Se presentó una excepción tratando de llevar a cabo operacion deseada con la conexión cerrada...";

            throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico);


        }
    }

    @Override
    public PaisAzureSQLDAO getPaisDAO() throws OnlineTestException{
        asegurarConexionAbierta();
        return new PaisAzureSQLDAO(conexion);
    }

    @Override
    public DepartamentoAzureSQLDAO getDepartamentoDAO() throws OnlineTestException{
        asegurarConexionAbierta();
        return new DepartamentoAzureSQLDAO(conexion);
    }

    @Override
    public CiudadDao getCiudadDAO() throws OnlineTestException{
        asegurarConexionAbierta();
        return new CiudadAzureSQLDAO(conexion);
    }
}
