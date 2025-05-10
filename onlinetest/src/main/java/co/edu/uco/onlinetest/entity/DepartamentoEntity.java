package co.edu.uco.onlinetest.entity;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class DepartamentoEntity {
    private UUID id;
    private String nombre;
    private PaisEntity pais;

    public DepartamentoEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setPais(PaisEntity.obtenerPaisDefecto());
    }

    public DepartamentoEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setPais(PaisEntity.obtenerPaisDefecto());
    }

    public DepartamentoEntity(final UUID id, final String nombre, final PaisEntity pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }


    public static DepartamentoEntity obtenerDepartamentoDefecto() {
        return new DepartamentoEntity();
    }

    public static DepartamentoEntity obtenerValorDefecto(DepartamentoEntity departamentoEntityOriginal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(departamentoEntityOriginal, obtenerDepartamentoDefecto());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().obtenerValorDefecto(nombre);
    }

    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(final PaisEntity pais) {
        this.pais = PaisEntity.obtenerPaisDefecto(pais);
    }
}
