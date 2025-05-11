package co.edu.uco.onlinetest.data.dao.factory.azuresql;

import co.edu.uco.onlinetest.data.dao.entity.ciudad.impl.azuresql.CiudadAzureSQLDAO;
import co.edu.uco.onlinetest.data.dao.entity.ciudad.CiudadDAO;
import co.edu.uco.onlinetest.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.onlinetest.data.dao.entity.departamento.impl.azuresql.DepartamentoAzureSQLDAO;
import co.edu.uco.onlinetest.data.dao.entity.pais.PaisDAO;
import co.edu.uco.onlinetest.data.dao.entity.pais.impl.azuresql.PaisAzureSQLDAO;
import co.edu.uco.onlinetest.data.dao.factory.DAOFactory;

import java.sql.Connection;

public class AzureSQLDAOFactory extends DAOFactory {

    private Connection conexion;
    @Override
    public void abrirConexion() {

    }

    @Override
    public void iniciarTransaccion() {

    }

    @Override
    public void confirmarTransaccion() {

    }

    @Override
    public void cancelarTransaccion() {

    }

    @Override
    public void cerrarConexion() {

    }

    @Override
    public PaisDAO getPaisDAO() {
        return new PaisAzureSQLDAO(conexion);
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        return new DepartamentoAzureSQLDAO(conexion);
    }

    @Override
    public CiudadDAO getCiudadDAO() {
        return new CiudadAzureSQLDAO(conexion);
    }
}
