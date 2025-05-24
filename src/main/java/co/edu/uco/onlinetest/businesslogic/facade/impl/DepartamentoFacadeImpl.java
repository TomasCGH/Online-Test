package co.edu.uco.onlinetest.businesslogic.facade.impl;

import co.edu.uco.onlinetest.businesslogic.businesslogic.DepartamentoBusinessLogic;
import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.uco.onlinetest.businesslogic.businesslogic.impl.DepartamentoBusinessLogicImpl;
import co.edu.uco.onlinetest.businesslogic.facade.DepartamentoFacade;
import co.edu.uco.onlinetest.crosscutting.excepciones.BusinessLogicOnlineTestException;
import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;
import co.edu.uco.onlinetest.data.dao.factory.DAOFactory;
import co.edu.uco.onlinetest.data.dao.factory.Factory;
import co.edu.uco.onlinetest.dto.DepartamentoDTO;

import java.util.List;
import java.util.UUID;

public class DepartamentoFacadeImpl implements DepartamentoFacade {

    private DAOFactory daoFactory;
    private DepartamentoBusinessLogic departamentoBusinessLogic;


    public DepartamentoFacadeImpl() throws OnlineTestException {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        departamentoBusinessLogic = new DepartamentoBusinessLogicImpl(daoFactory);

    }

    @Override
    public void registrarNuevoDepartamento(DepartamentoDTO departamento) throws OnlineTestException {
        try {
            daoFactory.iniciartransaccion();

            DepartamentoDomain departamentoDomain = null; // Aquí va la conversión DTO → Domain
            departamentoBusinessLogic.registrarNuevoDepartamento(departamentoDomain);

            daoFactory.confirmartransaccion();

        } catch (OnlineTestException exception) {
            daoFactory.cancelartransaccion();
            throw exception;

        } catch (Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción de tipo Exception NO CONTROLADA mientras se intentaba registrar un nuevo departamento en la base de datos. Por favor, revise el log de errores para más detalles técnicos.";
            var mensajeUsuario = "Se ha producido un problema INESPERADO al tratar de registrar un nuevo departamento. Por favor, intente nuevamente más tarde o contacte al soporte técnico.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } finally {
            daoFactory.cerrarConexion();
        }
    }


    @Override
    public void modificarDepartamentoExistente(UUID id, DepartamentoDTO departamento) throws OnlineTestException {
        try {
            daoFactory.iniciartransaccion();

            DepartamentoDomain departamentoDomain = null; // Aquí va la conversión DTO → Domain

            departamentoBusinessLogic.modificarDepartamentoExistente(id, departamentoDomain);

            daoFactory.confirmartransaccion();

        } catch (OnlineTestException exception) {
            daoFactory.cancelartransaccion();
            throw exception;

        } catch (Exception exception) {
            daoFactory.cancelartransaccion();

            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA mientras se intentaba modificar la información de un departamento existente en la base de datos. Para más detalles, por favor revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema inesperado al tratar de modificar la información del departamento.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } finally {
            daoFactory.cerrarConexion();
        }
    }

    @Override
    public void darbajaDefinitivamenteDepartamentoExistente(UUID id) throws OnlineTestException {
        try {
            daoFactory.iniciartransaccion();

            departamentoBusinessLogic.darbajaDefinitivamenteDepartamentoExistente(id);

            daoFactory.confirmartransaccion();

        } catch (OnlineTestException exception) {
            daoFactory.cancelartransaccion();
            throw exception;

        } catch (Exception exception) {
            daoFactory.cancelartransaccion();

            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA mientras se intentaba dar de baja definitivamente un departamento existente en la base de datos. Por favor, revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema inesperado al tratar de eliminar definitivamente el departamento.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } finally {
            daoFactory.cerrarConexion();
        }
    }


    @Override
    public DepartamentoDTO consultarDepartamentoPorId(UUID id) throws OnlineTestException {
        try {
            var departamentoDomainResultado = departamentoBusinessLogic.consultarDepartamentoPorId(id);
            // Magia de convertir domain a DTO de respuesta
            return null;

        } catch (OnlineTestException excepcion) {
            throw excepcion;

        } catch (Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción de tipo exception NO CONTROLADA tratando de consultar la información de un departamento deseado. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema INESPERADO tratando de consultar la información del departamento con el identificador deseado.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }



    @Override
    public List<DepartamentoDTO> consultarDepartamentos(DepartamentoDTO filtro) throws OnlineTestException {
        try {
            DepartamentoDomain departamentoDomain = null; // Aquí va la conversión DTO → Domain
            List<DepartamentoDomain> departamentosDomain = departamentoBusinessLogic.consultarDepartamentos(departamentoDomain);

            // Aquí deberías convertir la lista de domains a lista de DTOs
            List<DepartamentoDTO> departamentosDTO = null;

            return departamentosDTO;

        } catch (OnlineTestException e) {
            throw e;

        } catch (Exception e) {
            var mensajeTecnico = "Se presentó una excepción inesperada tratando de consultar departamentos con filtro.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de consultar departamentos.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, e);

        } finally {
            daoFactory.cerrarConexion();
        }
    }

}
