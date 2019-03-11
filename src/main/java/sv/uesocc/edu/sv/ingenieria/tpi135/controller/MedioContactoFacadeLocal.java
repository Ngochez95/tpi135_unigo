/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.ejb.Local;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.MedioContacto;

/**
 *
 * @author gochez
 */
@Local
public interface MedioContactoFacadeLocal {

    void create(MedioContacto medioContacto);

    void edit(MedioContacto medioContacto);

    void remove(MedioContacto medioContacto);

    MedioContacto find(Object id);

    List<MedioContacto> findAll();

    List<MedioContacto> findRange(int[] range);

    int count();
    
}
