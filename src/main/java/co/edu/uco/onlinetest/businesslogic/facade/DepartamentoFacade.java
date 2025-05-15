package co.edu.uco.onlinetest.businesslogic.facade;

import co.edu.uco.onlinetest.dto.DepartamentoDTO;

import java.util.List;
import java.util.UUID;

public interface DepartamentoFacade {

    void registrarNuevoDepartamento(DepartamentoDTO departamento);

    void modificarDepartamento(UUID id, DepartamentoDTO departamento);

    void darBajaDefinitivaDepartamentoExistente(UUID id);

    DepartamentoDTO consultarDepartamentoPorId(UUID id);

    List<DepartamentoDTO> consultarDepartamentosPorFiltro(DepartamentoDTO filtro);
}
