/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.web.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author danm
 */
@Provider
public class ControllerExceptionMapper implements ExceptionMapper<ControllerException>{

    @Override
    public Response toResponse(ControllerException exception) {
        //Logger.getLogger(getClass().getName()).log(Level.SEVERE, exception.getMessage(), exception);
        return Response.status(Response.Status.OK).header("controller-exception", exception.getMessage()).build();
    }
    
}
