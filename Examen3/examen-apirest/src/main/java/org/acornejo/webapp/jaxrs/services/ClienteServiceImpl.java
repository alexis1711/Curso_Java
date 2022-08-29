package org.acornejo.webapp.jaxrs.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.acornejo.webapp.jaxrs.models.Cliente;
import org.acornejo.webapp.jaxrs.repositories.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class ClienteServiceImpl implements ClienteService{

    @Inject
    private ClienteRepository repository;

    @Override
    public List<Cliente> listar() {
        return repository.listar();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return repository.guardar(cliente);
    }

    @Override
    public Optional<Cliente> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}
