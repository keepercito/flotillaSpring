package com.example.keepercito.flotilla.flotilla.Repositorios;

import java.util.List;

import com.example.keepercito.flotilla.flotilla.Entity.Marca;
import com.example.keepercito.flotilla.flotilla.Entity.TipoVehiculo;
import com.example.keepercito.flotilla.flotilla.Entity.Vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vehiculoRepository")
public interface VehiculoRepository extends JpaRepository<Vehiculo,Integer>{
    public Vehiculo findByNombre(String n);
    public Vehiculo findByNumeroMotor(String n);
    public Vehiculo findByNumeroChasis(String n);
    public Vehiculo findByPlaca(String p);
    public List<Vehiculo> findAllByIdMarca(Marca m);
    public List<Vehiculo> findAllByIdTipoVehiculo(TipoVehiculo tv);
}