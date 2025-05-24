package co.edu.uco.onlinetest.businesslogic.businesslogic.impl;

import co.edu.uco.onlinetest.businesslogic.businesslogic.PaisBusinessLogic;
import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;
import co.edu.uco.onlinetest.data.dao.factory.DAOFactory;
import co.edu.uco.onlinetest.entity.PaisEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaisBusinessLogicImpl implements PaisBusinessLogic {


    private DAOFactory factory;



    public PaisBusinessLogicImpl(DAOFactory factory)  {
        this.factory = factory;
    }


    @Override
    public void registrarNuevoPais(PaisDomain pais) throws OnlineTestException {
        PaisEntity paisEntity = null; //  magia de traducir de domain a entity
        factory.getPaisDAO().create(paisEntity);

    }

    @Override
    public void modificarPaisExistente(UUID id, PaisDomain pais) throws OnlineTestException {
        PaisEntity paisEntity = null;  //  magia de traducir de domain a entity
        factory.getPaisDAO().update(id,paisEntity);

    }

    @Override
    public void darbajaDefinitivamentePaisExistente(UUID id) throws OnlineTestException {
        factory.getPaisDAO().delete(id);


    }

    @Override
    public PaisDomain consultarPaisPorId(UUID id) {
        return null;
    }

    @Override
    public List<PaisDomain> consultarPaises(PaisDomain filtro) throws OnlineTestException {
        PaisEntity paisFilter = null;
        List<PaisEntity> paisEntities = factory.getPaisDAO().listByFilter(paisFilter);
        List<PaisDomain> datosARetornar = null;

        return datosARetornar;
    }
}
