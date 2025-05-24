package co.edu.uco.onlinetest.data.dao.factory.postgresql;

import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;
import co.edu.uco.onlinetest.data.dao.entity.ciudad.impl.postgresql.CiudadPostgreSQLDAO;
import co.edu.uco.onlinetest.data.dao.entity.departamento.impl.azuresql.DepartamentoAzureSQLDAO;
import co.edu.uco.onlinetest.data.dao.entity.departamento.impl.postgresql.DepartamentoPostgreSQLDAO;
import co.edu.uco.onlinetest.data.dao.entity.pais.impl.azuresql.PaisAzureSQLDAO;
import co.edu.uco.onlinetest.data.dao.entity.pais.impl.postgresql.PaisPostgreSQLDAO;
import co.edu.uco.onlinetest.data.dao.factory.DAOFactory;

import java.sql.Connection;

public class PostgreSQLDAOFactory extends DAOFactory {

    private Connection conexion;

    public PostgreSQLDAOFactory() {
        abrirConexion();
    }

    @Override
    public void abrirConexion() {
        conexion = null;
    }

    @Override
    public void iniciartransaccion() throws OnlineTestException {

    }

    @Override
    public void confirmartransaccion() throws OnlineTestException {

    }

    @Override
    public void cancelartransaccion() throws OnlineTestException {

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
    public void cerrarConexion() {

    }

    @Override
    public PaisAzureSQLDAO getPaisDAO() {
        return new PaisPostgreSQLDAO(conexion);
    }

    @Override
    public DepartamentoAzureSQLDAO getDepartamentoDAO() {
        return new DepartamentoPostgreSQLDAO(conexion);
    }

    @Override
    public CiudadPostgreSQLDAO getCiudadDAO() {
        return new CiudadPostgreSQLDAO(conexion);
    }
}
