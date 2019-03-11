/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;
import javax.ejb.Local;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.TipoMedioContacto;

/**
 *
 * @author gochez
 */
@Local
public interface TipoMedioContactoFacadeLocal {

    void create(TipoMedioContacto tipoMedioContacto);

    void edit(TipoMedioContacto tipoMedioContacto);

    void remove(TipoMedioContacto tipoMedioContacto);

    TipoMedioContacto find(Object id);

    List<TipoMedioContacto> findAll();

    List<TipoMedioContacto> findRange(int[] range);

    int count();
    
}
