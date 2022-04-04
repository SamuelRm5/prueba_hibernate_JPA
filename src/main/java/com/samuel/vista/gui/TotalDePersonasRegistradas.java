package com.samuel.vista.gui;
import com.samuel.aplicacion.controlador.*;
import com.samuel.entidades.Persona;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class TotalDePersonasRegistradas extends JDialog implements ActionListener{

	private JPanel miPanel;
	private JTextArea AreaResultado;
	private Coordinador miCoordinador;
	private JButton btnConsultarTodasLasPersonas;
	private JButton btnLimpiar;

	
	public TotalDePersonasRegistradas() {
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel etiTitulo = new JLabel("Total De Personas");
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		etiTitulo.setBounds(135, 11, 168, 24);
		miPanel.add(etiTitulo);
		
		AreaResultado = new JTextArea();
		AreaResultado.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(AreaResultado, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(31, 46, 375, 133);
		miPanel.add(scroll);
		
		btnConsultarTodasLasPersonas = new JButton("consultar");
		btnConsultarTodasLasPersonas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarTodasLasPersonas.setBounds(87, 215, 99, 31);
		btnConsultarTodasLasPersonas.addActionListener(this);
		miPanel.add(btnConsultarTodasLasPersonas);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpiar.setBounds(249, 215, 99, 31);
		btnLimpiar.addActionListener(this);
		miPanel.add(btnLimpiar);
		
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}


	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == btnConsultarTodasLasPersonas ) {
			
			System.out.println("Lista de Personas");
			List<Persona> listaPersonas = miCoordinador.consultarListaPersonas();
			
			for (Persona persona : listaPersonas) {
				AreaResultado.setText(AreaResultado.getText()+persona);
				
			}
		}
		else if( e.getSource() == btnLimpiar ) {
			
			AreaResultado.setText("");
		}
		
	}
}
