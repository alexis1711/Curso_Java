package org.acornejo.webapp.jaxrs.repositories;

import org.acornejo.webapp.jaxrs.models.Cliente;
import org.acornejo.webapp.jaxrs.models.Proveedor;

import java.util.List;

public interface ProveedorRepository {

    List<Proveedor> listar();
    Proveedor guardar(Proveedor proveedor);
    Proveedor porId(Long id);
    void eliminar(Long id);
}
