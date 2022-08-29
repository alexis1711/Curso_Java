package org.acornejo.webapp.jaxrs.services;

import jakarta.ejb.Local;
import org.acornejo.webapp.jaxrs.models.Cliente;

import java.util.List;
import java.util.Optional;

@Local
public interface ClienteService {
    List<Cliente> listar();
    Cliente guardar(Cliente cliente);
    Optional<Cliente> porId(Long id);
    void eliminar(Long id);
}
