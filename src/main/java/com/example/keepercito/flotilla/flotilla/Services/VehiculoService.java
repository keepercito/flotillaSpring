package com.example.keepercito.flotilla.flotilla.Services;

import java.util.List;
import java.util.Optional;

import com.example.keepercito.flotilla.flotilla.Entity.Marca;
import com.example.keepercito.flotilla.flotilla.Entity.TipoVehiculo;
import com.example.keepercito.flotilla.flotilla.Entity.Vehiculo;
import com.example.keepercito.flotilla.flotilla.Repositorios.VehiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class VehiculoService{
    
    @Autowired
    VehiculoRepository vehiculoRepository;

    public List<Vehiculo> getAllVehiculos(){
        return vehiculoRepository.findAll();
    }

    public List<Vehiculo> getByMarca(Marca m){
        return vehiculoRepository.findAllByIdMarca(m);
    }

    public List<Vehiculo> getByTipo(TipoVehiculo tv){
        return vehiculoRepository.findAllByIdTipoVehiculo(tv);
    }

    public Vehiculo getVehiculo(int id){
        Optional<Vehiculo> v = vehiculoRepository.findById(id);
        return v.get();
    }

    public Vehiculo getVehiculoByMotor(String n){
        return vehiculoRepository.findByNumeroMotor(n);
    }
    
    public Vehiculo getVehiculoByChasis(String n){
        return vehiculoRepository.findByNumeroMotor(n);
    }
    
    public Vehiculo getVehiculoByNombre(String n){
        return vehiculoRepository.findByNumeroMotor(n);
    }
    
    public Vehiculo getVehiculoByPlaca(String p){
        return vehiculoRepository.findByNumeroMotor(p);
    }

    public void saveVehiculo(Vehiculo v){
        vehiculoRepository.save(v);
    }
    
    public void deleteVehiculo(Vehiculo v){
        vehiculoRepository.delete(v);
    }
}