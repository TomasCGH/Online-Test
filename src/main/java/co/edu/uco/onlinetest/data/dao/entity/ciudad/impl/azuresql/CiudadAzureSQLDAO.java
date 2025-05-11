package co.edu.uco.onlinetest.data.dao.entity.ciudad.impl.azuresql;

import co.edu.uco.onlinetest.data.dao.entity.ciudad.CiudadDAO;
import co.edu.uco.onlinetest.entity.CiudadEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public class CiudadAzureSQLDAO implements CiudadDAO {

    public CiudadAzureSQLDAO(Connection conexion) {
    }

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
