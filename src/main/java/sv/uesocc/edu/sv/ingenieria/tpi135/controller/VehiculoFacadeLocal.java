/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Vehiculo;

/**
 *
 * @author gochez
 */
@Local
public interface VehiculoFacadeLocal extends AbstractInterface<Vehiculo>{

    List<Vehiculo> findActivo (int idReferencia);
    List<Vehiculo> findByCaracteristicas(Date anio, int capacidad);
    
}
