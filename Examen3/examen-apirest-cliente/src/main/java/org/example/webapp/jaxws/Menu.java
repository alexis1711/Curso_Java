package org.example.webapp.jaxws;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.webapp.jaxws.models.Cliente;
import org.example.webapp.jaxws.models.Proveedor;
import org.jboss.resteasy.client.jaxrs.internal.BasicAuthentication;

import java.util.List;

public class Menu {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        //CRUD para clientes

        //rootUri para Clientes
        WebTarget rootUriC = client.target("http://localhost:8081/examen-apirest/api").path("/clientes");
        rootUriC.register(new BasicAuthentication("admin","pass1234"));

        //Busqueda por Id
        /*System.out.println("===== Por Id =====");
        Response response = rootUriC.path("/4").request(MediaType.APPLICATION_JSON).get();
        Cliente cliente = response.readEntity(Cliente.class);
        System.out.println(cliente);
        System.out.println(response.getStatus());
        System.out.println(response.getMediaType());*/

        //Lista completa
        //listarClientes(rootUriC);

        //Crear un nuevo cliente
        /*System.out.println("===== Creando =====");
        Cliente clienteNuevo = new Cliente();
        clienteNuevo.setNombre("Fernando");
        clienteNuevo.setApellido("Palomo");
        clienteNuevo.setCorreo("fernando@gmail.com");
        clienteNuevo.setDireccion("Col. Botella");
        Proveedor proveedor = new Proveedor();
        proveedor.setId(1L);
        clienteNuevo.setProveedor(proveedor);
        Entity<Cliente> entityHeader = Entity.entity(clienteNuevo, MediaType.APPLICATION_JSON);
        Cliente cliente1 = rootUriC.request(MediaType.APPLICATION_JSON).post(entityHeader, Cliente.class);
        System.out.println(cliente1);
        listarClientes(rootUriC);*/

        //Editar un cliente
        /*System.out.println("===== Editando =====");
        Cliente clienteEditado = cliente;
        clienteEditado.setNombre("Jaime");
        clienteEditado.setApellido("Vilanova");
        clienteEditado.setCorreo("jaime@gmail.com");
        clienteEditado.setDireccion("Col. La palmera");
        Proveedor proveedor1 = new Proveedor();
        proveedor1.setId(2L);
        clienteEditado.setProveedor(proveedor1);
        Entity<Cliente> entityHeader1 = Entity.entity(clienteEditado, MediaType.APPLICATION_JSON);
        Cliente cliente2 = rootUriC.path("/" + cliente.getId()).request(MediaType.APPLICATION_JSON).put(entityHeader1, Cliente.class);
        System.out.println(cliente2);
        listarClientes(rootUriC);*/

        //Eliminar un cliente
        /*System.out.println("===== Eliminando =====");
        rootUriC.path("/" + cliente.getId()).request().delete();
        listarClientes(rootUriC);*/

        //CRUD para proveedores

        //rootUri para proveedores
        WebTarget rootUriP = client.target("http://localhost:8081/examen-apirest/api").path("/proveedores");
        rootUriP.register(new BasicAuthentication("admin", "pass1234"));

        //Busqueda por Id
        System.out.println("===== Por Id =====");
        Response response1 = rootUriP.path("/5").request(MediaType.APPLICATION_JSON).get();
        Proveedor proveedor2 = response1.readEntity(Proveedor.class);
        System.out.println(proveedor2);
        System.out.println(response1.getStatus());
        System.out.println(response1.getMediaType());

        //Lista completa
        //listarProveedores(rootUriP);

        //Crear un nuevo proveedor
        /*System.out.println("===== Creando =====");
        Proveedor proveedorNuevo = new Proveedor();
        proveedorNuevo.setNombre("Papeleria");
        proveedorNuevo.setDireccion("Col. La mascota");
        Entity<Proveedor> entityHeader2 = Entity.entity(proveedorNuevo, MediaType.APPLICATION_JSON);
        Proveedor proveedor3 = rootUriP.request(MediaType.APPLICATION_JSON).post(entityHeader2, Proveedor.class);
        System.out.println(proveedor3);
        listarProveedores(rootUriP);*/

        //Editar un cliente
        /*System.out.println("===== Editando =====");
        Proveedor proveedorEditado = proveedor2;
        proveedorEditado.setNombre("Instrumentacion");
        proveedorEditado.setDireccion("Col. La playa");
        Entity<Proveedor> entityHeader3 = Entity.entity(proveedorEditado, MediaType.APPLICATION_JSON);
        Proveedor proveedor4 = rootUriP.path("/" + proveedor2.getId()).request(MediaType.APPLICATION_JSON).put(entityHeader3, Proveedor.class);
        System.out.println(proveedor4);
        listarProveedores(rootUriP);*/

    }

    private static void listarClientes(WebTarget rootUriC){
        System.out.println("===== Listado =====");
        Response response;
        response = rootUriC.request(MediaType.APPLICATION_JSON).get();

        List<Cliente> clientes = response.readEntity(new GenericType<List<Cliente>>(){});
        clientes.forEach(System.out::println);
    }

    private static void listarProveedores(WebTarget rootUriP){
        System.out.println("===== Listado =====");
        Response response;
        response = rootUriP.request(MediaType.APPLICATION_JSON).get();

        List<Proveedor> proveedores = response.readEntity(new GenericType<List<Proveedor>>(){});
        proveedores.forEach(System.out::println);
    }
}
