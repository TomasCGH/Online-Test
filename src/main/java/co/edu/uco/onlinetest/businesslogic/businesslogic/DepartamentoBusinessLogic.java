package co.edu.uco.onlinetest.businesslogic.businesslogic;

import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.DepartamentoDomain;

import java.util.List;
import java.util.UUID;

public interface DepartamentoBusinessLogic {

        void registrarNuevoDepartamento(DepartamentoDomain pais);

        void modificarDepartamentoExistente(UUID id, DepartamentoDomain pais);

        void darBajaDefinitivamenteDepartamentoExistente(UUID id);

        DepartamentoDomain consultarDepartamentoPorId(UUID id);

        List<DepartamentoDomain> consultarDepartamento(DepartamentoDomain filtro);

}

