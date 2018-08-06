package com.example.keepercito.flotilla.flotilla.Services;

import java.util.List;
import java.util.Optional;

import com.example.keepercito.flotilla.flotilla.Entity.Unidad;
import com.example.keepercito.flotilla.flotilla.Repositorios.UnidadRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class UnidadService{

    @Autowired
    UnidadRepository unidadRepository;

    public List<Unidad> getAllUnidad(){
        return unidadRepository.findAll();
    }

    public List<Unidad> getAllUnidadAsc(){
        return unidadRepository.findAllByOrderByIdAsc();
    } 

    public Unidad getUnidad(int id){
        Optional<Unidad> u = unidadRepository.findById(id);
        return u.get();
    }

    public Unidad getUnidad(String nombre){
        return unidadRepository.findByNombreUnidad(nombre);
    }

    public void saveUnidad(Unidad u){
        unidadRepository.save(u);
    }

    public void deleteUnidad(Unidad u){
        unidadRepository.delete(u);
    }
}