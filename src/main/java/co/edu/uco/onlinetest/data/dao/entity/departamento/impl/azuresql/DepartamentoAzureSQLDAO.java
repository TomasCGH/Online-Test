package co.edu.uco.onlinetest.data.dao.entity.departamento.impl.azuresql;

import co.edu.uco.onlinetest.data.dao.entity.departamento.DepartamentoDAO;
import co.edu.uco.onlinetest.data.dao.entity.pais.PaisDAO;
import co.edu.uco.onlinetest.entity.DepartamentoEntity;
import co.edu.uco.onlinetest.entity.PaisEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class DepartamentoAzureSQLDAO implements DepartamentoDAO {
    
    private Connection connection;

    public DepartamentoAzureSQLDAO(Connection conexion) {
    }


    @Override
    public void create(DepartamentoEntity entity) {

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
    public DepartamentoEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void updateById(UUID uuid, DepartamentoEntity entity) {

    }
}
