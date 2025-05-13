package co.edu.uco.onlinetest.businesslogic.businesslogic;

import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.CiudadDomain;
import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.DepartamentoDomain;

import java.util.List;
import java.util.UUID;

public interface CiudadBusinessLogic {

    void registrarNuevoCiudad(CiudadDomain pais);

    void modificarCiudadExistente(UUID id, CiudadDomain pais);

    void darBajaDefinitivamenteCiudadExistente(UUID id);

    CiudadDomain consultarCiudadPorId(UUID id);

    List<CiudadDomain> consultarCiudad(CiudadDomain filtro);

}
