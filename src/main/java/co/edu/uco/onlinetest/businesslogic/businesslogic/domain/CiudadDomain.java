package co.edu.uco.onlinetest.businesslogic.businesslogic.domain;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilTexto;
import co.edu.uco.onlinetest.crosscutting.utilitarios.UtilUUID;

import java.util.UUID;

public final class CiudadDomain {
    private UUID id;
    private String nombre;
    private DepartamentoDomain departamento;

    CiudadDomain() {
        setId(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDepartamento(DepartamentoDomain.obtenerDepartamentoDefecto());
    }

    public CiudadDomain(final UUID id) {
        setId(id);
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setDepartamento(DepartamentoDomain.obtenerDepartamentoDefecto());
    }

    public CiudadDomain(final UUID id, String nombre, DepartamentoDomain departamento) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
    }

    static CiudadDomain obtenerCiudadDefecto() {
        return new CiudadDomain();
    }

    static CiudadDomain obtenerValorDefecto(CiudadDomain ciudadDomainOriginal) {
        return UtilObjeto.getInstance().obtenerValorDefecto(ciudadDomainOriginal, obtenerCiudadDefecto());
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

    public DepartamentoDomain getDepartamento() {
        return departamento;
    }

    private void setDepartamento(final DepartamentoDomain departamentoDomain) {
        this.departamento = DepartamentoDomain.obtenerValorDefecto(departamentoDomain);
    }


}
