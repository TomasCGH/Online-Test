package co.edu.uco.onlinetest.data.dao.entity.pais.impl.azuresql;

import co.edu.uco.onlinetest.data.dao.entity.pais.PaisDAO;
import co.edu.uco.onlinetest.entity.PaisEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class PaisAzureSQLDAO implements PaisDAO {

    private Connection connection;

    public PaisAzureSQLDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void create(PaisEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<PaisEntity> listByFilter(PaisEntity filter) {
        return List.of();
    }

    @Override
    public List<PaisEntity> listAll() {
        return List.of();
    }

    @Override
    public PaisEntity listById(UUID uuid) {
        return null;
    }

    @Override
    public void updateById(UUID uuid, PaisEntity entity) {

    }
}
