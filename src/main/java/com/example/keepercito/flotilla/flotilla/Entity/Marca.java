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
@Table(name="marca")
public class Marca{
    private int id;
    private String marca;
    private Set<Vehiculo> vehiculos;

	public Marca(int id, String marca, Set<Vehiculo> vehiculos) {
		this.id = id;
		this.marca = marca;
		this.vehiculos = vehiculos;
	}

    public Marca() {
    }
        
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_marca")
	public int getId(){
        return this.id;
	}
    
	public void setId(int id){
        this.id = id;
	}
    
    @Column(name="marca")
    @NotNull
    public String getMarca(){
        return this.marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }

    /*
     * una marca estara en muchos vehiculos. El atributo Set
     * "vehiculos", en su anotacion "onetomany" en el parametro "mappedby" 
     * debe coincider con el nombre del atributo del tipo "Marca" en la clase
     * Vehiculo
     */
    @OneToMany(mappedBy="idMarca", cascade=CascadeType.ALL)
    public Set<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public void setVehiculos(Set<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}