package com.samuel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.samuel.aplicacion.JPAUtil;
import com.samuel.aplicacion.controlador.Coordinador;
import com.samuel.entidades.Mascota;

public class MascotaDao {
	
EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

	
	
	public String registrarMascota( Mascota miMascota ) {
		String resp = "";
		try {
			
			entityManager.getTransaction().begin();
			entityManager.persist(miMascota);
			entityManager.getTransaction().commit();
			
			resp = "Mascota Registrada!";
			JOptionPane.showMessageDialog(null, "Registro Exitoso","EXITO",JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "El dueño no existe, por favor verifiquelo nuevamente","ERROR EN EL REGISTRO",JOptionPane.ERROR_MESSAGE );
		
		}
		
		return resp;
	}
	
	public Mascota consultarMascota(Long idMascota) {
		
		Mascota miMascota = entityManager.find(Mascota.class, idMascota);
		
		if ( miMascota != null ) {
			return miMascota;
		}
		else {
			return null;
		}
	}
	
	public List<Mascota> consultarListaMascotas() {
		
		List<Mascota> listaMascotas = new ArrayList<Mascota>();
		Query query = entityManager.createQuery("SELECT m FROM Mascota m");
		listaMascotas = query.getResultList();
		
		return listaMascotas;
		
	}
	
	
	public List<Mascota> consultarListaMascotasPorSexo(String sexo) {
		
		List<Mascota> listaMascotas = new ArrayList<Mascota>();
		String sentencia = "SELECT m FROM Mascota m WHERE m.sexo = : sexoMascota";
		Query query = entityManager.createQuery( sentencia );
		      query.setParameter("sexoMascota", sexo);
		      if ( query.getResultList().size() == 0 ) {
				JOptionPane.showMessageDialog(null, "No se encontraron mascotas con el sexo \""+sexo+"\"","Error 404",JOptionPane.WARNING_MESSAGE);

			}
		      
	    listaMascotas = query.getResultList();
		      
		return listaMascotas;

		
		
	}
	
	
	public String actualizarMascota( Mascota miMascota ) {
		
		entityManager.getTransaction().begin();
		entityManager.merge(miMascota);
		entityManager.getTransaction().commit();
		
		String resp = "Mascota Actualizada!";
		JOptionPane.showMessageDialog(null, resp);
		
		return resp;
	}
	
	public String eliminarMascota( Mascota miMascota ) {
		
		entityManager.getTransaction().begin();
		entityManager.remove(miMascota);
		entityManager.getTransaction().commit();
		
		String resp = "Mascota Eliminada!";
		JOptionPane.showMessageDialog(null, resp);
		
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
