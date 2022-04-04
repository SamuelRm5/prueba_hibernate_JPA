package com.samuel.aplicacion.controlador;
import com.samuel.vista.gui.*;

import com.samuel.dao.*;

public class Relaciones {
	
	VentanaPrincipal miVentanaPrincipal;
	
	public Relaciones() {
		
		Coordinador miCoordinador;
		RegistrarPersonasGui miRegistrarPersonasGui;
		RegistrarMascotasGui miRegistrarMascotasGui;
		RegistrarProductosGui miRegistrarProductosGui;
		ConsultarPersonaGui miColsultaPersonaGui;
		ConsultarMascotasGui miConsultarMascotasGui;
		ConsultarProductosGui miConsultarProductosGui;
		TotalDePersonasRegistradas miTotalDePersonasRegistradas;
		TotalDeMascotasRegistradas miTotalDeMascotasRegistradas;
		TotalDeProductos miTotalDeProductos;
		PersonaDao miPersonaDao;
		MascotaDao miMascotaDao;
		ProductoDao miProductoDao;
		
		// se instancia por unica ocasion las clases declaradas 
		
		miVentanaPrincipal= new VentanaPrincipal();
		miCoordinador= new Coordinador();
		miRegistrarPersonasGui = new RegistrarPersonasGui(miVentanaPrincipal, true);
		miRegistrarMascotasGui = new RegistrarMascotasGui(miVentanaPrincipal, true, "");
		miRegistrarProductosGui= new RegistrarProductosGui(miVentanaPrincipal, true);
		miColsultaPersonaGui=new ConsultarPersonaGui();
		miConsultarMascotasGui=new ConsultarMascotasGui();
		miConsultarProductosGui=new ConsultarProductosGui();
		miTotalDePersonasRegistradas=new TotalDePersonasRegistradas();
		miTotalDeMascotasRegistradas= new TotalDeMascotasRegistradas();
		miTotalDeProductos = new TotalDeProductos();
		miPersonaDao= new PersonaDao();
		miMascotaDao= new MascotaDao();
		miProductoDao= new ProductoDao();
		
		//Se establece la relaci�n entre el coordinador y cada instancia unica
		//Al coordinador se le asigna el control de cada clase unica
		
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
		miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);
		miCoordinador.setConsultarPersonaGui(miColsultaPersonaGui);
		miCoordinador.setConsultarMascotaGui(miConsultarMascotasGui);
		miCoordinador.setConsultarProductosGui(miConsultarProductosGui);
		miCoordinador.setTotalDePersonasRegistradas(miTotalDePersonasRegistradas);
		miCoordinador.setTotalDeMascotasRegistradas(miTotalDeMascotasRegistradas);
		miCoordinador.setTotalDeProductos(miTotalDeProductos);
		miCoordinador.setPersonaDao(miPersonaDao);
		miCoordinador.setMascotaDao(miMascotaDao);
		miCoordinador.setProductoDao(miProductoDao);
		
		//A cada clase unica se le asigna la unica instancia del coordinador
		
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		miRegistrarProductosGui.setCoordinador(miCoordinador);
		miColsultaPersonaGui.setCoordinador(miCoordinador);
		miConsultarMascotasGui.setCoordinador(miCoordinador);
		miConsultarProductosGui.setCoordinador(miCoordinador);
		miTotalDePersonasRegistradas.setCoordinador(miCoordinador);
		miTotalDeMascotasRegistradas.setCoordinador(miCoordinador);
		miTotalDeProductos.setCoordinador(miCoordinador);
		miPersonaDao.setCoordinador(miCoordinador);
		miMascotaDao.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);
		

		//Se muestra la ventana principal.
		
	}
	
	public void iniciar() {
		miVentanaPrincipal.setVisible(true);
	}
}
