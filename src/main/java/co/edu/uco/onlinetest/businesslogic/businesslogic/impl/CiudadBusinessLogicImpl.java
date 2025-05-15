package co.edu.uco.onlinetest.businesslogic.businesslogic.impl;

import co.edu.uco.onlinetest.businesslogic.businesslogic.CiudadBusinessLogic;
import co.edu.uco.onlinetest.businesslogic.businesslogic.PaisBusinessLogic;
import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.onlinetest.data.dao.factory.DAOFactory;

import java.util.List;
import java.util.UUID;

public class CiudadBusinessLogicImpl implements CiudadBusinessLogic {

    private DAOFactory factory;

    public CiudadBusinessLogicImpl(DAOFactory daoFactory) {
    this.factory = daoFactory;
    }


    @Override
    public void registrarNuevoCiudad(CiudadDomain pais) {

    }

    @Override
    public void modificarCiudadExistente(UUID id, CiudadDomain pais) {

    }

    @Override
    public void darBajaDefinitivamenteCiudadExistente(UUID id) {

    }

    @Override
    public CiudadDomain consultarCiudadPorId(UUID id) {
        return null;
    }

    @Override
    public List<CiudadDomain> consultarCiudad(CiudadDomain filtro) {
        return List.of();
    }
}
