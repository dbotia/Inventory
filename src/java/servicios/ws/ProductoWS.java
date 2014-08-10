/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.dao.ProductoDAO;
import model.pojo.Producto;

/**
 *
 * @author User
 */
@WebService(serviceName = "ProductoWS")
public class ProductoWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "IngresarProducto")
    public String IngresarProducto(@WebParam(name = "codigo") String codigo, @WebParam(name = "nombre") String nombre, @WebParam(name = "precio") int precio, @WebParam(name = "stock") int stock, @WebParam(name = "descripcion") String descripcion) {
        Producto p= new Producto(codigo,nombre,precio,stock,descripcion);
        ProductoDAO productoDAO= new ProductoDAO();
        productoDAO.ingresarProducto(p);
        return "Producto Insertado";
       
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "BuscarProducto")
    public String BuscarProducto(@WebParam(name = "codigo") String codigo) {
        ProductoDAO productoDAO = new ProductoDAO();
        return productoDAO.consultarProducto(codigo);
    }

   
}
