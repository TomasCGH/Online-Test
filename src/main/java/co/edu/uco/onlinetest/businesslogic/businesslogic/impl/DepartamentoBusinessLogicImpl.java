package co.edu.uco.onlinetest.businesslogic.businesslogic.impl;

import co.edu.uco.onlinetest.businesslogic.businesslogic.DepartamentoBusinessLogic;
import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.DepartamentoDomain;
import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;
import co.edu.uco.onlinetest.data.dao.factory.DAOFactory;
import co.edu.uco.onlinetest.entity.DepartamentoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DepartamentoBusinessLogicImpl implements DepartamentoBusinessLogic {

    private DAOFactory factory;

    public DepartamentoBusinessLogicImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void registrarNuevoDepartamento(DepartamentoDomain departamento) throws OnlineTestException {
        DepartamentoEntity departamentoEntity = null;//  magia de traducir de domain a entity
        factory.getDepartamentoDAO().create(departamentoEntity);
    }

    @Override
    public void modificarDepartamentoExistente(UUID id, DepartamentoDomain departamento) throws OnlineTestException {
        DepartamentoEntity departamentoEntity = null;//  magia de traducir de domain a entity
        factory.getDepartamentoDAO().update(id, departamentoEntity);
    }

    @Override
    public void darbajaDefinitivamenteDepartamentoExistente(UUID id) throws OnlineTestException {
        factory.getDepartamentoDAO().delete(id);
    }


    @Override
    public DepartamentoDomain consultarDepartamentoPorId(UUID id) {
        return null;
    }

    @Override
    public List<DepartamentoDomain> consultarDepartamentos(DepartamentoDomain filtro) throws OnlineTestException {
        DepartamentoEntity departamentoFilter = null;
        List<DepartamentoEntity> departamentoEntities = factory.getDepartamentoDAO().listByFilter(departamentoFilter);
        List<DepartamentoDomain> datosARetornar = null;

        return datosARetornar;
    }
}
