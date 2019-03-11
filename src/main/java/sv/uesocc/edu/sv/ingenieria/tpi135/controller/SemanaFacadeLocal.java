/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.ejb.Local;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Semana;

/**
 *
 * @author gochez
 */
@Local
public interface SemanaFacadeLocal {

    void create(Semana semana);

    void edit(Semana semana);

    void remove(Semana semana);

    Semana find(Object id);

    List<Semana> findAll();

    List<Semana> findRange(int[] range);

    int count();
    
}
