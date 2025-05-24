package co.edu.uco.onlinetest.businesslogic.facade;

import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;
import co.edu.uco.onlinetest.dto.CiudadDTO;

import java.util.List;
import java.util.UUID;

public interface CiudadFacade {


    void registrarNuevaCiudad(CiudadDTO ciudad) throws OnlineTestException;


    void modificarCiudadExistente(UUID id, CiudadDTO ciudad) throws OnlineTestException;


    void darbajaDefinitivamenteCiudadExistente(UUID id) throws OnlineTestException;


    CiudadDTO consultarCiudadPorId(UUID id) throws OnlineTestException;


    List<CiudadDTO> consultarCiudades(CiudadDTO filtro) throws OnlineTestException;

}
