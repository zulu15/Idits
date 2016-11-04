package com.idits.rest.impl;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.idits.rest.daos.UsuarioDAO;
import com.idits.rest.model.Localidad;
import com.idits.rest.model.Persona;
import com.idits.rest.model.Provincia;
import com.idits.rest.util.HibernateUtil;

public class UsuarioImpl implements UsuarioDAO {

	@Override
	public void registrarUsuario(Persona usuario) {

	}

	@Override
	public int eliminarUsuario(Persona usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Persona buscarUsuarioPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> listarTodosLosUsuarios() {
		Session hibernate = HibernateUtil.getSessionFactory().openSession();
		TypedQuery<Persona> query = hibernate.createQuery("FROM Persona");
		List<Persona> personasInscriptas = query.getResultList();
		if (hibernate != null) {
			hibernate.close();
		}

		return personasInscriptas;
	}

	// Es una simple prueba de como funciona la relacion de persistencia
	// Entre tres tablas: Persona Localidad y Provincia.
	public void testUsuarioLocalidadProvincia() {
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
			
			
			Localidad localidad1 = new Localidad(0, "Godoy Cruz");
			Localidad localidad2 = new Localidad(0, "Las Heras");
			Localidad localidad3 = new Localidad(0, "Quilmes");
			Provincia provincia1 = new Provincia(0, "Mendoza");
			Provincia provincia2 = new Provincia(0, "Buenos Aires");
			
			Persona persona1 = new Persona(0, 38415607, "356-55-45", "Joaquin", "Sanchez", new java.util.Date(), 4394803, "joaquin@email.com", 5501, 0);
			Persona persona2 = new Persona(0, 4564666, "356-55-45", "Manuel", "Ferreira", new java.util.Date(), 456456, "ema@email.com",  5501, 0);

			persona1.setProvincia(provincia1);
			persona1.setLocalidad(localidad1);
			
			persona2.setProvincia(provincia2);
			persona2.setLocalidad(localidad3);
			
			hibernate.save(persona1);
			hibernate.save(persona2);
			hibernate.save(localidad2);

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
