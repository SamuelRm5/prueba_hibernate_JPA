package com.samuel.vista.gui;
import com.samuel.aplicacion.controlador.*;
import com.samuel.entidades.Mascota;
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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

public class TotalDeMascotasRegistradas extends JDialog implements ActionListener{

	private JPanel miPanel;
	private JTextArea AreaResultado;
	private Coordinador miCoordinador;
	private JButton btnConsultarTodasLasMascotas;
	private JButton btnLimpiar;
	private JButton btnConsultarPorSexo;
	private JTextField txtSexo;

	
	public TotalDeMascotasRegistradas() {
		setBounds(100, 100, 450, 314);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel etiTitulo = new JLabel("Total De Mascotas");
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		etiTitulo.setBounds(135, 11, 168, 24);
		miPanel.add(etiTitulo);
		
		AreaResultado = new JTextArea();
		AreaResultado.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(AreaResultado, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(31, 46, 375, 133);
		miPanel.add(scroll);
		
		btnConsultarTodasLasMascotas = new JButton("consultar");
		btnConsultarTodasLasMascotas.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarTodasLasMascotas.setBounds(204, 233, 99, 31);
		btnConsultarTodasLasMascotas.addActionListener(this);
		miPanel.add(btnConsultarTodasLasMascotas);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLimpiar.setBounds(307, 233, 99, 31);
		btnLimpiar.addActionListener(this);
		miPanel.add(btnLimpiar);
		
		btnConsultarPorSexo = new JButton("consultar por sexo");
		btnConsultarPorSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConsultarPorSexo.setBounds(31, 233, 168, 31);
		btnConsultarPorSexo.addActionListener(this);
		miPanel.add(btnConsultarPorSexo);
		
		txtSexo = new JTextField();
		txtSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSexo.setBounds(31, 202, 168, 20);
		miPanel.add(txtSexo);
		txtSexo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sexo (opcional)");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(31, 188, 168, 14);
		miPanel.add(lblNewLabel);
		
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}


	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == btnConsultarTodasLasMascotas ) {
			
			AreaResultado.setText("");
			
			System.out.println("Lista de Mascotas");
			List<Mascota> listaMascotas = miCoordinador.consultarListaMascotas();
			
			for (Mascota mascota : listaMascotas) {
				AreaResultado.setText(AreaResultado.getText()+mascota);
			}
		}
		else if( e.getSource() == btnLimpiar ) {
			
			AreaResultado.setText("");
		}
		else if( e.getSource() == btnConsultarPorSexo ) {
			if ( txtSexo.getText().equals("") ) {
				
				JOptionPane.showMessageDialog(null, "Ingrese el sexo");
			}else {
				AreaResultado.setText("");
				
				System.out.println("Lista de Mascotas por sexo");
				String sexo = txtSexo.getText();
				
				List<Mascota> listaMascotas = miCoordinador.consultarListaMascotasPorSexo(sexo);
				
				for (Mascota mascota : listaMascotas) {
					AreaResultado.setText(AreaResultado.getText()+mascota);
				}
			}
			
			
		}
		
	}
}
