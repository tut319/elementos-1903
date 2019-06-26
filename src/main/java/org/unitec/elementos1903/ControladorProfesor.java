/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.elementos1903;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Servicios Especiales
 */
@RestController
@RequestMapping("/api")
public class ControladorProfesor {
    
    //metodo para guardar
    @Autowired 
    RepoProfesor repoProfe;
    
    //guardar
    @PostMapping("/profesor")
    public Estatus guardar(@RequestBody String json) throws Exception{
        //primero vamos a recibir json de cliente web y lo trasnformamos a un obj java
        //con la clase object mapper
        
        ObjectMapper maper=new ObjectMapper();
        
        //ahora si lo leemos
        Profesor profe=maper.readValue(json,Profesor.class);
        
        repoProfe.save(profe);
        //generamos el estatus
        Estatus e=new Estatus();
        e.setMensaje("Profe guardado con exito");
        e.setSuccess(true);
        
        return e;
        
    }
    //buscar todos
   @GetMapping("/profesor")
   public List<Profesor> buscartodos(){
       return repoProfe.findAll();
   }
   //borrar
   @DeleteMapping("/profesor/{id}")
   public Estatus borrar(@PathVariable Integer id){
       repoProfe.deleteById(id);
       Estatus e = new Estatus();
       e.setSuccess(true);
       e.setMensaje("Profesor borrando con exito");
       return e;
   }
   
   //Actualizar
   @PutMapping("/profesor")
   public Estatus actualizar(@RequestBody String json)throws  Exception{
         //primero vamos a recibir json de cliente web y lo trasnformamos a un obj java
        //con la clase object mapper
        
        ObjectMapper maper=new ObjectMapper();
        
        //ahora si lo leemos
        Profesor profe=maper.readValue(json,Profesor.class);
        repoProfe.save(profe);
        //generamos el estatus
        Estatus e=new Estatus();
        e.setMensaje("Profe guardado con exito");
        e.setSuccess(true);
        
        return e;
       
   }
   //hero
   //buscar por id
   @GetMapping("/profesor/{id}")
   public Profesor buscarPorId(@PathVariable Integer id){
       
       return  repoProfe.findById(id).get();
   }
    
}
