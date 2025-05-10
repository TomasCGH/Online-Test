package co.edu.uco.onlinetest.entity;

import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class PaisEntity {

    private UUID id;
    private String nombre;

    public PaisEntity() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public PaisEntity(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public PaisEntity(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static PaisEntity obtenerPaisDefecto() {
        return new PaisEntity();
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

    public void setNombre(final String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosEnBlancoInicioFin(nombre);
    }

    public static PaisEntity obtenerPaisDefecto(final PaisEntity pais) {
        return UtilObjeto.getInstance().obtenerValorDefecto(pais, PaisEntity.obtenerPaisDefecto());
    }


}
