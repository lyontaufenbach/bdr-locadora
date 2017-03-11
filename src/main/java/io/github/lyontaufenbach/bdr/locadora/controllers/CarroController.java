/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.lyontaufenbach.bdr.locadora.controllers;

import io.github.lyontaufenbach.bdr.locadora.model.Carro;
import io.github.lyontaufenbach.bdr.locadora.service.CarroService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Lyon
 */
@Path("carros")
public class CarroController {
    
    CarroService carroService = new CarroService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Carro> getCarros(){
        return carroService.getCarros();
        
    };
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Carro getCarro(@PathParam("id") long id) {
        Carro c1 = new Carro();
        c1.setId(id);
        c1.setModelo("Modelo teste " + id);
        c1.setValor(BigDecimal.ZERO);
        
        return carroService.getCarro(id);
    };
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response addCarro(Carro carro) {
        carroService.addCarro(carro);
        return Response.status(Response.Status.OK).build();
    };
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response updateCarro(Carro carro) {
        carroService.updateCarro(carro);
        return Response.status(Response.Status.OK).build();
    };
    
    @DELETE
    @Path("{id}/")
    public Response delete(@PathParam("id") long id) {
        carroService.deleteCarro(id);
        return Response.status(Response.Status.OK).build();
    };
}