package org.acornejo.webapp.jaxrs.repositories;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.acornejo.webapp.jaxrs.models.Cliente;

import java.util.List;

@RequestScoped
@DeclareRoles({"USER","ADMIN"})
public class ClienteRepositoryImpl implements ClienteRepository{

    @Inject
    private EntityManager em;

    @Override
    @RolesAllowed({"USER","ADMIN"})
    public List<Cliente> listar() {
        return em.createQuery("select c from Cliente c left outer join fetch c.proveedor", Cliente.class).getResultList();
    }

    @Override
    @RolesAllowed({"ADMIN"})
    public Cliente guardar(Cliente cliente) {
        if(cliente.getId() != null && cliente.getId() > 0){
            em.merge(cliente);
        }else{
            em.persist(cliente);
        }
        return cliente;
    }

    @Override
    @RolesAllowed({"USER","ADMIN"})
    public Cliente porId(Long id) {
        return em.createQuery("select c from Cliente c left outer join fetch c.proveedor where c.id=:id", Cliente.class).setParameter("id",id).getSingleResult();
    }

    @Override
    @RolesAllowed({"ADMIN"})
    public void eliminar(Long id) {
        Cliente c = porId(id);
        em.remove(c);
    }
}
