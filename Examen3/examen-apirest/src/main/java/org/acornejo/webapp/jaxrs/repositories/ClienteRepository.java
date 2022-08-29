package org.acornejo.webapp.jaxrs.repositories;

import org.acornejo.webapp.jaxrs.models.Cliente;

import java.util.List;

public interface ClienteRepository {

    List<Cliente> listar();
    Cliente guardar(Cliente cliente);
    Cliente porId(Long id);
    void eliminar(Long id);
}
