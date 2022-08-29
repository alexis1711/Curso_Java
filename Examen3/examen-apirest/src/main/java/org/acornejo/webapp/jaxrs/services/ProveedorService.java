package org.acornejo.webapp.jaxrs.services;

import jakarta.ejb.Local;
import org.acornejo.webapp.jaxrs.models.Cliente;
import org.acornejo.webapp.jaxrs.models.Proveedor;

import java.util.List;
import java.util.Optional;

@Local
public interface ProveedorService {
    List<Proveedor> listar();
    Proveedor guardar(Proveedor proveedor);
    Optional<Proveedor> porId(Long id);
    void eliminar(Long id);
}
