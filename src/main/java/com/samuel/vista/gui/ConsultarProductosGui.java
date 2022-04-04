package com.samuel.vista.gui;
import com.samuel.aplicacion.controlador.*;
import com.samuel.entidades.Producto;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

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
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class ConsultarProductosGui extends JDialog implements ActionListener{

	private JPanel miPanel;
	private JTextField textId;
	private Coordinador miCoordinador;
	private JButton btnEliminar;
	private JButton btnConsultar;
	private JButton btnCancelar;
	private JTextField textNombre;
	private JTextField textValor;
	private JButton btnActualizar;

	
	public ConsultarProductosGui() {
		setBounds(100, 100, 474, 300);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel etiTitulo = new JLabel("Gestion Productos");
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		etiTitulo.setBounds(150, 11, 176, 20);
		miPanel.add(etiTitulo);
		
		JLabel etiId = new JLabel("Id Producto:");
		etiId.setFont(new Font("Arial", Font.PLAIN, 12));
		etiId.setBounds(29, 50, 106, 20);
		miPanel.add(etiId);
		
		textId = new JTextField();
		textId.setBounds(29, 66, 136, 20);
		miPanel.add(textId);
		textId.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(29, 205, 93, 23);
		btnEliminar.addActionListener(this);
		miPanel.add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(188, 65, 100, 23);
		btnConsultar.addActionListener(this);
		miPanel.add(btnConsultar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(235, 205, 86, 23);
		btnCancelar.addActionListener(this);
		miPanel.add(btnCancelar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(29, 128, 106, 20);
		miPanel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		textNombre.setColumns(10);
		textNombre.setBounds(29, 145, 136, 20);
		miPanel.add(textNombre);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblValor.setBounds(188, 128, 106, 20);
		miPanel.add(lblValor);
		
		textValor = new JTextField();
		textValor.setFont(new Font("Arial", Font.PLAIN, 12));
		textValor.setColumns(10);
		textValor.setBounds(188, 145, 136, 20);
		miPanel.add(textValor);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(132, 205, 93, 23);
		btnActualizar.addActionListener(this);
		miPanel.add(btnActualizar);
	}

	
	
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}




	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == btnCancelar ) {
			
			setVisible(false);
		}
		else if ( e.getSource() == btnConsultar ) {
			
			if ( textId.getText().equals("") ) {
				JOptionPane.showMessageDialog(null, "Hay campos incompletos");
				}else {
				
				Long idProducto = Long.parseLong(textId.getText());
				
				Producto miProducto = miCoordinador.consultarProducto( idProducto );
				
				
				
				if ( miProducto != null ) {
					textNombre.setText(miProducto.getNombreProducto());
					textValor.setText(miProducto.getPrecioProducto()+"");
					System.out.println();
				}
				else {
					System.out.println();
					JOptionPane.showMessageDialog(null, "No se encontró el producto con ID "+textId.getText(),"ERROR 404",JOptionPane.ERROR_MESSAGE);
					textNombre.setText("");
					textValor.setText("");
				}
				System.out.println();
			}
		}
		else if ( e.getSource() == btnActualizar ) {
			
			if ( textId.getText().equals("") || textNombre.getText().equals("") || textValor.getText().equals("") ) {
				JOptionPane.showMessageDialog(null, "Hay campos incompletos");
			}else {
			
				Long idProducto = Long.parseLong(textId.getText());
				Producto miProducto = miCoordinador.consultarProducto( idProducto );
				
				if ( miProducto != null) {
					System.out.println(miProducto);
					System.out.println();
					miProducto.setNombreProducto(textNombre.getText());
					miProducto.setPrecioProducto(Double.parseDouble(textValor.getText()));
					
					System.out.println(miCoordinador.actualizarProducto(miProducto));
					System.out.println();
					
				}
				System.out.println();
			}
		}
		else if ( e.getSource() == btnEliminar ) {
			
			if ( textId.getText().equals("") ) {
				JOptionPane.showMessageDialog(null, "Hay campos incompletos");
				}else {
					
					Long idProducto = Long.parseLong(textId.getText());
					Producto miProducto = miCoordinador.consultarProducto( idProducto );
					
					if ( miProducto != null) {
						System.out.println(miProducto);
						System.out.println();
						
						System.out.println(miCoordinador.eliminarProducto(miProducto));
						System.out.println();
						textId.setText("");
						textNombre.setText("");
						textValor.setText("");
						
					}else {
						System.out.println();
						System.out.println("No se encontró el producto");
						
					}
					
					System.out.println();
				}
		}
	}
}
