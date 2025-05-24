package co.edu.uco.onlinetest.data.dao.entity.ciudad;

import co.edu.uco.onlinetest.data.dao.entity.CreateDAO;
import co.edu.uco.onlinetest.data.dao.entity.DeleteDAO;
import co.edu.uco.onlinetest.data.dao.entity.RetrieveDAO;
import co.edu.uco.onlinetest.data.dao.entity.UpdateDAO;
import co.edu.uco.onlinetest.entity.CiudadEntity;
import co.edu.uco.onlinetest.entity.PaisEntity;

import java.util.UUID;

public interface CiudadDao
        extends CreateDAO<CiudadEntity>, RetrieveDAO<CiudadEntity, UUID>, UpdateDAO<CiudadEntity, UUID>, DeleteDAO<UUID> {


    void updateById(UUID uuid, CiudadEntity entity);
}
