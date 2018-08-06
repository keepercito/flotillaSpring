package com.example.keepercito.flotilla.flotilla.Repositorios;

import java.util.List;

import com.example.keepercito.flotilla.flotilla.Entity.TipoMantenimiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tipoMantenimientoRepository")
public interface TipoMantenimientoRepository extends JpaRepository<TipoMantenimiento,Integer>{
    //TipoMantenimiento findById(int id);
    TipoMantenimiento findBytipoMant(String tipo);
    List<TipoMantenimiento> findAllByOrderByIdAsc();
}