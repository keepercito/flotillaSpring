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
@Table(name="tipo_mantenimiento")
public class TipoMantenimiento{
    private int id;
	private String tipoMant;
	private Set<Mantenimiento> mantenimientos;

	public TipoMantenimiento(int id, String tipoMant, Set<Mantenimiento> mantenimientos) {
		this.id = id;
		this.tipoMant = tipoMant;
		this.mantenimientos = mantenimientos;
	}

	public TipoMantenimiento() {
	}


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_tipo_mant")
	public int getId(){
		return this.id;
	}

	public void setId(int id){
		this.id= id;
    }
    
    @NotNull
	@Column(name="tipo_mantenimiento")
	public String getTipoMant(){
		return this.tipoMant;
	}

	public void setTipoMant(String tipo_mant){
		this.tipoMant = tipo_mant;
    }

	/*
	 * un tipo mantenimiento estara en muchos mantenimientos. El atributo Set
	 * "mantenimientos", en su anotacion "onetomany" en el parametro "mappedby" debe
	 * coincider con el nombre del atributo del tipo "TipoMantenimiento" en la clase Mantenimiento
	 */
	@OneToMany(mappedBy="idTipoMantenimiento", cascade=CascadeType.ALL)
	public Set<Mantenimiento> getMantenimientos() {
		return this.mantenimientos;
	}

	public void setMantenimientos(Set<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}
}