package co.edu.uco.onlinetest.data.dao.entity.ciudad.impl.postgresql;

import co.edu.uco.onlinetest.data.dao.entity.ciudad.CiudadDAO;
import co.edu.uco.onlinetest.entity.CiudadEntity;

import java.util.List;
import java.util.UUID;

public class CiudadPostgreSQLDAO implements CiudadDAO {
    @Override
    public CiudadEntity create(CiudadEntity entity) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<CiudadEntity> listByFilter(CiudadEntity filter) {
        return List.of();
    }

    @Override
    public List<CiudadEntity> listAll() {
        return List.of();
    }

    @Override
    public CiudadEntity ListById(UUID uuid) {
        return null;
    }

    @Override
    public void update(UUID uuid, CiudadEntity entity) {

    }
}
