package com.samuel.vista.gui;
import com.samuel.aplicacion.controlador.*;
import com.samuel.entidades.Mascota;
import com.samuel.entidades.Persona;
import com.samuel.entidades.PersonasProductos;
import com.samuel.entidades.Producto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TotalDeProductos extends JDialog implements ActionListener{

	private JPanel miPanel;
	private JTextArea AreaResultado;
	private Coordinador miCoordinador;
	private JButton btnConsultarTodosLosProductos;
	private JButton btnLimpiar;
	private JButton btnComprar;
	private JTextField txtId;
	private JTextField textIdPersona;
	private JLabel lblIdPr;
	private JLabel lblIdPersona;

	
	public TotalDeProductos() {
		setBounds(100, 100, 450, 314);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel etiTitulo = new JLabel("Total De Productos y Compras");
		etiTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		etiTitulo.setBounds(31, 11, 375, 24);
		miPanel.add(etiTitulo);
		
		AreaResultado = new JTextArea();
		AreaResultado.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(AreaResultado, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(31, 46, 375, 133);
		miPanel.add(scroll);
		
		btnConsultarTodosLosProductos = new JButton("Consultar");
		btnConsultarTodosLosProductos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarTodosLosProductos.setBounds(293, 195, 113, 31);
		btnConsultarTodosLosProductos.addActionListener(this);
		miPanel.add(btnConsultarTodosLosProductos);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpiar.setBounds(293, 233, 113, 31);
		btnLimpiar.addActionListener(this);
		miPanel.add(btnLimpiar);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnComprar.setBounds(31, 233, 154, 31);
		btnComprar.addActionListener(this);
		miPanel.add(btnComprar);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Arial", Font.PLAIN, 12));
		txtId.setBounds(31, 202, 71, 20);
		miPanel.add(txtId);
		txtId.setColumns(10);
		
		lblIdPr = new JLabel("ID Producto");
		lblIdPr.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIdPr.setBounds(31, 188, 71, 14);
		miPanel.add(lblIdPr);
		
		textIdPersona = new JTextField();
		textIdPersona.setFont(new Font("Arial", Font.PLAIN, 12));
		textIdPersona.setColumns(10);
		textIdPersona.setBounds(112, 202, 71, 20);
		miPanel.add(textIdPersona);
		
		lblIdPersona = new JLabel("ID Persona");
		lblIdPersona.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIdPersona.setBounds(112, 188, 71, 14);
		miPanel.add(lblIdPersona);
		
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}


	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == btnConsultarTodosLosProductos ) {
			
			AreaResultado.setText("");
			
			System.out.println("Lista de Productos");
			List<Producto> listaProductos = miCoordinador.consultarListaProductos();
			
			for (Producto producto : listaProductos) {
				AreaResultado.setText(AreaResultado.getText()+producto);
			}
		}
		else if( e.getSource() == btnLimpiar ) {
			
			AreaResultado.setText("");
		}
		else if( e.getSource() == btnComprar ) {
			if ( txtId.getText().equals("") || textIdPersona.getText().equals("") ) {
				
				JOptionPane.showMessageDialog(null, "Campos incompletos!");
			}else {
				PersonasProductos producto;
				
				Long personaId;
				Long productoId;
				int opc = 0;

				producto = new PersonasProductos();
				productoId = Long.parseLong(txtId.getText());
				personaId = Long.parseLong(textIdPersona.getText());
				
				producto.setPersonaId(personaId);
				producto.setProductoId(productoId);
				
				System.out.println(miCoordinador.registrarCompra(producto));
				System.out.println();
				
			}
			
			
		}
		
	}
}
