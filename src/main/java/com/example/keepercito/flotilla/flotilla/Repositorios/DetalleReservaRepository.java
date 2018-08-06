package com.example.keepercito.flotilla.flotilla.Repositorios;

import com.example.keepercito.flotilla.flotilla.Entity.DetalleReserva;
import com.example.keepercito.flotilla.flotilla.Entity.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("detalleRepository")
public interface DetalleReservaRepository extends JpaRepository<DetalleReserva,Integer>{
    public DetalleReserva findByReserva(Reserva r);
}