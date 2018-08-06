package com.example.keepercito.flotilla.flotilla.Repositorios;

import java.util.List;

import com.example.keepercito.flotilla.flotilla.Entity.TipoVehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tipoVehiculoRepository")
public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculo, Integer>{
    TipoVehiculo findBytipoVehiculo(String tipo);
    List<TipoVehiculo> findAllByOrderByIdAsc();    
}