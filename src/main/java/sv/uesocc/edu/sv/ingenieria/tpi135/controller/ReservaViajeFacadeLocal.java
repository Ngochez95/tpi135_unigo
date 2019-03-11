/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.ejb.Local;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.ReservaViaje;

/**
 *
 * @author gochez
 */
@Local
public interface ReservaViajeFacadeLocal {

    void create(ReservaViaje reservaViaje);

    void edit(ReservaViaje reservaViaje);

    void remove(ReservaViaje reservaViaje);

    ReservaViaje find(Object id);

    List<ReservaViaje> findAll();

    List<ReservaViaje> findRange(int[] range);

    int count();
    
}
