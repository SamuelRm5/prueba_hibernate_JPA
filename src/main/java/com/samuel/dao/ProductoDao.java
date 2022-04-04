package com.samuel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.persister.walking.spi.EncapsulatedEntityIdentifierDefinition;

import com.samuel.aplicacion.JPAUtil;
import com.samuel.aplicacion.controlador.Coordinador;
import com.samuel.entidades.Mascota;
import com.samuel.entidades.PersonasProductos;
import com.samuel.entidades.Producto;

public class ProductoDao {
	
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public String registrarCompra(PersonasProductos producto) {
		
		String resp = "";
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(producto);
			entityManager.getTransaction().commit();
			
			resp = "Se realizó la compra del producto";
			JOptionPane.showMessageDialog(null, resp);
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Verifique que los datos si existan","ERROR 404",JOptionPane.ERROR_MESSAGE);
		}
		
		return resp;
		
	}

	public String registrarProducto(Producto miProducto) {
		String resp = "";
		try {
			
			entityManager.getTransaction().begin();
			entityManager.persist(miProducto);
			entityManager.getTransaction().commit();
			
			resp = "Producto Registrado!";
			JOptionPane.showMessageDialog(null, resp);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo registrar el producto","ERROR EN EL REGISTRO",JOptionPane.ERROR_MESSAGE );
		
		}
		
		return resp;
	}

	public Producto consultarProducto(Long idProducto) {
		Producto miProducto = entityManager.find(Producto.class, idProducto);
		
		if ( miProducto != null ) {
			return miProducto;
		}
		else {
			return null;
		}
	}

	public List<Producto> consultarListaProductos() {
		List<Producto> listaProductos = new ArrayList<Producto>();
		Query query = entityManager.createQuery("SELECT m FROM Producto m");
		listaProductos = query.getResultList();
		
		return listaProductos;
	}

	public String actualizarProducto(Producto miProducto) {
		entityManager.getTransaction().begin();
		entityManager.merge(miProducto);
		entityManager.getTransaction().commit();
		
		String resp = "Producto Actualizado!";
		JOptionPane.showMessageDialog(null, resp);
		
		return resp;
	}

	public String eliminarProducto(Producto miProducto) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(miProducto);
			entityManager.getTransaction().commit();
			
			String resp = "Producto Eliminado!";
			JOptionPane.showMessageDialog(null, resp);
			return resp;
		} catch (Exception e) {
			String resp = "ERROR Eliminado!";
			JOptionPane.showMessageDialog(null, resp,"",JOptionPane.ERROR_MESSAGE);
			return resp;
		}
		
		
		
	}

	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		
	}

}
