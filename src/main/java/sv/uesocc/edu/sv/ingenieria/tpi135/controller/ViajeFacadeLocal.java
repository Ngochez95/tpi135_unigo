/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.ejb.Local;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Viaje;

/**
 *
 * @author gochez
 */
@Local
public interface ViajeFacadeLocal {

    void create(Viaje viaje);

    void edit(Viaje viaje);

    void remove(Viaje viaje);

    Viaje find(Object id);

    List<Viaje> findAll();
    
    List<Viaje> findByConductor(int idUsuario);

    List<Viaje> findRange(int[] range);

    int count();
    
}
