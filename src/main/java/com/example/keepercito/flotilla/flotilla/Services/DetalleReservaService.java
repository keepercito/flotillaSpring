package com.example.keepercito.flotilla.flotilla.Services;

import java.util.List;
import java.util.Optional;

import com.example.keepercito.flotilla.flotilla.Entity.DetalleReserva;
import com.example.keepercito.flotilla.flotilla.Entity.Reserva;
import com.example.keepercito.flotilla.flotilla.Repositorios.DetalleReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class DetalleReservaService{

    @Autowired
    DetalleReservaRepository detalleReservaRepository;

    public List<DetalleReserva> getAllDetalleReserva(){
        return detalleReservaRepository.findAll();
    }

    public DetalleReserva getDetalleReserva(Reserva r){
        return detalleReservaRepository.findByReserva(r);
    }

    public DetalleReserva getDetalleReserva(int id){
        Optional<DetalleReserva> dr = detalleReservaRepository.findById(id);
        return dr.get();
    }

    public void saveDetalleReserva(DetalleReserva dr){
        detalleReservaRepository.save(dr);
    }

    public void deleteDetalleReserva(DetalleReserva dr){
        detalleReservaRepository.delete(dr);
    }
}