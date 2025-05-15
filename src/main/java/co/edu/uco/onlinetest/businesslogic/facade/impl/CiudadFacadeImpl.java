package co.edu.uco.onlinetest.businesslogic.facade.impl;

import co.edu.uco.onlinetest.businesslogic.businesslogic.CiudadBusinessLogic;
import co.edu.uco.onlinetest.businesslogic.businesslogic.impl.CiudadBusinessLogicImpl;
import co.edu.uco.onlinetest.businesslogic.facade.CiudadFacade;
import co.edu.uco.onlinetest.data.dao.factory.DAOFactory;
import co.edu.uco.onlinetest.data.dao.factory.Factory;
import co.edu.uco.onlinetest.dto.CiudadDTO;

import java.util.List;
import java.util.UUID;

public class CiudadFacadeImpl implements CiudadFacade {

    private final DAOFactory daoFactory;
    private final CiudadBusinessLogic ciudadBusinessLogic;

    public CiudadFacadeImpl() {
        this.daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        this.ciudadBusinessLogic = new CiudadBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevaCiudad(CiudadDTO ciudad) {
        // Lógica para registrar una nueva ciudad
    }

    @Override
    public void modificarCiudad(UUID id, CiudadDTO ciudad) {
        // Lógica para modificar una ciudad
    }

    @Override
    public void darBajaDefinitivaCiudadExistente(UUID id) {
        // Lógica para dar de baja una ciudad
    }

    @Override
    public CiudadDTO consultarCiudadPorId(UUID id) {
        return null; // Implementar consulta por ID
    }

    @Override
    public List<CiudadDTO> consultarCiudadesPorFiltro(CiudadDTO filtro) {
        return List.of(); // Implementar consulta por filtro
    }
}
