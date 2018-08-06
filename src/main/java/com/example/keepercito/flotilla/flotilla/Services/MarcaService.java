package com.example.keepercito.flotilla.flotilla.Services;

import java.util.List;
import java.util.Optional;

import com.example.keepercito.flotilla.flotilla.Entity.Marca;
import com.example.keepercito.flotilla.flotilla.Repositorios.MarcaRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class MarcaService{

    @Autowired
    MarcaRepository marcaRepository;

    public List<Marca> getAllMarcas(){
        return marcaRepository.findAll();
    }

    public List<Marca> getAllMarcasAsc(){
        return marcaRepository.findAllByOrderByIdAsc();
    }

    public Marca getMarca(int id){
        Optional <Marca> m = marcaRepository.findById(id);
        return m.get();
    }

    public Marca getMarca(String marca){
        return marcaRepository.findByMarca(marca);
    }

    public void saveMarca(Marca m){
        marcaRepository.save(m);
    }

    public void deleteMarca(Marca m){
        marcaRepository.delete(m);
    }
}