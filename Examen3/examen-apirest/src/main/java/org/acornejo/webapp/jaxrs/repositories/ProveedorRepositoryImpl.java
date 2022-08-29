package org.acornejo.webapp.jaxrs.repositories;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.acornejo.webapp.jaxrs.models.Cliente;
import org.acornejo.webapp.jaxrs.models.Proveedor;

import java.util.List;

@RequestScoped
@DeclareRoles({"USER","ADMIN"})
public class ProveedorRepositoryImpl implements ProveedorRepository{

    @Inject
    private EntityManager em;

    @Override
    @RolesAllowed({"USER","ADMIN"})
    public List<Proveedor> listar() {
        return em.createQuery("select c from Proveedor c", Proveedor.class).getResultList();
    }

    @Override
    @RolesAllowed({"ADMIN"})
    public Proveedor guardar(Proveedor proveedor) {
        if(proveedor.getId() != null && proveedor.getId() > 0){
            em.merge(proveedor);
        }else{
            em.persist(proveedor);
        }
        return proveedor;
    }

    @Override
    @RolesAllowed({"USER","ADMIN"})
    public Proveedor porId(Long id) {
        return em.createQuery("select c from Proveedor c where c.id=:id", Proveedor.class).setParameter("id",id).getSingleResult();
    }

    @Override
    @RolesAllowed({"ADMIN"})
    public void eliminar(Long id) {
        Proveedor c = porId(id);
        em.remove(c);
    }
}
