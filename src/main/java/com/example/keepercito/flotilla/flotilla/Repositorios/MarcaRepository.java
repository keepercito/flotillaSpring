package com.example.keepercito.flotilla.flotilla.Repositorios;

import java.util.List;

import com.example.keepercito.flotilla.flotilla.Entity.Marca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("marcaRepository")
public interface MarcaRepository extends JpaRepository<Marca,Integer>{
    Marca findByMarca(String marca);
    List<Marca> findAllByOrderByIdAsc();
}