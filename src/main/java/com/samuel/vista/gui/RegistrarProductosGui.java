package com.samuel.vista.gui;
import com.samuel.aplicacion.controlador.*;
import com.samuel.entidades.Producto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrarProductosGui extends JDialog implements ActionListener {
	
	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private Coordinador miCoordinador;
	private JTextField txtValorPr;
	private JTextField textNombrePr;


	/**
	 * Create the dialog.
	 * @param b 
	 * @param ventanaPrincipal 
	 * @param documento 
	 */
	public RegistrarProductosGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 412, 235);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		iniciarComponentes();
		
		
	}


	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("REGISTRAR PRODUCTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 26, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 76, 380, 109);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 43, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(271, 66, 89, 23);
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(172, 66, 89, 23);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);
		
		JLabel etiProducto = new JLabel("Valor:");
		etiProducto.setBounds(200, 11, 45, 21);
		panel.add(etiProducto);
		
		txtValorPr = new JTextField();
		txtValorPr.setBounds(235, 12, 86, 20);
		panel.add(txtValorPr);
		txtValorPr.setColumns(10);
		
		JLabel etiIdPersona = new JLabel("Nombre:");
		etiIdPersona.setBounds(24, 11, 75, 21);
		panel.add(etiIdPersona);
		
		textNombrePr = new JTextField();
		textNombrePr.setBounds(84, 11, 86, 20);
		panel.add(textNombrePr);
		textNombrePr.setColumns(10);
	}



	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
	
	public void limpiar() {
		txtValorPr.setText("");
		textNombrePr.setText("");
	}


	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == btnCancelar ) {
			
			setVisible(false);
		}
		else if ( e.getSource() == btnRegistrar ) {
			if ( textNombrePr.getText().equals("") || txtValorPr.getText().equals("") ) {
				JOptionPane.showMessageDialog(null, "Hay campos incompletos");
				}else {
				
				Producto miProducto = new Producto();
				
				miProducto.setIdProducto(null);
				miProducto.setNombreProducto(textNombrePr.getText());
				miProducto.setPrecioProducto(Double.parseDouble(txtValorPr.getText()));
				
				
				System.out.println(miCoordinador.registrarProducto(miProducto));
				textNombrePr.setText("");
				txtValorPr.setText("");
				System.out.println();
			}
		}
		
	}
}
