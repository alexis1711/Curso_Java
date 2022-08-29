package org.acornejo.webapp.jaxrs.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acornejo.webapp.jaxrs.models.Cliente;
import org.acornejo.webapp.jaxrs.services.ClienteService;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
public class ClienteRestController {

    @Inject
    private ClienteService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> listar(){
        return service.listar();
    }

    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") Long id){
        Optional<Cliente> clienteOptional = service.porId(id);
        if(clienteOptional.isPresent()){
            return Response.ok(clienteOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Cliente cliente){
        try{
            Cliente nuevoCliente = service.guardar(cliente);
            return Response.ok(nuevoCliente).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") Long id, Cliente cliente){
        Optional<Cliente> clienteOptional = service.porId(id);
        if(clienteOptional.isPresent()){
            Cliente nuevoCliente = clienteOptional.get();
            nuevoCliente.setNombre(cliente.getNombre());
            nuevoCliente.setApellido(cliente.getApellido());
            nuevoCliente.setCorreo(cliente.getCorreo());
            nuevoCliente.setDireccion(cliente.getDireccion());
            nuevoCliente.setProveedor(cliente.getProveedor());

            try{
                service.guardar(nuevoCliente);
                return Response.ok(nuevoCliente).build();
            }catch (Exception e){
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id){
        Optional<Cliente> clienteOptional = service.porId(id);
        if(clienteOptional.isPresent()){
            try{
                service.eliminar(clienteOptional.get().getId());
            }catch (Exception e){
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
