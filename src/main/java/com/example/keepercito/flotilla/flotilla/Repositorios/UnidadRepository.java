package com.example.keepercito.flotilla.flotilla.Repositorios;

import java.util.List;

import com.example.keepercito.flotilla.flotilla.Entity.Unidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("unidadRepository")
public interface UnidadRepository extends JpaRepository<Unidad,Integer>{
    Unidad findByNombreUnidad(String nombre);
    List<Unidad> findAllByOrderByIdAsc();
}