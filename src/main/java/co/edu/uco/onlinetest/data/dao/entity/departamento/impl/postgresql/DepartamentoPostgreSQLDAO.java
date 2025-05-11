package co.edu.uco.onlinetest.data.dao.entity.departamento.impl.postgresql;

import co.edu.uco.onlinetest.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.onlinetest.entity.DepartamentoEntity;

import java.util.List;
import java.util.UUID;

public class DepartamentoPostgreSQLDAO implements DepartamentoDAO {
    @Override
    public DepartamentoEntity create(DepartamentoEntity entity) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<DepartamentoEntity> listByFilter(DepartamentoEntity filter) {
        return List.of();
    }

    @Override
    public List<DepartamentoEntity> listAll() {
        return List.of();
    }

    @Override
    public DepartamentoEntity ListById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, DepartamentoEntity entity) {

    }
}
