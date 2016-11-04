package com.idits.rest.daos;

import java.util.List;

import com.idits.rest.model.Persona;

public interface UsuarioDAO {

	void registrarUsuario(Persona usuario);

	int eliminarUsuario(Persona usuario);

	Persona buscarUsuarioPorId(int id);

	List<Persona> listarTodosLosUsuarios();


}
