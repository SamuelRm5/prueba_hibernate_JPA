package com.samuel.vista.gui;
import com.samuel.aplicacion.controlador.*;
import com.samuel.entidades.Mascota;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class ConsultarMascotasGui extends JDialog implements ActionListener{

	private JPanel miPanel;
	private JTextField textDocumnto;
	private JTextField textNombre;
	private JTextField textRaza;
	private JTextField textSexo;
	private JTextField textColor;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private Coordinador miCoordinador;
	private JButton btnCancelar;

	public ConsultarMascotasGui() {
		
		setBounds(100, 100, 453, 314);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setBounds(242, 72, 107, 23);
		btnConsultar.addActionListener(this);
		miPanel.add(btnConsultar);
		
		JLabel etiIdMascota = new JLabel("Id de la mascota");
		etiIdMascota.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiIdMascota.setBounds(22, 72, 107, 23);
		miPanel.add(etiIdMascota);
		
		textDocumnto = new JTextField();
		textDocumnto.setBounds(132, 74, 100, 20);
		miPanel.add(textDocumnto);
		textDocumnto.setColumns(10);
		
		JLabel etiTitulo = new JLabel("Gestion de mascotas");
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		etiTitulo.setBounds(122, 11, 203, 23);
		miPanel.add(etiTitulo);
		
		JLabel etiNombre = new JLabel("Nombre:");
		etiNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiNombre.setBounds(22, 133, 66, 28);
		miPanel.add(etiNombre);
		
		JLabel etiRaza = new JLabel("Raza:");
		etiRaza.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiRaza.setBounds(246, 136, 50, 22);
		miPanel.add(etiRaza);
		
		textNombre = new JTextField();
		textNombre.setBounds(122, 139, 100, 20);
		miPanel.add(textNombre);
		textNombre.setColumns(10);
		
		textRaza = new JTextField();
		textRaza.setBounds(306, 139, 117, 20);
		miPanel.add(textRaza);
		textRaza.setColumns(10);
		
		JLabel etiSexo = new JLabel("Sexo:");
		etiSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiSexo.setBounds(22, 175, 59, 28);
		miPanel.add(etiSexo);
		
		textSexo = new JTextField();
		textSexo.setBounds(122, 181, 100, 20);
		miPanel.add(textSexo);
		textSexo.setColumns(10);
		
		JLabel etiColor = new JLabel("Color:");
		etiColor.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiColor.setBounds(246, 175, 50, 28);
		miPanel.add(etiColor);
		
		textColor = new JTextField();
		textColor.setBounds(306, 181, 117, 20);
		miPanel.add(textColor);
		textColor.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(217, 241, 90, 23);
		btnEliminar.addActionListener(this);
		miPanel.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(107, 241, 100, 23);
		btnActualizar.addActionListener(this);
		miPanel.add(btnActualizar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(317, 241, 90, 23);
		btnCancelar.addActionListener(this);
		miPanel.add(btnCancelar);
	}
	
	private void limpiar() {
		textDocumnto.setText("");
		textNombre.setText("");
		textRaza.setText("");
		textColor.setText("");
		textSexo.setText("");

	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}

	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == btnConsultar ) {
			
			Long idMascota = Long.parseLong(textDocumnto.getText());
			
			Mascota miMascota = miCoordinador.consultarMascota(idMascota);
			
			if ( miMascota != null ) {
				System.out.println( miMascota );
				textNombre.setText(miMascota.getNombre());
				textColor.setText(miMascota.getColor());
				textRaza.setText(miMascota.getRaza());
				textSexo.setText(miMascota.getSexo());
				System.out.println();
			}
			else {
				System.out.println();
				System.out.println("No se encontr� la mascota");
				JOptionPane.showMessageDialog(null, "No se encontró la mascota","ERROR 404",JOptionPane.ERROR_MESSAGE);
			}
			System.out.println();
		}
		else if ( e.getSource() == btnActualizar ) {
			
			if ( textNombre.getText().equals("") || textDocumnto.getText().equals("") || textColor.getText().equals("") || textRaza.getText().equals("") || textSexo.getText().equals("") ) {
				JOptionPane.showMessageDialog(null, "Campos incompletos!");
			}
			else {
				
				Long idMascota = Long.parseLong(textDocumnto.getText());
				Mascota miMascota = miCoordinador.consultarMascota(idMascota);
				
				if ( miMascota != null) {
					System.out.println(miMascota);
					System.out.println();
					miMascota.setNombre(textNombre.getText());
					miMascota.setRaza(textRaza.getText());
					miMascota.setColor(textColor.getText());
					miMascota.setSexo(textSexo.getText());
					
					System.out.println(miCoordinador.actualizarMascota(miMascota));
					System.out.println();
					limpiar();
					
				}
				System.out.println();
			}
		}
		else if ( e.getSource() == btnEliminar ) {
			
			if ( textDocumnto.getText().equals("") ) {
				
				JOptionPane.showMessageDialog(null, "Campos incompletos!");
			}else {
				
				Long idMascota = Long.parseLong(textDocumnto.getText());
				Mascota miMascota = miCoordinador.consultarMascota(idMascota);
				
				if ( miMascota != null ) {
					System.out.println(miMascota);
					System.out.println();
					
					System.out.println(miCoordinador.eliminarMascota(miMascota));
					System.out.println();
					limpiar();
				}
				System.out.println();
			}
		}
		else if ( e.getSource() == btnCancelar ) {
			
			setVisible(false);
		}
		
	}
}
