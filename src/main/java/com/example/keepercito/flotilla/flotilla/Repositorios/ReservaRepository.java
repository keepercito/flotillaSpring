package com.example.keepercito.flotilla.flotilla.Repositorios;

import java.util.List;

import com.example.keepercito.flotilla.flotilla.Entity.Reserva;
import com.example.keepercito.flotilla.flotilla.Entity.Unidad;
import com.example.keepercito.flotilla.flotilla.Entity.Vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("reservaRepository")
public interface ReservaRepository extends JpaRepository<Reserva,Integer>{
    List<Reserva> findAllByIdUnidad(Unidad u);
    List<Reserva> findAllByIdVehiculo(Vehiculo v);
    List<Reserva> findAllByMotivoViaje(String m);
    List<Reserva> findAllByDestinoViaje(String d);
}