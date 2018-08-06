package com.example.keepercito.flotilla.flotilla.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="reserva")
public class Reserva{

    private int idReserva;
    private Unidad idUnidad;
    private Vehiculo idVehiculo;
    private Date fechaReserva;
    private Date fechaViaje;
    private String destinoViaje;
    private String motivoViaje;
    private DetalleReserva idDetalleReserva;

	public Reserva(int idReserva, Unidad idUnidad, Vehiculo idVehiculo, Date fechaReserva, Date fechaViaje, String destinoViaje, String motivoViaje, DetalleReserva idDetalleReserva) {
		this.idReserva = idReserva;
		this.idUnidad = idUnidad;
		this.idVehiculo = idVehiculo;
		this.fechaReserva = fechaReserva;
		this.fechaViaje = fechaViaje;
		this.destinoViaje = destinoViaje;
		this.motivoViaje = motivoViaje;
		this.idDetalleReserva = idDetalleReserva;
	}

    public Reserva() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_reserva")
	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	/*
	 * Una reserva puede tener asignado unicamente una unidad. En el atributo
	 * idUnidad, en la anotacion "joincolumn" el parametro name, debe de ser
	 * el nombre de la columna referenciada en la tabla unidad
	 */
    @ManyToOne
    @JoinColumn(name="id_unidad")
	public Unidad getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(Unidad idUnidad) {
		this.idUnidad = idUnidad;
	}

	/*
	 * Una reserva puede tener asignado unicamente un vehiculo. En el atributo
	 * idVehiculo, en la anotacion "joincolumn" el parametro name, debe de ser
	 * el nombre de la columna referenciada en la tabla vehiculo
	 */
    @ManyToOne
    @JoinColumn(name="id_vehiculo")
	public Vehiculo getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(Vehiculo idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

    @Column(name="fecha_reserva")
    @NotNull
	public Date getFechaReserva() {
		return this.fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

    @Column(name="fecha_viaje")
    @NotNull
	public Date getFechaViaje() {
		return this.fechaViaje;
	}

	public void setFechaViaje(Date fechaViaje) {
		this.fechaViaje = fechaViaje;
	}

    @Column(name="destino",nullable=false,length=50)
	public String getDestinoViaje() {
		return this.destinoViaje;
	}

	public void setDestinoViaje(String destinoViaje) {
		this.destinoViaje = destinoViaje;
	}

    @Column(name="motivo", nullable=false, length=100)
	public String getMotivoViaje() {
		return this.motivoViaje;
	}

	public void setMotivoViaje(String motivoViaje) {
		this.motivoViaje = motivoViaje;
	}
	
	/*
	 * Una reserva puede estar asociada unicamente a un detalle. En el atributo
	 * idDetalleReserva, en la anotacion "joincolumn" el parametro name, debe de ser el
	 * nombre de la columna referenciada en la tabla detalle_reserva
	 */
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_detalle")
    public DetalleReserva getIdDetalleReserva() {
        return this.idDetalleReserva;
    }

    public void setIdDetalleReserva(DetalleReserva idDetalleReserva) {
        this.idDetalleReserva = idDetalleReserva;
    }
}