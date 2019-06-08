/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.elementos1903;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Servicios Especiales
 */
@RestController
@RequestMapping("/api")
public class ControladorCliente {
    
    @Autowired
    RepoCliente repo;
    //por cada operacion crud va un metodo http
    
    //buscar todos
    
    @GetMapping("/cliente")
    public List<Cliente>buscartodos(){
        
        return repo.findAll();
        
    }
    
    //metodo para guardar
    
    @PostMapping("/cliente")
    public Estatus guardar(@RequestBody String json)throws Exception{
        
        ObjectMapper maper=new ObjectMapper();
        
        Cliente c= maper.readValue(json,Cliente.class);
        repo.save(c);
        Estatus e =new Estatus();
        e.setMensaje("Cliente guardado prrrooo");
        e.setSuccess(true);
        return e;
        
    }
    
    
}
