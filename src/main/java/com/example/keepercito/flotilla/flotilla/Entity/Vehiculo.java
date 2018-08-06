package com.example.keepercito.flotilla.flotilla.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="vehiculo")
public class Vehiculo{

    private int idVehiculo;
    private String nombre;
    private String numeroChasis;
    private String numeroMotor;
    private String placa;
    private Marca idMarca;
	private TipoVehiculo idTipoVehiculo;
	private Set<Reserva> reservas;
	private Set<Mantenimiento> mantenimientos;

	public Vehiculo(int idVehiculo, String nombre, String numeroChasis, String numeroMotor, String placa, Marca idMarca, TipoVehiculo idTipoVehiculo, Set<Reserva> reservas, Set<Mantenimiento> mantenimientos) {
		this.idVehiculo = idVehiculo;
		this.nombre = nombre;
		this.numeroChasis = numeroChasis;
		this.numeroMotor = numeroMotor;
		this.placa = placa;
		this.idMarca = idMarca;
		this.idTipoVehiculo = idTipoVehiculo;
		this.reservas = reservas;
		this.mantenimientos = mantenimientos;
	}

	public Vehiculo() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_vehiculo")
	public int getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	@Column(name="nombre_vehiculo")
	@NotNull
	@Size(max = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name="numero_chasis")
	@NotNull
	@Size(min = 15, max = 15)
	public String getNumeroChasis() {
		return this.numeroChasis;
	}

	public void setNumeroChasis(String numeroChasis) {
		this.numeroChasis = numeroChasis;
	}

	@Column(name="numero_motor")
	@NotNull
	@Size(min=15,max=15)
	public String getNumeroMotor() {
		return this.numeroMotor;
	}

	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}

	@Column(name="placa")
	@NotNull
	@Size(min = 8, max = 8)
	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/*
	 * Un vehiculo puede estar asociado a una marca. En el atributo
	 * idMarca, en la anotacion "joincolumn" el parametro name, debe de ser
	 * el nombre de la columna referenciada en la tabla marca
	 */
	@ManyToOne
	@JoinColumn(name="id_marca")
	public Marca getIdMarca() {
		return this.idMarca;
	}

	public void setIdMarca(Marca idMarca) {
		this.idMarca = idMarca;
	}

	/*
	 * Un vehiculo puede estar asociado a un tipo vehiculo. En el atributo
	 * idTipoVehiculo, en la anotacion "joincolumn" el parametro name, debe de
	 * ser el nombre de la columna referenciada en la tabla tipo_vehiculo
	 */
	@ManyToOne
	@JoinColumn(name="id_tipo_vehiculo")
	public TipoVehiculo getIdTipoVehiculo() {
		return this.idTipoVehiculo;
	}

	public void setIdTipoVehiculo(TipoVehiculo idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	/*
	*	un vehiculo podra estar asociado a varias reservas.
	*	El atributoto Set "reservas", en su anotacion "onetomany"
	*	en el parametro "mappedby" debe coincider con el nombre del atributo
	*	del tipo "Vehiculo" en la clase reserva*/
	@OneToMany(mappedBy="idVehiculo",cascade=CascadeType.ALL)
	public Set<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}
	/*
	*	un vehiculo podra estar asociado a varios mantenimientos.
	*	El atributo Set "mantenimientos", en su anotacion "onetomany"
	*	en el parametro "mappedby" debe coincider con el nombre del atributo
	*	del tipo "Vehiculo" en la clase Mantenimiento*/
	@OneToMany(mappedBy="idVehiculo",cascade=CascadeType.ALL)
	public Set<Mantenimiento> getMantenimientos() {
		return this.mantenimientos;
	}

	public void setMantenimientos(Set<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}
}