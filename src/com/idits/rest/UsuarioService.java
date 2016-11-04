package com.idits.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.GsonBuilder;
import com.idits.rest.impl.UsuarioImpl;


@Path("/usuario")
public class UsuarioService {

	private UsuarioImpl usuarioDAO = new UsuarioImpl();

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public Response inscribir(String personaJson) {
		System.out.println("Recibimos la persona en JSON: " + personaJson);

		// {"apellido":"s","provincia":"Mendoza","cuil":"","nombre":"joaq\n","email":"jo@h.com","fechaDeNacimiento":"2016-10-31","dni":35566688,"codigoPostal":5501,"realizaAportes":false,"telefono":64664}
		// Produce error -> Persona persona = new Gson().fromJson(personaJson,
		// Persona.class);
		//System.out.println("Decodificada es igual a : " + persona);

		return Response.status(200).build();

	}
	
	
	/**
	 * Lista todos los usuarios que se encuentran en la base de datos
	 * 
	 * @return un listado de objetos "persona" en formato JSON
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listarTodos() {
		// usuarioDAO.testUsuarioLocalidadProvincia();
		return new GsonBuilder().setPrettyPrinting().create().toJson(usuarioDAO.listarTodosLosUsuarios());
	}

}