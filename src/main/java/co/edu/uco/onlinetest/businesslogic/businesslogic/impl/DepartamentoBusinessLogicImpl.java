package co.edu.uco.onlinetest.businesslogic.bussinesslogic.impl;

import co.edu.uco.onlinetest.businesslogic.businesslogic.DepartamentoBusinessLogic;
import co.edu.uco.onlinetest.businesslogic.businesslogic.PaisBusinessLogic;
import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.PaisDomain;
import co.edu.uco.onlinetest.data.dao.factory.DAOFactory;
import co.edu.uco.onlinetest.entity.DepartamentoEntity;

import java.util.List;
import java.util.UUID;

    public class DepartamentoBusinessLogicImpl implements DepartamentoBusinessLogic {

    private DAOFactory factory;

    public DepartamentoBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void registrarNuevoDepartamento(DepartamentoDomain departamento) {
        DepartamentoEntity departamentoEntity = new DepartamentoEntity();
        factory.getPaisDAO().create(departamentoEntity.getPais());
    }

    @Override
    public void modificarDepartamentoExistente(UUID id, DepartamentoDomain departamento) {
        DepartamentoEntity departamentoEntity = new DepartamentoEntity();
        factory.getDepartamentoDAO().updateById(id, departamentoEntity);
    }

    @Override
    public void darBajaDefinitivamenteDepartamentoExistente(UUID id) {
        factory.getDepartamentoDAO().delete(id);
    }

    @Override
    public DepartamentoDomain consultarDepartamentoPorId(UUID id) {
        return null;
    }

    @Override
    public List<DepartamentoDomain> consultarDepartamento(DepartamentoDomain filtro) {
        return List.of();
    }
}
