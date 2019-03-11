/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.ejb.Local;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Caractetistica;

/**
 *
 * @author gochez
 */
@Local
public interface CaractetisticaFacadeLocal {

    void create(Caractetistica caractetistica);

    void edit(Caractetistica caractetistica);

    void remove(Caractetistica caractetistica);

    Caractetistica find(Object id);

    List<Caractetistica> findAll();

    List<Caractetistica> findRange(int[] range);

    int count();
    
}
