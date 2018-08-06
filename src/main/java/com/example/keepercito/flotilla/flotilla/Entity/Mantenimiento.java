package com.example.keepercito.flotilla.flotilla.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="mantenimiento")
public class Mantenimiento{

    private int idMantenimiento;
    private TipoMantenimiento idTipoMantenimiento;
    private Date fechaMantenimiento;
    private Vehiculo idVehiculo;

	public Mantenimiento(int idMantenimiento, TipoMantenimiento idTipoMantenimiento, Date fechaMantenimiento, Vehiculo idVehiculo) {
		this.idMantenimiento = idMantenimiento;
		this.idTipoMantenimiento = idTipoMantenimiento;
		this.fechaMantenimiento = fechaMantenimiento;
		this.idVehiculo = idVehiculo;
	}


    public Mantenimiento(){
    }

    @Id
    @Column(name="id_mantenimiento")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getIdMantenimiento(){
        return this.idMantenimiento;
    }
    public void setIdMantenimiento(int idMantenimiento){
        this.idMantenimiento = idMantenimiento;
    }
    
    /* Un mantenimiento puede estar asociado a un tipo mantenimiento. En el atributo
     * idTipoMantenimiento, en la anotacion "joincolumn" el parametro name, debe de
     * ser el nombre de la columna referenciada en la tabla tipo_mantenimiento
     */
    @ManyToOne
    @JoinColumn(name="id_tipo_mant")
    public TipoMantenimiento getIdTipoMantenimiento(){
        return this.idTipoMantenimiento;
    }
    
    public void setIdTipoMantenimiento(TipoMantenimiento idTipoMantenimiento){
        this.idTipoMantenimiento = idTipoMantenimiento;
    }
    
    @Column(name="fecha_mantenimiento")
    @NotNull
    public Date getFechamantenimiento(){
        return this.fechaMantenimiento;
    }
    
    public void setFechamantenimiento(Date fechaMantenimiento){
        this.fechaMantenimiento = fechaMantenimiento;
    }
    
    /*
     * Un mantenimiento puede estar asociado a un vehiculo. En el atributo
     * idVehiculo, en la anotacion "joincolumn" el parametro name, debe de
     * ser el nombre de la columna referenciada en la tabla vehiculo
     */
    @ManyToOne
    @JoinColumn(name="id_vehiculo")
    public Vehiculo getIdVehiculo(){
        return this.idVehiculo;
    }        
    public void setIdVehiculo(Vehiculo idVehiculo){
        this.idVehiculo = idVehiculo;
    }
}