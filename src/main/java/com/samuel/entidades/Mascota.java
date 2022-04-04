package com.samuel.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table( name = "mascotas" )
public class Mascota implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id_mascota")
	private Long idMascota;
	
	@Column( nullable = false, length = 45)
	private String nombre;
	
	@Column( length = 45)
	private String raza;
	
	@Column( length = 45)
	private String color;
	
	@Column( length = 45)
	private String sexo;
	
	@ManyToOne
	@JoinColumn( name = "persona_id", referencedColumnName = "id_persona" )
	private Persona duenio;
	
	

	public Mascota() {
		
	};

	public Mascota(String nombre, String raza, String color, String sexo, Persona duenio) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.color = color;
		this.sexo = sexo;
		this.duenio = duenio;
		
	}
	
	
	public Persona getDuenio() {
		return duenio;
	}

	public void setDuenio(Persona duenio) {
		this.duenio = duenio;
	}

	public Long getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Mascota ID = " + idMascota + "\n Nombre =" + nombre + "\n Raza =" + raza + "\n Color=" + color
				+ "\n Sexo=" + sexo + "\n -------------------------------------------- \n";
	}

}
