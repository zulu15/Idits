package com.idits.rest;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class IditsApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public IditsApplication() {
		singletons.add(new UsuarioService());
		singletons.add(new CursoService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}