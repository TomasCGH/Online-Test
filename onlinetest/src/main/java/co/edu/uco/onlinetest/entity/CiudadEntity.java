package co.edu.uco.onlinetest.entity;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class CiudadEntity {
    private UUID id;
    private String nombre;
    private DepartamentoEntity departamentoEntity;

    public CiudadEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDepartamento(DepartamentoEntity.obtenerDepartamentoDefecto());
    }

    public CiudadEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDepartamento(DepartamentoEntity.obtenerDepartamentoDefecto());
    }

    public CiudadEntity(final UUID id, String nombre, DepartamentoEntity departamentoEntity) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamentoEntity);
    }

    public static CiudadEntity obtenerCiudadDefecto() {
        return new CiudadEntity();
    }
    public static CiudadEntity obtenerValorDefecto(CiudadEntity ciudadEntityOriginal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(ciudadEntityOriginal, obtenerCiudadDefecto());
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

    public DepartamentoEntity getDepartamento() {
        return departamentoEntity;
    }

    public void setDepartamento(final DepartamentoEntity departamentoEntity) {
        this.departamentoEntity = DepartamentoEntity.obtenerValorDefecto(departamentoEntity);
    }
}
