package co.edu.uco.onlinetest.businesslogic.facade;

import co.edu.uco.onlinetest.dto.CiudadDTO;

import java.util.List;
import java.util.UUID;

public interface CiudadFacade {

    void registrarNuevaCiudad(CiudadDTO ciudad);

    void modificarCiudad(UUID id, CiudadDTO ciudad);

    void darBajaDefinitivaCiudadExistente(UUID id);

    CiudadDTO consultarCiudadPorId(UUID id);

    List<CiudadDTO> consultarCiudadesPorFiltro(CiudadDTO filtro);
}

