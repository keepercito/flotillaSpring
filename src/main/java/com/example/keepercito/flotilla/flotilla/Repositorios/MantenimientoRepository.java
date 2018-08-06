package com.example.keepercito.flotilla.flotilla.Repositorios;

import java.util.List;

import com.example.keepercito.flotilla.flotilla.Entity.Mantenimiento;
import com.example.keepercito.flotilla.flotilla.Entity.TipoMantenimiento;
import com.example.keepercito.flotilla.flotilla.Entity.Vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("mantenimientoRepository")
public interface MantenimientoRepository extends JpaRepository<Mantenimiento,Integer>{
    List<Mantenimiento> findAllByIdVehiculo(Vehiculo vehiculo);
    List<Mantenimiento> findAllByIdTipoMantenimiento(TipoMantenimiento tipo);
    Mantenimiento findByIdVehiculo(Vehiculo vehiculo);
    Mantenimiento findByIdTipoMantenimiento(TipoMantenimiento tipo);
}