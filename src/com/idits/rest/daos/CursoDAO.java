package com.idits.rest.daos;

import java.util.List;

import com.idits.rest.model.Curso;

public interface CursoDAO {
	
	void addCurso(Curso curso);
	List<Curso> listarTodos();
}
