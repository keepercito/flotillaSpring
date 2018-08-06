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

@Entity
@Table(name="tipo_vehiculo")
public class TipoVehiculo{
    private int id;
    private String tipoVehiculo;
    private Set<Vehiculo> vehiculos;

	public TipoVehiculo(int id, String tipoVehiculo, Set<Vehiculo> vehiculos) {
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.vehiculos = vehiculos;
	}


    public TipoVehiculo() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_tipo_vehiculo")
	public int getId(){
        return this.id;
	}
    
	public void setId(int id){
        this.id= id;
	}
    
    @NotNull
    @Column(name="tipo_vehiculo")
    public String getTipoVehiculo(){
        return this.tipoVehiculo;
    }
    
    public void setTipoVehiculo(String TipoVehiculo){
        this.tipoVehiculo = TipoVehiculo;
    }
    
    /*
     * un tipo vehiculo estara en muchos vehiculos. El atributo Set
     * "vehiculos", en su anotacion "onetomany" en el parametro "mappedby" 
     * debe coincider con el nombre del atributo del tipo "TipoVehiculo" en la clase
     * Vehiculo
     */
    @OneToMany(mappedBy="idTipoVehiculo", cascade=CascadeType.ALL)
    public Set<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }
        
    public void setVehiculos(Set<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}