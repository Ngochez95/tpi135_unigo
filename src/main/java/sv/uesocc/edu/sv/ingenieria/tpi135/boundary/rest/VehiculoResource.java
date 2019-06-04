/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.uesocc.edu.sv.ingenieria.tpi135.boundary.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.MarcaFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.ModeloFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.controller.VehiculoFacade;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Marca;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Modelo;
import sv.uesocc.edu.sv.ingenieria.tpi135.entity.Vehiculo;

/**
 *
 * @author gochez
 */
@Path("marca/{idmarca}/modelo/{idmodelo}/vehiculo")
@RequestScoped
public class VehiculoResource {

    @Inject
    protected VehiculoFacade vehiculo;
    @Inject
    protected MarcaFacade marca;
    @Inject
    protected ModeloFacade modelo;


    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Vehiculo> VehiculofindRange(@DefaultValue("0") @QueryParam("first") int first,
            @DefaultValue("10") @QueryParam("pagesize") int pageSize) {

        if (vehiculo != null && first >= 0 && pageSize >= 0) {
            try {
                List<Vehiculo> list = null;
                list = vehiculo.findRange(first, pageSize);
                if (list != null) {
                    return list;
                }

            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return new ArrayList<>();

    }

//    @GET
//    @Path("count")
//    @Produces(MediaType.TEXT_PLAIN)
//    public Integer Vehiculocount() {
//        if (vehiculo != null) {
//            try {
//                return vehiculo.count();
//            } catch (Exception ex) {
//                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//
//            }
//        }
//        return 0;
//    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Vehiculo VehiculofindById(
            @PathParam("id") Integer id,
            @PathParam("idmarca") Integer idmarca,
            @PathParam("idmodelo") Integer idmodelo
            
    ) throws InstantiationException, IllegalAccessException {
        if (vehiculo != null) {
            try {
                Vehiculo registro;
                List<Vehiculo> list = null;
                if (id >= 0 && id != null) {
                    registro = vehiculo.find(id);
                    return registro;
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return new Vehiculo();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Vehiculo Vehiculocreate(Vehiculo registro) throws InstantiationException, IllegalAccessException {
        if (vehiculo != null && registro != null) {
            try {
                Vehiculo creado = vehiculo.create(registro);
                if (creado != null) {
                    return creado;
                }

            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return new Vehiculo();
    }

//    @GET
//    @Path("findallid/{idbuscado}")
//    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
//    public Response FindAllByID(
//            @PathParam("idbuscado") int id
//    ) {
//
//        if (vehiculo != null) {
//            try {
//                List<Vehiculo> list = null;
//                list = vehiculo.findAllId(id);
//                if (list != null && !list.isEmpty()) {
//                    JsonArrayBuilder ab = Json.createArrayBuilder();
//                    for (Vehiculo vh : list) {
//                        ab.add(Json.createObjectBuilder()
//                                .add("idVehiculo", vh.getIdVehiculo())
//                                .add("Marca", vh.getIdMarca().getMarca())
//                        // .add("Modelo", vh.getIdMarca().getModeloList().get(id).getModelo())
//                        //                                .add("Capacidad", vh.getIdMarca().getModeloList().get(id).getCaractetisticaList().get(id).getTipoCaracteristicaList().get(id).getCapacidad())
//                        //                                .add("Color", vh.getIdMarca().getModeloList().get(id).getCaractetisticaList().get(id).getTipoCaracteristicaList().get(id).getColor())
//                        //                                .add("Anio", vh.getIdMarca().getModeloList().get(id).getCaractetisticaList().get(id).getTipoCaracteristicaList().get(id).getAnio().getDate())
//                        );
//                        //.add("marca", vh.getIdMarca().getMarca()));
//                    }
//                    return Response.ok(ab.build()).build();
//
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//            }
//        }
//        return Response.status(Response.Status.NOT_FOUND).header("filter-not-found", id).build();
//    }

//    @GET
//    @Path("/marca/all")
//    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
//    public List<Marca> MarcafindAll() {
//        if (marca != null) {
//            try {
//                List<Marca> list = null;
//                list = marca.findAll();
//                if (list != null) {
//                    return list;
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//            }
//        }
//        return new ArrayList<>();
//    }
//
//    @GET
//    @Path("/marca")
//    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
//    public List<Marca> MarcafindRange(@DefaultValue("0") @QueryParam("first") int first,
//            @DefaultValue("10") @QueryParam("pagesize") int pageSize) {
//
//        if (marca != null && first >= 0 && pageSize >= 0) {
//            try {
//                List<Marca> list = null;
//                list = marca.findRange(first, pageSize);
//                if (list != null) {
//                    return list;
//                }
//
//            } catch (Exception ex) {
//                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//
//            }
//        }
//        return new ArrayList<>();
//
//    }
//
////    @GET
////    @Path("/marca")
////    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
////    public List<Marca> MarcaByName(@DefaultValue("0") @QueryParam("first") int first,
////            @DefaultValue("10") @QueryParam("pagesize") int pageSize) {
////
////        if (marca != null && first >= 0 && pageSize >= 0) {
////            try {
////                List<Marca> list = null;
////                list = marca.findRange(first, pageSize);
////                if (list != null) {
////                    return list;
////                }
////
////            } catch (Exception ex) {
////                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
////
////            }
////        }
////        return new ArrayList<>();
////
////    }
//
//    @GET
//    @Path("/marca/count")
//    @Produces(MediaType.TEXT_PLAIN)
//    public Integer Marcacount() {
//        if (marca != null) {
//            try {
//                return marca.count();
//            } catch (Exception ex) {
//                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//
//            }
//        }
//        return 0;
//    }
//
//    @GET
//    @Path("/marca/findbyname/{marcaBuscada}")
//    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
//    public List<Marca> MarcafindById(
//            @PathParam("marcaBuscada") String marcabuscada
//    ) throws InstantiationException, IllegalAccessException {
//        if (marca != null) {
//            try {
//                List<Marca> registro;
//                if (!marcabuscada.isEmpty()) {
//                    registro = marca.findByNombreUsuario(marcabuscada);
//                    return registro;
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//
//            }
//        }
//        return new ArrayList<>();
//    }
//
//    @GET
//    @Path("/marca/modelo/all")
//    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
//    public List<Modelo> ModelofindAll() {
//        if (modelo != null) {
//            try {
//                List<Modelo> list = null;
//                list = modelo.findAll();
//                if (list != null) {
//                    return list;
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//            }
//        }
//        return new ArrayList<>();
//    }
//
//    @GET
//    @Path("/marca/modelo")
//    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
//    public List<Modelo> ModelofindRange(@DefaultValue("0") @QueryParam("first") int first,
//            @DefaultValue("10") @QueryParam("pagesize") int pageSize) {
//
//        if (modelo != null && first >= 0 && pageSize >= 0) {
//            try {
//                List<Modelo> list = null;
//                list = modelo.findRange(first, pageSize);
//                if (list != null) {
//                    return list;
//                }
//
//            } catch (Exception ex) {
//                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//
//            }
//        }
//        return new ArrayList<>();
//
//    }
//
//    @GET
//    @Path("/marca/modelo/count")
//    @Produces(MediaType.TEXT_PLAIN)
//    public Integer Modelocount() {
//        if (modelo != null) {
//            try {
//                return modelo.count();
//            } catch (Exception ex) {
//                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//
//            }
//        }
//        return 0;
//    }
//
//    @GET
//    @Path("/marca/modelo/{id}")
//    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
//    public Modelo ModelofindById(
//            @PathParam("id") Integer id
//    ) throws InstantiationException, IllegalAccessException {
//        if (modelo != null) {
//            try {
//                Modelo registro;
//                if (id >= 0 && id != null) {
//                    registro = modelo.find(id);
//                    return registro;
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
//
//            }
//        }
//        return new Modelo();
//    }
//
////    @POST
////    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
////    public Marca Marcacreate(Marca registro) throws InstantiationException, IllegalAccessException {
////        if (marca != null && registro != null) {
////            try {
////                Marca creado = marca.create(registro);
////                if (creado != null) {
////                    return creado;
////                }
////
////            } catch (Exception ex) {
////                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
////
////            }
////        }
////        return new Marca();
////    }
}
