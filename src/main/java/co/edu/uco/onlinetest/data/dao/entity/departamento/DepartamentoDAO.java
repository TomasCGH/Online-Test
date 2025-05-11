package co.edu.uco.onlinetest.data.dao.entity.departamento;

import co.edu.uco.onlinetest.data.dao.entity.*;
import co.edu.uco.onlinetest.entity.DepartamentoEntity;

import java.util.UUID;

public interface DepartamentoDAO extends CreateDAO<DepartamentoEntity>, RetrieveDAO<DepartamentoEntity, UUID>, UpdateDAO<DepartamentoEntity, UUID>, DeleteDAO<UUID> {

}