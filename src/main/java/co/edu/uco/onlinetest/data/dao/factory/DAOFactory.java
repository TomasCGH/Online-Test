package co.edu.uco.onlinetest.data.dao.factory;

import co.edu.uco.onlinetest.data.dao.entity.ciudad.CiudadDAO;
import co.edu.uco.onlinetest.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.onlinetest.data.dao.entity.pais.PaisDAO;
import co.edu.uco.onlinetest.data.dao.factory.azuresql.AzureSQLDAOFactory;

public abstract class DAOFactory {


    public static DAOFactory getFactory(Factory factory) {
        switch (factory) {
            case Azure_SQL:
                return new AzureSQLDAOFactory();
            default:
                throw  new IllegalArgumentException("No se encontro el DAOFactory");
        }

    }

    public abstract void abrirConexion();

    public abstract void iniciarTransaccion();

    public abstract void confirmarTransaccion();

    public abstract void cancelarTransaccion();

    public abstract void cerrarConexion();

    public abstract PaisDAO getPaisDAO();

    public abstract DepartamentoDAO getDepartamentoDAO();

    public abstract CiudadDAO getCiudadDAO();
}
