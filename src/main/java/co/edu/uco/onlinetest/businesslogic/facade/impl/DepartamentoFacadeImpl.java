package co.edu.uco.onlinetest.businesslogic.facade.impl;

import co.edu.uco.onlinetest.businesslogic.businesslogic.DepartamentoBusinessLogic;
import co.edu.uco.onlinetest.businesslogic.businesslogic.impl.DepartamentoBusinessLogicImpl;
import co.edu.uco.onlinetest.businesslogic.facade.DepartamentoFacade;
import co.edu.uco.onlinetest.data.dao.factory.DAOFactory;
import co.edu.uco.onlinetest.data.dao.factory.Factory;
import co.edu.uco.onlinetest.dto.DepartamentoDTO;

import java.util.List;
import java.util.UUID;

public class DepartamentoFacadeImpl implements DepartamentoFacade {

    private final DAOFactory daoFactory;
    private final DepartamentoBusinessLogic departamentoBusinessLogic;

    public DepartamentoFacadeImpl() {
        this.daoFactory = DAOFactory.getFactory(Factory.AZURE_SQL);
        this.departamentoBusinessLogic = new DepartamentoBusinessLogicImpl(daoFactory);
    }

    @Override
    public void registrarNuevoDepartamento(DepartamentoDTO departamento) {
        // Lógica para registrar un nuevo departamento
    }

    @Override
    public void modificarDepartamento(UUID id, DepartamentoDTO departamento) {
        // Lógica para modificar un departamento
    }

    @Override
    public void darBajaDefinitivaDepartamentoExistente(UUID id) {
        // Lógica para dar de baja un departamento
    }

    @Override
    public DepartamentoDTO consultarDepartamentoPorId(UUID id) {
        return null; // Implementar consulta por ID
    }

    @Override
    public List<DepartamentoDTO> consultarDepartamentosPorFiltro(DepartamentoDTO filtro) {
        return List.of(); // Implementar consulta por filtro
    }
}

