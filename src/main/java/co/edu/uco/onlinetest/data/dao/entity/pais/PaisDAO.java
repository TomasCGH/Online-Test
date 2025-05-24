package co.edu.uco.onlinetest.data.dao.entity.pais;

import co.edu.uco.onlinetest.data.dao.entity.CreateDAO;
import co.edu.uco.onlinetest.data.dao.entity.DeleteDAO;
import co.edu.uco.onlinetest.data.dao.entity.RetrieveDAO;
import co.edu.uco.onlinetest.data.dao.entity.UpdateDAO;
import co.edu.uco.onlinetest.entity.PaisEntity;

import java.util.UUID;

public interface PaisDao
        extends CreateDAO<PaisEntity>, RetrieveDAO<PaisEntity, UUID>, UpdateDAO<PaisEntity, UUID>, DeleteDAO<UUID> {


    void updateById(UUID uuid, PaisEntity entity);
}
