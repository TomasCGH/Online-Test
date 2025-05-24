package co.edu.uco.onlinetest.businesslogic.businesslogic.impl;

import co.edu.uco.onlinetest.businesslogic.businesslogic.CiudadBusinessLogic;
import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;
import co.edu.uco.onlinetest.data.dao.factory.DAOFactory;
import co.edu.uco.onlinetest.entity.CiudadEntity;

import java.util.List;
import java.util.UUID;

public class CiudadBusinessLogicImpl implements CiudadBusinessLogic {

    private final DAOFactory factory;

    public CiudadBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void registrarNuevaCiudad(CiudadDomain ciudad) throws OnlineTestException {
        CiudadEntity ciudadEntity = null;//  magia de traducir de domain a entity
        factory.getCiudadDAO().create(ciudadEntity);
    }

    @Override
    public void modificarCiudadExistente(UUID id, CiudadDomain ciudad) throws OnlineTestException {
        CiudadEntity ciudadEntity = null;//  magia de traducir de domain a entity
        factory.getCiudadDAO().update(id, ciudadEntity);
    }

    @Override
    public void darbajaDefinitivamenteCiudadExistente(UUID id) throws OnlineTestException {
        factory.getCiudadDAO().delete(id);
    }

    @Override
    public CiudadDomain consultarCiudadPorId(UUID id) {
        return null;
    }

    @Override
    public List<CiudadDomain> consultarCiudades(CiudadDomain filtro) throws OnlineTestException {
        CiudadEntity ciudadFilter = null;
        List<CiudadEntity> ciudadEntities = factory.getCiudadDAO().listByFilter(ciudadFilter);
        List<CiudadDomain> datosARetornar = null;

        return datosARetornar;
    }
}
