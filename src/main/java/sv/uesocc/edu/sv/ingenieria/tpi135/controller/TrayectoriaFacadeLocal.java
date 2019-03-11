/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.ejb.Local;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Trayectoria;

/**
 *
 * @author gochez
 */
@Local
public interface TrayectoriaFacadeLocal {

    void create(Trayectoria trayectoria);

    void edit(Trayectoria trayectoria);

    void remove(Trayectoria trayectoria);

    Trayectoria find(Object id);

    List<Trayectoria> findAll();

    List<Trayectoria> findRange(int[] range);

    int count();
    
}
