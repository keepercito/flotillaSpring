package com.example.keepercito.flotilla.flotilla.Services;

import java.util.List;
import java.util.Optional;

import com.example.keepercito.flotilla.flotilla.Entity.Reserva;
import com.example.keepercito.flotilla.flotilla.Entity.Unidad;
import com.example.keepercito.flotilla.flotilla.Entity.Vehiculo;
import com.example.keepercito.flotilla.flotilla.Repositorios.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ReservaService{

    @Autowired
    ReservaRepository reservaRepository;

    public List<Reserva> getAllReservas(){
        return reservaRepository.findAll();
    }
    
    public List<Reserva> getAllReservasByUnidad(Unidad u){
        return reservaRepository.findAllByIdUnidad(u);
    }
    
    public List<Reserva> getAllReservasByVehiculo(Vehiculo v){
        return reservaRepository.findAllByIdVehiculo(v);
    }
    
    public List<Reserva> getAllReservasByDestino(String d){
        return reservaRepository.findAllByDestinoViaje(d);
    }
    
    public List<Reserva> getAllReservasByMotivo(String m){
        return reservaRepository.findAllByMotivoViaje(m);
    }

    public Reserva getReserva(int id){
        Optional<Reserva> r = reservaRepository.findById(id);
        return r.get();
    }

    public void saveReserva(Reserva r){
        reservaRepository.save(r);
    }
    
    public void deleteReserva(Reserva r){
        reservaRepository.delete(r);
    }
}