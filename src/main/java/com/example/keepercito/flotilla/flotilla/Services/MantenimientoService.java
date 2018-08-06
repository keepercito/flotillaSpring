package com.example.keepercito.flotilla.flotilla.Services;

import java.util.List;
import java.util.Optional;

import com.example.keepercito.flotilla.flotilla.Entity.Mantenimiento;
import com.example.keepercito.flotilla.flotilla.Entity.TipoMantenimiento;
import com.example.keepercito.flotilla.flotilla.Entity.Vehiculo;
import com.example.keepercito.flotilla.flotilla.Repositorios.MantenimientoRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class MantenimientoService{

    @Autowired
    MantenimientoRepository mantenimientoRepository;

    public List<Mantenimiento> getAllMantenimiento(){
        return mantenimientoRepository.findAll();
    }

    public List<Mantenimiento> getAllByTipo(TipoMantenimiento tipo){
        return mantenimientoRepository.findAllByIdTipoMantenimiento(tipo);
    }

    public List<Mantenimiento> getAllByVehiculo(Vehiculo vehiculo){
        return mantenimientoRepository.findAllByIdVehiculo(vehiculo);
    }

    public Mantenimiento getMantenimiento(int id){
        Optional<Mantenimiento> m = mantenimientoRepository.findById(id);
        return m.get();
    }

    public void saveMantenimiento(Mantenimiento m){
        mantenimientoRepository.save(m);
    }
    
    public void deleteMantenimiento(Mantenimiento m){
        mantenimientoRepository.delete(m);
    }
}