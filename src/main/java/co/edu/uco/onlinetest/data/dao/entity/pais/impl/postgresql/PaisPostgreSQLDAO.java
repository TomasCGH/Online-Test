package co.edu.uco.onlinetest.data.dao.entity.pais.impl.postgresql;

import co.edu.uco.onlinetest.data.dao.entity.pais.PaisDAO;
import co.edu.uco.onlinetest.entity.PaisEntity;

import java.util.List;
import java.util.UUID;

public class PaisPostgreSQLDAO implements PaisDAO {

    @Override
    public List<PaisEntity> listByFilter(PaisEntity filter) {
        return List.of();
    }

    @Override
    public List<PaisEntity> listAll() {
        return List.of();
    }

    @Override
    public PaisEntity ListById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, PaisEntity entity) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public PaisEntity create(PaisEntity entity) {
        return null;
    }
}
