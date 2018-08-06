package com.example.keepercito.flotilla.flotilla.Services;

import java.util.List;
import java.util.Optional;

import com.example.keepercito.flotilla.flotilla.Entity.TipoVehiculo;
import com.example.keepercito.flotilla.flotilla.Repositorios.TipoVehiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class TipoVehiculoService{

    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    public List<TipoVehiculo> getAllTipoVehiculo(){
        return tipoVehiculoRepository.findAll();
    }
    
    public List<TipoVehiculo> getAllTipoVehiculoAsc(){
        return tipoVehiculoRepository.findAllByOrderByIdAsc();
    }

    public TipoVehiculo getTipoVehiculo(int id){
        Optional<TipoVehiculo> tv = tipoVehiculoRepository.findById(id);
        return tv.get();
    }

    public TipoVehiculo getTipoVehiculo(String tipo){
        return tipoVehiculoRepository.findBytipoVehiculo(tipo);
    }

    public void saveTipoVehiculo(TipoVehiculo tv){
        tipoVehiculoRepository.save(tv);
    }

    public void deleteTipoVehiculo(TipoVehiculo tv){
        tipoVehiculoRepository.delete(tv);
    }
}