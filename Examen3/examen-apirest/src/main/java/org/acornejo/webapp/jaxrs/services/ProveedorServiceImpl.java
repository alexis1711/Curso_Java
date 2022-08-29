package org.acornejo.webapp.jaxrs.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.acornejo.webapp.jaxrs.models.Cliente;
import org.acornejo.webapp.jaxrs.models.Proveedor;
import org.acornejo.webapp.jaxrs.repositories.ClienteRepository;
import org.acornejo.webapp.jaxrs.repositories.ProveedorRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProveedorServiceImpl implements ProveedorService {

    @Inject
    private ProveedorRepository repository;

    @Override
    public List<Proveedor> listar() {
        return repository.listar();
    }

    @Override
    public Proveedor guardar(Proveedor proveedor) {
        return repository.guardar(proveedor);
    }

    @Override
    public Optional<Proveedor> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void eliminar(Long id) {
        repository.eliminar(id);
    }

}
