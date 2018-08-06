package com.example.keepercito.flotilla.flotilla.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="unidad")
public class Unidad{
    private int idUnidad;
    private String nombreUnidad;
	private String descripcion;
	private Set<Reserva> reservas;

	public Unidad(int idUnidad, String nombreUnidad, String descripcion, Set<Reserva> reservas) {
		this.idUnidad = idUnidad;
		this.nombreUnidad = nombreUnidad;
		this.descripcion = descripcion;
		this.reservas = reservas;
	}

	public Unidad() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_unidad")
	public int getIdUnidad(){
		return this.idUnidad;
	}

	public void setIdUnidad(int idUnidad){
		this.idUnidad = idUnidad;
	}

	@Column(name="nombre_unidad")
	@NotNull
	public String getNombreUnidad(){
		return this.nombreUnidad;
	}
	
	public void setNombreUnidad(String nombreUnidad){
		this.nombreUnidad = nombreUnidad;
	}

	@Column(name="descripcion")
	@NotNull
	@Size(max = 100)
	public String getDescripcion(){
		return this.descripcion;
	}

	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}

	/*
	 * una unidad podra ser asignada en varias reservas. El atributo Set
	 * "reservas", en su anotacion "onetomany" en el parametro "mappedby" debe
	 * coinsider con el nombre del atributo del tipo "Unidad" en la clase reserva
	 */
	@OneToMany(mappedBy="idUnidad",cascade=CascadeType.ALL)
	public Set<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}

}