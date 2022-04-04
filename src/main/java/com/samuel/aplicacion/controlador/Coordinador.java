package com.samuel.aplicacion.controlador;
import com.samuel.vista.gui.*;
import com.samuel.dao.*;
import com.samuel.entidades.Mascota;
import com.samuel.entidades.Persona;
import com.samuel.entidades.PersonasProductos;
import com.samuel.entidades.Producto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class Coordinador {

	private VentanaPrincipal miVentanaPrincipal;
	private RegistrarPersonasGui miRegistrarPersonasGui;
	private RegistrarMascotasGui miRegistrarMascotasGui;
	private RegistrarProductosGui miRegistrarProductosGui;
	private PersonaDao miPersonaDao;
	private MascotaDao miMascotaDao;
	private ProductoDao miProductoDao;
	private ConsultarPersonaGui miColsultaPersonaGui;
	private ConsultarMascotasGui miConsultarMascotasGui;
	private ConsultarProductosGui miConsultarProductosGui;
	private TotalDePersonasRegistradas miTotalDePersonasRegistradas;
	private TotalDeMascotasRegistradas miTotalDeMascotasRegistradas;
	private TotalDeProductos miTotalDeProductos;

	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal=miVentanaPrincipal;
		
	}

	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
		this.miRegistrarPersonasGui=miRegistrarPersonasGui;
		
	}

	public void setRegistrarMascotasGui(RegistrarMascotasGui miRegistrarMascotasGui) {
		this.miRegistrarMascotasGui=miRegistrarMascotasGui;
		
	}

	public void setRegistrarProductosGui(RegistrarProductosGui miRegistrarProductosGui) {
		this.miRegistrarProductosGui=miRegistrarProductosGui;
		
	}

	public void setPersonaDao(PersonaDao miPersonaDao) {
		this.miPersonaDao=miPersonaDao;
		
	}

	public void setMascotaDao(MascotaDao miMascotaDao) {
		this.miMascotaDao=miMascotaDao;
		
	}


	public void setProductoDao(ProductoDao miProductoDao) {
		this.miProductoDao=miProductoDao;
		
	}

	
	public void setConsultarMascotaGui(ConsultarMascotasGui miConsultarMascotasGui) {
		this.miConsultarMascotasGui=miConsultarMascotasGui;
	}
	
	public void setConsultarPersonaGui(ConsultarPersonaGui miColsultaPersonaGui) {
		this.miColsultaPersonaGui=miColsultaPersonaGui;
	}
	
	public void setConsultarProductosGui(ConsultarProductosGui miConsultarProductosGui) {
		this.miConsultarProductosGui=miConsultarProductosGui;
		
	}

	public void setTotalDePersonasRegistradas(TotalDePersonasRegistradas miTotalDePersonasRegistradas) {
		this.miTotalDePersonasRegistradas=miTotalDePersonasRegistradas;
		
	}
	
	public void setTotalDeMascotasRegistradas(TotalDeMascotasRegistradas miTotalDeMascotasRegistradas) {
		this.miTotalDeMascotasRegistradas=miTotalDeMascotasRegistradas;
		
	}
	
	public void setTotalDeProductos(TotalDeProductos miTotalDeProductos) {
		this.miTotalDeProductos = miTotalDeProductos;
		
	}
	
	public void mostrarVentanaRegistroPersonas() {
		miRegistrarPersonasGui.setVisible(true);
	}

	public void mostrarVentanaRegistroMascotas() {
		miRegistrarMascotasGui.setVisible(true);
		
	}
	
	public void mostrarVentanaConsultaPersona() {
		miColsultaPersonaGui.setVisible(true);
	}
	
	public void mostrarVentanaConsultaMascotas() {
		miConsultarMascotasGui.setVisible(true);
	}
	
	public void mostrarVentanaConsultarProductos() {
		miConsultarProductosGui.setVisible(true);
	}
	
	public void mostrarVentanaTotalDePersonasRegistradas() {
		miTotalDePersonasRegistradas.setVisible(true);
	}
	public void mostrarVentanaTotalDeMascotasRegistradas() {
		miTotalDeMascotasRegistradas.setVisible(true);
	}
	public void mostrarVentanaTotalDeProductos() {
		miTotalDeProductos.setVisible(true);
	}
	
	public void registrarVentanaRegistrarProductos() {
		
		miRegistrarProductosGui.setVisible(true);
	}
	

	// Funciones

	public String  registrarPersona(Persona miPersona) {
		
		return miPersonaDao.registrarPersona(miPersona);
	}

	public Persona consultarPersona(Long idPersona) {
		
		Object valor = miPersonaDao.consultarPersona(idPersona);
		
		if ( valor == null ) {
			JOptionPane.showMessageDialog(null, "No se pudo encontrar la persona","Error 404",JOptionPane.ERROR_MESSAGE);
			return null;
		}else {
			return miPersonaDao.consultarPersona(idPersona);
		}

		
	}

	public String actualizarPersona(Persona miPersona) {

		return miPersonaDao.actualizarPersona(miPersona);
	}

	public String eliminarPersona(Persona miPersona) {

		return miPersonaDao.eliminarPersona(miPersona);
	}

	public List<Persona> consultarListaPersonas() {

		return miPersonaDao.consultarListaPersonas();
	}

	public String registrarMascota(Mascota miMascota) {

		return miMascotaDao.registrarMascota(miMascota);
	}

	public Mascota consultarMascota(Long idMascota) {

		return miMascotaDao.consultarMascota(idMascota);
	}

	public List<Mascota> consultarListaMascotas() {

		return miMascotaDao.consultarListaMascotas();
	}

	public List<Mascota> consultarListaMascotasPorSexo(String sexo) {

		return miMascotaDao.consultarListaMascotasPorSexo(sexo);
	}

	public String registrarProducto(Producto miProducto) {

		return miProductoDao.registrarProducto(miProducto);
	}

	public Producto consultarProducto(Long idProducto) {

		return miProductoDao.consultarProducto(idProducto);
	}

	public String actualizarProducto(Producto miProducto) {

		return miProductoDao.actualizarProducto(miProducto);
	}

	public String eliminarProducto(Producto miProducto) {

		return miProductoDao.eliminarProducto(miProducto);
	}

	public List<Producto> consultarListaProductos() {

		return miProductoDao.consultarListaProductos();
	}
	
	public String registrarCompra(PersonasProductos producto) {
		
		return miProductoDao.registrarCompra(producto);
	}

	public String actualizarMascota(Mascota miMascota) {

		return miMascotaDao.actualizarMascota(miMascota);
	}

	public String eliminarMascota(Mascota miMascota) {

		return miMascotaDao.eliminarMascota(miMascota);
	}

	
}
