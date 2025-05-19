package com.codefactory.fleetguard360.service;

import com.codefactory.fleetguard360.controller.DTO.RutaDTO;
import com.codefactory.fleetguard360.repository.RutaRepository;
import com.codefactory.fleetguard360.repository.entities.Ruta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    public Ruta crearRuta(RutaDTO dto) {
        Ruta ruta = new Ruta();
        ruta.setNombre(dto.nombre);
        ruta.setOrigen(dto.origen);
        ruta.setDestino(dto.destino);
        return rutaRepository.save(ruta);
    }

    public Ruta actualizarRuta(int id, RutaDTO dto) {
        Ruta ruta = rutaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ruta no encontrada"));

        ruta.setNombre(dto.nombre);
        ruta.setOrigen(dto.origen);
        ruta.setDestino(dto.destino);
        return rutaRepository.save(ruta);
    }

    public void eliminarRuta(int id) {
        rutaRepository.deleteById(id);
    }

    public List<Ruta> listarRutas() {
        return rutaRepository.findAll();
    }

    public Ruta obtenerRutaPorId(int id) {
        return rutaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ruta no encontrada"));
    }
}
