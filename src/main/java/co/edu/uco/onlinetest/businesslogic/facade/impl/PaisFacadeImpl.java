package co.edu.uco.onlinetest.businesslogic.facade.impl;

import co.edu.uco.onlinetest.businesslogic.businesslogic.PaisBusinessLogic;
import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.onlinetest.businesslogic.businesslogic.impl.PaisBusinessLogicImpl;
import co.edu.uco.onlinetest.businesslogic.facade.PaisFacade;
import co.edu.uco.onlinetest.crosscutting.excepciones.BusinessLogicOnlineTestException;
import co.edu.uco.onlinetest.crosscutting.excepciones.DataOnlineTestException;
import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;
import co.edu.uco.onlinetest.data.dao.factory.DAOFactory;
import co.edu.uco.onlinetest.data.dao.factory.Factory;
import co.edu.uco.onlinetest.dto.PaisDTO;

import java.util.List;
import java.util.UUID;

public class PaisFacadeImpl implements PaisFacade {

    private DAOFactory daoFactory;
    private PaisBusinessLogic paisBusinessLogic;


    public PaisFacadeImpl() throws OnlineTestException {
        daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        paisBusinessLogic = new PaisBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoPais(PaisDTO pais) throws OnlineTestException {


        try {
            daoFactory.iniciartransaccion();

            PaisDomain paisDomain = null; //la magia de convertir de dto a domain
            paisBusinessLogic.registrarNuevoPais(paisDomain);
            daoFactory.confirmartransaccion();

        }catch (OnlineTestException excepcion) {
            daoFactory.cancelartransaccion();
            throw excepcion;
        }catch (Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción  de tipo exception NO CONTROLADA  tratando de REGISTRAR la información de un nuevo país. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema INESPERADO tratando de registrar la información de un nuevo país.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);
        } finally {
            daoFactory.cerrarConexion();
        }

    }

    @Override
    public void modificarPaisExistente(UUID id, PaisDTO pais) throws OnlineTestException {
        try {
            daoFactory.iniciartransaccion();


            PaisDomain paisDomain = null; //la magia de convertir de dto a domain

            paisBusinessLogic.modificarPaisExistente(id,paisDomain);

            daoFactory.confirmartransaccion();

        } catch (OnlineTestException exception) {
            daoFactory.cancelartransaccion();
            throw exception;

        } catch (Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de MODIFICAR la información de un país existente. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de modificar la información de un país.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } finally {
            daoFactory.cerrarConexion();
        }
    }


    @Override
    public void darbajaDefinitivamentePaisExistente(UUID id) throws OnlineTestException {
        try {
            daoFactory.iniciartransaccion();

            paisBusinessLogic.darbajaDefinitivamentePaisExistente(id);

            daoFactory.confirmartransaccion();

        } catch (OnlineTestException exception) {
            daoFactory.cancelartransaccion();
            throw exception;

        } catch (Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción NO CONTROLADA tratando de DAR DE BAJA DEFINITIVAMENTE un país existente. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de eliminar la información de un país.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);

        } finally {
            daoFactory.cerrarConexion();
        }
    }


    @Override
    public PaisDTO consultarPaisPorId(UUID id) throws OnlineTestException {

        try {

            var paisDomainResultado = paisBusinessLogic.consultarPaisPorId(id);
            //Magia de convertir ddomain a DTO de repuesta
            return null;

        }catch (OnlineTestException excepcion) {
            throw excepcion;
        }catch (Exception exception) {
            daoFactory.cancelartransaccion();
            var mensajeTecnico = "Se presentó una excepción  de tipo exception NO CONTROLADA  tratando de consultar la información de un país deseado. Para más detalles revise el log de errores.";
            var mensajeUsuario = "Se ha producido un problema INESPERADO tratando de consultar la información del país con el identificador deseado.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario,mensajeTecnico,exception);
        } finally {
            daoFactory.cerrarConexion();
        }

    }

    @Override
    public List<PaisDTO> consultarPais(PaisDTO filtro) throws OnlineTestException {
        try {

            PaisDomain paisDomain = null; //falta la implementacion de domain a dto
            var paisDomainResultado = paisBusinessLogic.consultarPaises(paisDomain);

            return null;

        } catch (OnlineTestException exception) {
            throw exception;

        } catch (Exception exception) {
            var mensajeTecnico = "Se presentó una excepción inesperada tratando de consultar países con filtro.";
            var mensajeUsuario = "Se ha producido un problema inesperado tratando de consultar países.";

            throw BusinessLogicOnlineTestException.reportar(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

}
