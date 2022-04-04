package clases;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.samuel.dao.PersonaDao;
import com.samuel.entidades.Mascota;
import com.samuel.entidades.Nacimiento;
import com.samuel.entidades.Persona;

public class GestionPersonas {
	
	PersonaDao miPersonaDao = new PersonaDao();
	
	public GestionPersonas() {
		/**
		String menu = "GESTION PERSONAS\n\n";
			   menu+= "1. Registrar Persona \n";
			   menu+= "2.Consultar Persona \n";
			   menu+= "3.Consultar lista de personas \n";
			   menu+= "4. Actualizar persona \n";
			   menu+= "5. Eliminar persona \n";
			   menu+= "6. Salir \n";
			   
			   int opc = 0;
			   
			   while ( opc != 6) {
				
				   opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
				   
				   switch ( opc ) {
				   	case 1: registrar(); break;
					case 2: consultar(); break;
					case 3: consultarLista(); break;
					case 4: actualizarNombre(); break;
					case 5: eliminar(); break;
					case 6: miPersonaDao.close(); break;

				}
				   
			}
		**/ 
		
	}
	
	private void registrar() {
		
		Persona miPersona = new Persona();
		
		String opc = "";
		
		miPersona.setIdPersona(Long.parseLong(JOptionPane.showInputDialog("Ingrese el documento de la persona: ")));
		miPersona.setNombre(JOptionPane.showInputDialog("Ingrese el nombre: "));
		miPersona.setTelefono(JOptionPane.showInputDialog("Ingrese el teléfono: "));
		miPersona.setProfesion(JOptionPane.showInputDialog("Ingrese la profesión: "));
		miPersona.setTipo(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo: ")));
		
		miPersona.setNacimiento( obtenerDatosNacimiento() );
		
		do {
			opc = JOptionPane.showInputDialog("Desea registrar una mascota?\n\n- SI\n- NO\n\n").toUpperCase();
			
			if ( opc.equals("SI") ) {
				Mascota miMascota = new Mascota();
				miMascota.setIdMascota(null);
				miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la mascota: "));
				miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la raza de la mascota: "));
				miMascota.setColor(JOptionPane.showInputDialog("Ingrese el color de la mascota: "));
				miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de la mascota: "));
				miMascota.setDuenio(miPersona);
				
				miPersona.getListaMascotas().add(miMascota);
			}	
		} while ( opc.equals("SI"));
		
		System.out.println(miPersonaDao.registrarPersona(miPersona));
		System.out.println();
	}
	
	private Nacimiento obtenerDatosNacimiento() {
		
		int dia  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DIA de nacimiento: "));
		int mes  = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el MES de nacimiento: "));
		int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el AÑO de nacimiento: "));
		
		Nacimiento datosNacimiento = new Nacimiento();
		
		datosNacimiento.setIdNacimiento(null);
		datosNacimiento.setFechaNacimiento(LocalDate.of(anio, mes, dia));
		datosNacimiento.setCiudadNacimiento(JOptionPane.showInputDialog("Ingrese la ciudad de nacimiento: ").toUpperCase());
		datosNacimiento.setDepartamentoNacimiento(JOptionPane.showInputDialog("Ingrese el departamento de nacimiento: ").toUpperCase());
		datosNacimiento.setPaisNacimiento(JOptionPane.showInputDialog("Ingrese el pais de nacimiento: ").toUpperCase());
		
		return datosNacimiento;
		
	}
	
	private void consultar() {
		Long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID de la persona: "));
		
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
		
		if ( miPersona != null ) {
			System.out.println(miPersona);
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("No se encontró la persona");
		}
		System.out.println();
	}
	
	private void consultarLista() {
		System.out.println("Lista de Personas");
		List<Persona> listaPersonas = miPersonaDao.consultarListaPersonas();
		
		for (Persona persona : listaPersonas) {
			System.out.println( persona );
			
		}
		
	}
	
	private void actualizarNombre() {
		
		Long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID de la persona: "));
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
		
		if ( miPersona != null ) {
			System.out.println(miPersona);
			System.out.println();
			
			miPersona.setNombre(JOptionPane.showInputDialog("Ingrese el nombre: "));
			
			System.out.println(miPersonaDao.actualizarPersona(miPersona));
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("No se encontró la Persona");
		}
		System.out.println();
		
	}
	
	private void eliminar() {
		Long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID de la persona: "));
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
		
		if ( miPersona != null ) {
			System.out.println(miPersona);
			System.out.println();
			
			miPersona.setNombre(JOptionPane.showInputDialog("Ingrese el nombre: "));
			
			System.out.println(miPersonaDao.eliminarPersona(miPersona));
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("No se encontró la Persona");
		}
		System.out.println();
		
	}

}
