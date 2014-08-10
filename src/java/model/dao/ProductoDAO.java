/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dao;

import model.pojo.Producto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author User
 */
public class ProductoDAO {
    
    public void ingresarProducto(Producto p){
    
       SessionFactory sf=null;
       Session sesion=null;
       Transaction tx=null;
       
       try{
       sf=HibernateUtil.getSessionFactory();
       sesion = sf.openSession();
       tx=sesion.beginTransaction();
       sesion.save(p);
       tx.commit();
       sesion.close();
       
       }catch(Exception e){
       tx.rollback();
       throw new RuntimeException("No se puede guardar el producto...");
       
       }
    }
       
       public String consultarProducto(String codigo){
       
       SessionFactory sf=HibernateUtil.getSessionFactory();
       Session sesion=sf.openSession();
       Producto p = (Producto) sesion.get(Producto.class, codigo);
       sesion.close();
       
       if(p!=null){
       
       return "El producto de codigo " + p.getCodigo() + " cuyo nombre es " + p.getNombre() + " cuesta $" + p.getPrecio()
               + " tienen en existencias "+ p.getStock() + " unidades y su descripcion es " + p.getDescripcion();
       
        }
       else return "El producto de codigo " + codigo + " No existe";
       
       }
       
       
    
    
    
    
    
}
