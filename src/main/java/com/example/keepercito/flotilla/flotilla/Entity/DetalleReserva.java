package com.example.keepercito.flotilla.flotilla.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalle_reserva")
public class DetalleReserva{

    private int idDetalle;
    private Date salidaReserva;
    private Date regresoReserva;
    private String kilometrajeSalida;
    private String kilometrajeEntrada;
    private Reserva reserva;

	public DetalleReserva(int idDetalle, Date salidaReserva, Date regresoReserva, String kilometrajeSalida, String kilometrajeEntrada, Reserva reserva) {
		this.idDetalle = idDetalle;
		this.salidaReserva = salidaReserva;
		this.regresoReserva = regresoReserva;
		this.kilometrajeSalida = kilometrajeSalida;
		this.kilometrajeEntrada = kilometrajeEntrada;
		this.reserva = reserva;
	}

    public DetalleReserva() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_detalle")
	public int getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

    @Column(name="salida_reserva", nullable=false)
	public Date getSalidaReserva() {
		return this.salidaReserva;
	}

	public void setSalidaReserva(Date salidaReserva) {
		this.salidaReserva = salidaReserva;
	}

    @Column(name="regres_reserva", nullable=false)
	public Date getRegresoReserva() {
		return this.regresoReserva;
	}

	public void setRegresoReserva(Date regresoReserva) {
		this.regresoReserva = regresoReserva;
	}

    @Column(name="kilometraje_salida", nullable=false)
	public String getKilometrajeSalida() {
		return this.kilometrajeSalida;
	}

	public void setKilometrajeSalida(String kilometrajeSalida) {
		this.kilometrajeSalida = kilometrajeSalida;
	}

    @Column(name="kilometraje_entrada", nullable=false)
	public String getKilometrajeEntrada() {
		return this.kilometrajeEntrada;
	}

	public void setKilometrajeEntrada(String kilometrajeEntrada) {
		this.kilometrajeEntrada = kilometrajeEntrada;
	}

	/*
	 * un detalle reserva podra estar asociado a una reserva. El atributo
	 * reserva, en su anotacion "onetone" en el parametro "mappedby" debe
	 * coinsider con el nombre del atributo del tipo "DetalleReserva" en la clase reserva
	 */
    @OneToOne(mappedBy="idDetalleReserva")
	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}