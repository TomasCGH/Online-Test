package co.edu.uco.onlinetest.data.dao.entity.pais;

import co.edu.uco.onlinetest.data.dao.entity.*;
import co.edu.uco.onlinetest.entity.PaisEntity;

import java.util.UUID;

public interface PaisDAO extends CreateDAO<PaisEntity>, RetrieveDAO<PaisEntity, UUID>, UpdateDAO<PaisEntity, UUID>, DeleteDAO<UUID> {

}
