package clases;

import java.util.List;

import javax.swing.JOptionPane;

import com.samuel.dao.MascotaDao;
import com.samuel.dao.PersonaDao;
import com.samuel.entidades.Mascota;
import com.samuel.entidades.Persona;

public class GestionMascotas {
	
	MascotaDao miMascotaDao = new MascotaDao();
	
	public GestionMascotas() {
		
		String menu = "GESTION DE MASCOTAS\n\n";
			   menu+= "1. Registrar Mascota\n";
			   menu+= "2. Consultar Mascota\n";
			   menu+= "3. Consultar lista de mascotas\n";
			   menu+= "4. Consultar lista de mascotas por sexo\n";
			   menu+= "5. Actualizar mascotas\n";
			   menu+= "6. Eliminar mascota\n";
			   menu+= "7. salir\n\n";
			   
			   int opc = 0;
			   
			   while( opc != 7 ) {
				   opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
				   
				   switch ( opc ) {
				   	case 1: registrar(); break;
				   	case 2: consultar(); break;
				   	case 3: consultarLista(); break;
				   	case 4: consultarListaPorSexo(); break;
				   	case 5: actualizar(); break;
				   	case 6: eliminar(); break;
				   	case 7: miMascotaDao.close(); break;
				}
				   
			   }
	}
	
	private void registrar() {
		Mascota miMascota = new Mascota();
		miMascota.setIdMascota(null);
		miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la mascota: "));
		miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la raza de la mascota: "));
		miMascota.setColor(JOptionPane.showInputDialog("Ingrese el color de la mascota: "));
		miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de la mascota: "));
		
		Long idDuenio = Long.parseLong(JOptionPane.showInputDialog("Ingrese el documento del dueño: "));
		Persona duenio = new Persona();
		duenio = new PersonaDao().consultarPersona(idDuenio);
		miMascota.setDuenio(duenio);
		
		System.out.println(miMascotaDao.registrarMascota(miMascota));
		System.out.println();
		
	}
	
	private void consultar() {
		
		Long idMascota = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID de la mascota: "));
		
		Mascota miMascota = miMascotaDao.consultarMascota(idMascota);
		
		if ( miMascota != null ) {
			System.out.println( miMascota );
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("No se encontr� la mascota");
		}
		System.out.println();
	}
	
	private void consultarLista() {
		
		System.out.println("Lista de Mascotas");
		List<Mascota> listaMascotas = miMascotaDao.consultarListaMascotas();
		
		for (Mascota mascota : listaMascotas) {
			System.out.println(mascota);
		}
	}
	
	private void consultarListaPorSexo() {
	
		System.out.println("Lista de Mascotas por sexo");
		String sexo = JOptionPane.showInputDialog("Ingrese el sexo de la mascota: ");
		
		List<Mascota> listaMascotas = miMascotaDao.consultarListaMascotasPorSexo(sexo);
		
		for (Mascota mascota : listaMascotas) {
			System.out.println(mascota);
		}
	}
	
	private void actualizar() {
		Long idMascota = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID de la mascota para actualizar: "));
		Mascota miMascota = miMascotaDao.consultarMascota(idMascota);
		
		if ( miMascota != null) {
			System.out.println(miMascota);
			System.out.println();
			miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la mascota: "));
			miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la raza de la mascota: "));
			miMascota.setColor(JOptionPane.showInputDialog("Ingrese el color de la mascota: "));
			miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de la mascota: "));
			
			System.out.println(miMascotaDao.actualizarMascota(miMascota));
			System.out.println();
			
		}else {
			System.out.println();
			System.out.println("No se encontr� la mascota");
			
		}
		System.out.println();
				
	}
	
	private void eliminar() {
		
		Long idMascota = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID de la mascota para actualizar: "));
		Mascota miMascota = miMascotaDao.consultarMascota(idMascota);
		
		if ( miMascota != null ) {
			System.out.println(miMascota);
			System.out.println();
			
			System.out.println(miMascotaDao.eliminarMascota(miMascota));
			System.out.println();
		}else {
			
			System.out.println();
			System.out.println("No se encontr� la mascota");
			
		}
		System.out.println();
	}

}
