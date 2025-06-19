package com.codefactory.fleetguard360.mapper;

import com.codefactory.fleetguard360.controller.DTO.ConductorDTO;
import com.codefactory.fleetguard360.controller.DTO.RutaDTO;
import com.codefactory.fleetguard360.controller.DTO.TurnoResponseDTO;
import com.codefactory.fleetguard360.controller.DTO.UsuarioDTO;
import com.codefactory.fleetguard360.repository.entities.Conductor;
import com.codefactory.fleetguard360.repository.entities.Ruta;
import com.codefactory.fleetguard360.repository.entities.Turno;
import com.codefactory.fleetguard360.repository.entities.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-18T20:57:57-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class TurnoMapperImpl implements TurnoMapper {

    @Override
    public TurnoResponseDTO turnoToTurnoResponseDTO(Turno turno) {
        if ( turno == null ) {
            return null;
        }

        TurnoResponseDTO turnoResponseDTO = new TurnoResponseDTO();

        turnoResponseDTO.setConductor( conductorToConductorDTO( turno.getConductorId() ) );
        turnoResponseDTO.setRuta( rutaToRutaDTO( turno.getRuta() ) );
        turnoResponseDTO.setId( turno.getId() );
        turnoResponseDTO.setInicio( turno.getInicio() );
        turnoResponseDTO.setFin( turno.getFin() );
        turnoResponseDTO.setEstado( turno.getEstado() );

        return turnoResponseDTO;
    }

    @Override
    public ConductorDTO conductorToConductorDTO(Conductor conductor) {
        if ( conductor == null ) {
            return null;
        }

        ConductorDTO conductorDTO = new ConductorDTO();

        conductorDTO.setId( conductor.getId() );
        conductorDTO.setNombre( conductor.getNombre() );
        conductorDTO.setDocumentoIdentidad( conductor.getDocumentoIdentidad() );
        conductorDTO.setTelefono( conductor.getTelefono() );

        return conductorDTO;
    }

    @Override
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setEmail( usuario.getEmail() );
        usuarioDTO.setRol( usuario.getRol() );
        try {
            if ( usuario.getBloqueoHasta() != null ) {
                usuarioDTO.setBloqueoHasta( new SimpleDateFormat().parse( usuario.getBloqueoHasta() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        usuarioDTO.setIntentosFallidos( usuario.getIntentosFallidos() );

        return usuarioDTO;
    }

    @Override
    public RutaDTO rutaToRutaDTO(Ruta ruta) {
        if ( ruta == null ) {
            return null;
        }

        RutaDTO rutaDTO = new RutaDTO();

        rutaDTO.setId( ruta.getId() );
        rutaDTO.setNombre( ruta.getNombre() );
        rutaDTO.setOrigen( ruta.getOrigen() );
        rutaDTO.setDestino( ruta.getDestino() );

        return rutaDTO;
    }
}
