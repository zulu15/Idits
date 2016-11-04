package com.idits.rest;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.GsonBuilder;
import com.idits.rest.impl.CursoImpl;

@Path("/curso")

public class CursoService {

	private CursoImpl cursoDAO = new CursoImpl();

	/**
	 * Lista todos los usuarios que se encuentran en la base de datos
	 * 
	 * @return un listado de objetos "curso" en formato JSON
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listarTodos() {
		//(Genera inscripciones a cursos registros randoms para probar)cursoDAO.testUsuarioCursos();
		return new GsonBuilder().setPrettyPrinting().create().toJson(cursoDAO.listarTodos());
	}

	@POST
	@Path("/add/{cursoId}/{usuarioDni}")
	public Response inscribirCursoUsuario(@PathParam("cursoId") int cursoId, @PathParam("usuarioDni") int usuarioDni) {
		cursoDAO.addInscripcion(cursoId,usuarioDni);
		return Response.status(200).build();

	}

}
