package co.edu.uco.onlinetest.businesslogic.facade.impl;

import co.edu.uco.onlinetest.businesslogic.businesslogic.CiudadBusinessLogic;
import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.onlinetest.businesslogic.businesslogic.impl.CiudadBusinessLogicImpl;
import co.edu.uco.onlinetest.businesslogic.facade.CiudadFacade;
import co.edu.uco.onlinetest.crosscutting.excepciones.BusinessLogicOnlineTestException;
import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;
import co.edu.uco.onlinetest.data.dao.factory.DAOFactory;
import co.edu.uco.onlinetest.data.dao.factory.Factory;
import co.edu.uco.onlinetest.dto.CiudadDTO;

import java.util.List;
import java.util.UUID;

public class CiudadFacadeImpl implements CiudadFacade {

    private DAOFactory daoFactory;
    private CiudadBusinessLogic ciudadBusinessLogic;

    public CiudadFacadeImpl() throws OnlineTestException {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        ciudadBusinessLogic = new CiudadBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevaCiudad(CiudadDTO ciudad) throws OnlineTestException {
        try {
            daoFactory.iniciartransaccion();

            // Aquí debes convertir CiudadDTO a CiudadDomain
            CiudadDomain ciudadDomain = null;

            ciudadBusinessLogic.registrarNuevaCiudad(ciudadDomain);

            daoFactory.confirmartransaccion();

        } catch (OnlineTestException exception) {
            daoFactory.cancelartransaccion();
            throw exception;

        } catch (Exception exception) {
            daoFactory.cancelartransaccion();

            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA mientras se intentaba registrar una nueva ciudad en la base de datos. Por favor, revise el log de errores para más detalles técnicos.";
            var mensajeUsuario = "Se ha producido un problema INESPERADO al tratar de registrar una nueva ciudad. Por favor, intente nuevamente más tarde o contacte al soporte técnico si el problema persiste.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } finally {
            daoFactory.cerrarConexion();
        }
    }


    @Override
    public void modificarCiudadExistente(UUID id, CiudadDTO ciudad) throws OnlineTestException {
        try {
            daoFactory.iniciartransaccion();

            CiudadDomain ciudadDomain = null; // Aquí va la conversión DTO → Domain pendiente

            ciudadBusinessLogic.modificarCiudadExistente(id, ciudadDomain);

            daoFactory.confirmartransaccion();

        } catch (OnlineTestException exception) {
            daoFactory.cancelartransaccion();
            throw exception;

        } catch (Exception exception) {
            daoFactory.cancelartransaccion();

            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA mientras se intentaba modificar la información de una ciudad existente en la base de datos. Por favor, revise el log de errores para más detalles.";
            var mensajeUsuario = "Se ha producido un problema inesperado al tratar de modificar la información de la ciudad. Por favor, intente nuevamente más tarde.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } finally {
            daoFactory.cerrarConexion();
        }
    }


    @Override
    public void darbajaDefinitivamenteCiudadExistente(UUID id) throws OnlineTestException {
        try {
            daoFactory.iniciartransaccion();

            ciudadBusinessLogic.darbajaDefinitivamenteCiudadExistente(id);

            daoFactory.confirmartransaccion();

        } catch (OnlineTestException e) {
            daoFactory.cancelartransaccion();
            throw e;

        } catch (Exception e) {
            daoFactory.cancelartransaccion();

            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA mientras se intentaba dar de baja definitivamente una ciudad existente en la base de datos. Por favor, revise el log de errores para más detalles.";
            var mensajeUsuario = "Se ha producido un problema inesperado al tratar de eliminar definitivamente la ciudad. Por favor, intente nuevamente más tarde.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, e);

        } finally {
            daoFactory.cerrarConexion();
        }
    }


    @Override
    public CiudadDTO consultarCiudadPorId(UUID id) throws OnlineTestException {
        try {
            var ciudadDomain = ciudadBusinessLogic.consultarCiudadPorId(id);
            // Aquí va la conversión Domain -> DTO
            return null;

        } catch (OnlineTestException e) {
            throw e;

        } catch (Exception e) {
            daoFactory.cancelartransaccion();

            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de consultar la información de una ciudad deseada. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de consultar la información de la ciudad con el identificador deseado.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, e);

        } finally {
            daoFactory.cerrarConexion();
        }
    }


    @Override
    public List<CiudadDTO> consultarCiudades(CiudadDTO filtro) throws OnlineTestException {
        try {
            // Aquí convierte el filtro DTO a Domain para consulta
            CiudadDomain filtroDomain = null;

            List<CiudadDomain> listaDomain = ciudadBusinessLogic.consultarCiudades(filtroDomain);

            // Aquí convierte la lista Domain a lista DTO para devolver
            List<CiudadDTO> listaDTO = null; // conversión pendiente

            return listaDTO;

        } catch (OnlineTestException e) {
            throw e;

        } catch (Exception e) {
            var mensajeTecnico = "Se presentó una excepción inesperada tratando de consultar ciudades con filtro.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de consultar ciudades.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, e);

        } finally {
            daoFactory.cerrarConexion();
        }
    }

}
