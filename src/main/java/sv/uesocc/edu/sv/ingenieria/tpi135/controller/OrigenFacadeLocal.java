/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.ejb.Local;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Origen;

/**
 *
 * @author gochez
 */
@Local
public interface OrigenFacadeLocal {

    void create(Origen origen);

    void edit(Origen origen);

    void remove(Origen origen);

    Origen find(Object id);

    List<Origen> findAll();

    List<Origen> findRange(int[] range);

    int count();
    
}
