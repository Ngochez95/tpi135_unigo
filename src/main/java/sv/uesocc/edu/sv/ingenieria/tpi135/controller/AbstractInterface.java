/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.controller;

import java.util.List;

/**
 *
 * @author gochez & Zepeda
 */
public interface AbstractInterface<T> {
    //POr es eso te da error al implementarlo tienen que conincidier los tipo de metodos
    public void create(T t);

    public T crear(T t);

    public void edit(T t);

    public T editar(T t);

    public boolean remove(T t);
    
    public T find(Object o);

    public List<T> findAll();

    public List<T> findRange(int[] range);

    public int count();

    public List findRange(int first, int pageSize);
    
}
