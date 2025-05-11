package co.edu.uco.onlinetest.dto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.onlinetest.dto.DepartamentoDTO;

import java.util.UUID;

public final class CiudadDTO {

    private UUID id;
    private String nombre;
    private DepartamentoDTO departamentoDTO;

    public CiudadDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDepartamento(DepartamentoDTO.obtenerDepartamentoDefecto());
    }

    public CiudadDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDepartamento(DepartamentoDTO.obtenerDepartamentoDefecto());
    }

    public CiudadDTO(final UUID id, String nombre, DepartamentoDTO departamentoEntity) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamentoEntity);
    }

    public UUID getId() {
        return id;
    }

    public CiudadDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public CiudadDTO setNombre(String nombre) {
        this.nombre =   UtilTexto.getInstance().obtenerValorDefecto(nombre);
        return this;
    }

    public DepartamentoDTO getDepartamento() {
        return departamentoDTO;
    }

    public CiudadDTO setDepartamento(final DepartamentoDTO departamentoEntity) {
        this.departamentoDTO = DepartamentoDTO.obtenerValorDefecto(departamentoEntity);
        return this;
    }

    public static CiudadDTO obtenerCiudadDefecto() {
        return new CiudadDTO();
    }

    public static CiudadDTO obtenerValorDefecto(CiudadDTO ciudadDTO) {
        return UtilObjeto.getInstance().obtenerValorDefecto(ciudadDTO, obtenerCiudadDefecto());
    }

}
