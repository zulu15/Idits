package com.idits.rest.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.idits.rest.daos.CursoDAO;
import com.idits.rest.model.Curso;
import com.idits.rest.model.Localidad;
import com.idits.rest.model.Persona;
import com.idits.rest.model.Provincia;
import com.idits.rest.util.HibernateUtil;

public class CursoImpl implements CursoDAO {

	@Override
	public void addCurso(Curso curso) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Curso> listarTodos() {
		Session hibernate = HibernateUtil.getSessionFactory().openSession();
		TypedQuery<Curso> query = hibernate.createQuery("FROM Curso");
		List<Curso> cursosDisponibles = query.getResultList();
		if (hibernate != null) {
			hibernate.close();
		}
		return cursosDisponibles;
	}

	public void testUsuarioCursos() {
		Session hibernate = HibernateUtil.getSessionFactory().openSession();
		// Obtengo un objeto para realizar e indicarle a la bd que hare
		// transacciones en la base de datos
		Transaction transaccion = hibernate.getTransaction();
		try {
			// Le indico a hibernate que voy a hacer acciones en la base de
			// datos
			transaccion.begin();
			transaccion.setTimeout(5);
			// Guardo la persona y a su vez la localidad asociada donde vive
			// dicha persona y la provincia donde vive dicha persona
			// gracias a la anotacion CascadeType.ALL se guardan los tres

			// Curso cursoA = new Curso(0, "ADMINISTRACIÓN BÁSICA DE LINUX", "Es
			// un curso diseñado para quienes deseen adquirir rápidamente
			// capacidades prácticas de administración Linux", "Capitulo 1:
			// Introducción a Linux. Conceptos Básicos. Introducción
			// OEL.Creación VM. Configuraciones adicionales.Capitulo 2:
			// Shell's.Tipos de Shell's.Capitulo 3: Usuarios y grupos.Gestión de
			// usuarios y grupos.Capitulo 4: File System's.Gestión de archivos y
			// directorios.Capitulo 5: Gestión de File System's.Tipos de File
			// System's.Discos y particiones.LVM.Gestión LVM.Capitulo 6:
			// Procesos.Gestión de Procesos.Capitulo 7: Permisos.Gestión de
			// permisos.Capitulo 8: Shell Scripts.Editor Vi.Entradas y
			// Salidas.Variables.Filtros.", "Conocimientos en Herramientas
			// Office y sistema Operativo Windows", 80);

			Persona persona1 = new Persona(0, 38415607, "356-55-45", "Joaquin", "Sanchez", new java.util.Date(), 4394803, "joaquin@email.com", 5501, 0);
			Persona persona2 = new Persona(0, 4564666, "356-55-45", "Manuel", "Ferreira", new java.util.Date(), 456456, "ema@email.com", 5501, 0);

			Curso cursoA = new Curso(0, "ADMINISTRACIÓN BÁSICA DE LINUX", "Es un curso diseñado para quienes deseen adquirir rápidamente capacidades prácticas de administración Linux",
					"Capitulo 1: Introducción a Linux. Conceptos Básicos. Introducción OEL.Creación VM.   Configuraciones adicionales.Capitulo 2: Shell's.Tipos de Shell's.Capitulo 3: Usuarios y grupos.Gestión de usuarios y grupos.Capitulo 4: File System's.Gestión de archivos y directorios.Capitulo 5: Gestión de File System's.Tipos de File System's.Discos y particiones.LVM.Gestión LVM.Capitulo 6: Procesos.Gestión de Procesos.Capitulo 7: Permisos.Gestión de permisos.Capitulo 8: Shell Scripts.Editor Vi.Entradas y Salidas.Variables.Filtros.",
					"Conocimientos en Herramientas Office y sistema Operativo Windows", 80);

			Curso cursoB = new Curso(0, "ADMINISTRACIÓN DE SQL SERVER", "Es un curso diseñado para quienes deseen adquirir rápidamente capacidades prácticas de Administración de SQL Server ",
					"1. Introducción a Bases de Datos2. Introducción al Lenguaje SQL 3. Introducción a SQL Server 4. Creación de Bases de Datos 5. Creación de Tipos de Datos y Tablas 6. Usando XML  7. Índices 8. Integridad de Datos 9. Vistas 10. Procedimientos Almacenados 11. Funciones 12. Transacciones y Bloqueos 13. Código Manejado en la Base de Datos 14. Mantenimiento 15. Instalación y Configuración 16. Recuperación de Desastres 17. Manejo de Seguridad 18. Monitoreo de SQL Server 19. Automatización de Tareas Administrativas 20. Replicación 21. • Mantenimiento de Alta Disponibilidad",
					"Tener conocimientos básicos de base de datos relacionales. Por ejemplo teoría de bases de datos y diferencias entre base de datos y planilla de cálculos.", 80);

			persona1.getCursos().add(cursoA);
			persona1.getCursos().add(cursoB);
			persona2.getCursos().add(cursoA);

			//cursoA.getAlumnos().add(persona1);
			//cursoA.getAlumnos().add(persona2);
			//cursoB.getAlumnos().add(persona1);
			
			hibernate.save(persona1);
			hibernate.save(persona2);

			// Lo guardo definitivamente
			transaccion.commit();

		} catch (RuntimeException e) {
			try {
				// Esta sentencia esta dentro del cath en caso de error
				// vuelvo
				// atras y no provoco
				// inconsistencias en la base de datos
				transaccion.rollback();
			} catch (RuntimeException rbe) {
				System.err.println("Error guardando la persona " + " Error : " + e + " - " + rbe);
			}
		} finally {
			if (hibernate != null) {
				// Cierro hibernate si todo marcho correctamente
				hibernate.close();
			}
		}
	}

	public void addInscripcion(int cursoId, int usuarioDni) {
		Session hibernate = HibernateUtil.getSessionFactory().openSession();
		// Obtengo un objeto para realizar e indicarle a la bd que hare
		// transacciones en la base de datos
		Transaction transaccion = hibernate.getTransaction();
		try {
			// Le indico a hibernate que voy a hacer acciones en la base de
			// datos
			transaccion.begin();
			transaccion.setTimeout(5);
		
			//Obtengo la persona a inscribir a partir de su pk dni
			Persona alumno = hibernate.get(Persona.class, usuarioDni);
			alumno.getCursos().add(hibernate.get(Curso.class, cursoId));
			
			//Guarda en la tabla cursos_persona un nuevo registro con el dni de la persona y el id del curso
			hibernate.save(alumno);
			

			// Lo guardo definitivamente
			transaccion.commit();

		} catch (RuntimeException e) {
			try {
				// Esta sentencia esta dentro del cath en caso de error
				// vuelvo
				// atras y no provoco
				// inconsistencias en la base de datos
				transaccion.rollback();
			} catch (RuntimeException rbe) {
				System.err.println("Error guardando la persona " + " Error : " + e + " - " + rbe);
			}
		} finally {
			if (hibernate != null) {
				// Cierro hibernate si todo marcho correctamente
				hibernate.close();
			}
		}
		
	}

}
