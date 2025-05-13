package co.edu.uco.onlinetest.businesslogic.businesslogic.impl;

import co.edu.uco.onlinetest.businesslogic.businesslogic.PaisBusinessLogic;
import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.PaisDomain;

import java.util.List;
import java.util.UUID;

public class CiudadBusinessLogicImpl implements PaisBusinessLogic {


    @Override
    public void registrarNuevoPais(PaisDomain pais) {

    }

    @Override
    public void modificarPaisExistente(UUID id, PaisDomain pais) {

    }

    @Override
    public void darBajaDefinitivamentePaisExistente(UUID id) {

    }

    @Override
    public PaisDomain consultarPaisPorId(UUID id) {
        return null;
    }

    @Override
    public List<PaisDomain> consultarPaises(PaisDomain filtro) {
        return List.of();
    }
}
