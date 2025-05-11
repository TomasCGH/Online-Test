package co.edu.uco.onlinetest.businesslogic.facade;


import co.edu.uco.onlinetest.dto.PaisDTO;

import java.util.List;
import java.util.UUID;

public interface PaisFacade {
        void registrarNuevoPais(PaisDTO pais);

        void modificarPais(UUID id,PaisDTO pais);

        void darBajaDefinitivaPaisExistente(UUID id);

        PaisDTO consultarPaisPorId(UUID id);

        List<PaisDTO> consultarPaisesPorFiltro(PaisDTO filtro);
}
