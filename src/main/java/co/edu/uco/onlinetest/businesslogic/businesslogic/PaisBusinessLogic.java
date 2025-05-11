package co.edu.uco.onlinetest.businesslogic.businesslogic;

import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.PaisDomain;

import java.util.List;
import java.util.UUID;

public interface PaisBusinessLogic {
        void registrarNuevoPais(PaisDomain pais);

        void modificarPais(UUID id,PaisDomain pais);

        void darBajaDefinitivaPaisExistente(UUID id);

        PaisDomain consultarPaisPorId(UUID id);

        List<PaisDomain> consultarPaisesPorFiltro(PaisDomain filtro);
}
