package com.example.keepercito.flotilla.flotilla.Services;

import java.util.List;
import java.util.Optional;

import com.example.keepercito.flotilla.flotilla.Entity.TipoMantenimiento;
import com.example.keepercito.flotilla.flotilla.Repositorios.TipoMantenimientoRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class TipoMantenimientoService{

    @Autowired
    TipoMantenimientoRepository tipoMantenimientoRepository;

    public List<TipoMantenimiento> getAllTipoMantenimiento(){
        return tipoMantenimientoRepository.findAll();
    }

    public List<TipoMantenimiento> getAllTipoMantenimientoAsc(){
        return tipoMantenimientoRepository.findAllByOrderByIdAsc();
    }

    public TipoMantenimiento getTipoMantenimiento(int id){
        Optional<TipoMantenimiento> tm = tipoMantenimientoRepository.findById(id);
        return tm.get();
    }

    public TipoMantenimiento getTipoMantenimiento(String tipo){
        return tipoMantenimientoRepository.findBytipoMant(tipo);
    }

    public void saveTipoMantenimiento(TipoMantenimiento tipo){
        tipoMantenimientoRepository.save(tipo);
    }

    public void deleteTipoMantenimiento(TipoMantenimiento tipo){
        tipoMantenimientoRepository.delete(tipo);
    }
}