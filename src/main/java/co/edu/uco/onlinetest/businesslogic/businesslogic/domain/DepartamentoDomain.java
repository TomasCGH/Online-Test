package co.edu.uco.onlinetest.businesslogic.businesslogic.domain;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.onlinetest.businesslogic.businesslogic.domain.PaisDomain;

import java.util.UUID;

public final class DepartamentoDomain {
    private UUID id;
    private String nombre;
    private PaisDomain pais;

     DepartamentoDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setPais(PaisDomain.obtenerPaisDefecto());
    }

    public DepartamentoDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setPais(PaisDomain.obtenerPaisDefecto());
    }

    public DepartamentoDomain(final UUID id, final String nombre, final PaisDomain pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }


    static DepartamentoDomain obtenerDepartamentoDefecto() {
        return new DepartamentoDomain();
    }

    static DepartamentoDomain obtenerValorDefecto(DepartamentoDomain departamentoOriginal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(departamentoOriginal, obtenerDepartamentoDefecto());
    }

    public UUID getId() {
        return id;
    }

    private void setId(final UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PaisDomain getPais() {
        return pais;
    }

    private void setPais(final PaisDomain pais) {
        this.pais = PaisDomain.obtenerPaisDefecto(pais);
    }
}
