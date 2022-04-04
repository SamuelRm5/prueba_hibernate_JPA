package com.samuel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.samuel.aplicacion.JPAUtil;
import com.samuel.aplicacion.controlador.Coordinador;
import com.samuel.entidades.Persona;

public class PersonaDao {

	
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public String registrarPersona( Persona miPersona ) {
		String resp = "";
		System.out.println( miPersona );
		try {
			entityManager.getTransaction().begin();
			entityManager.persist( miPersona );
			entityManager.getTransaction().commit();
			
			JOptionPane.showMessageDialog(null, "Registro Exitoso","EXITO",JOptionPane.INFORMATION_MESSAGE);
			
			resp = "ok";
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Verifique que el documento no exista","ERROR EN EL REGISTRO",JOptionPane.ERROR_MESSAGE);
			resp="Error";
		}
		
		return resp;
		
		
	}
	
	public Persona consultarPersona( Long idPersona ) {
		
		Persona miPersona = entityManager.find(Persona.class, idPersona );
		
		if ( miPersona != null ) {
			return miPersona;
			
		}
		else {
			
			return null;
		}
	}
	
	public List<Persona> consultarListaPersonas() {
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		Query query = entityManager.createQuery("SELECT p FROM Persona p");
		listaPersonas = query.getResultList();
		
		return listaPersonas;
	}
	
	public String actualizarPersona( Persona miPersona ) {
		String resp = "";
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(miPersona);
			entityManager.getTransaction().commit();
			
			JOptionPane.showMessageDialog(null, "Actualización Exitosa","EXITO",JOptionPane.INFORMATION_MESSAGE);
			resp = "Persona Actualizada!";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la actualización","ERROR",JOptionPane.ERROR_MESSAGE);
			resp = "";
		}
		
		
		
		return resp;
	}
	
	public String eliminarPersona( Persona miPersona ) {
		String resp = "";
		try {
			
			entityManager.getTransaction().begin();
			entityManager.remove(miPersona);
			entityManager.getTransaction().commit();
			
			JOptionPane.showMessageDialog(null, "Eliminación Exitosa","EXITO",JOptionPane.INFORMATION_MESSAGE);
			resp = "Persona Eliminada!";
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Verifique que no tenga mascotas agregadas","ERROR EN LA ELIMINACION",JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		return resp;
	}
	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		
	}
}
