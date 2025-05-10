package co.edu.uco.onlinetest.dto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.onlinetest.dto.PaisDTO;

import java.util.UUID;

public final class DepartamentoDTO {
    private UUID id;
    private String nombre;
    private PaisDTO pais;

    public DepartamentoDTO() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setPais(PaisDTO.obtenerPaisDefecto());
    }

    public DepartamentoDTO(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setPais(PaisDTO.obtenerPaisDefecto());
    }

    public DepartamentoDTO(final UUID id, final String nombre, final PaisDTO pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }

    public UUID getId() {
        return id;
    }

    public DepartamentoDTO setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public DepartamentoDTO setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().obtenerValorDefecto(nombre);
        return this;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public DepartamentoDTO setPais(final PaisDTO pais) {
        this.pais = PaisDTO.obtenerPaisDefecto(pais);
        return this;
    }

    public static DepartamentoDTO obtenerDepartamentoDefecto() {
        return new DepartamentoDTO();
    }

    public static DepartamentoDTO obtenerValorDefecto(DepartamentoDTO departamentoDTO) {
        return UtilObjeto.getInstance().obtenerValorDefecto(departamentoDTO, obtenerDepartamentoDefecto());
    }

}
