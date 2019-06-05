package org.unitec.elementos1903;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Elementos1903Application implements CommandLineRunner {
    
    @Autowired
    RepoCliente repoCliente;

	public static void main(String[] args) {
		SpringApplication.run(Elementos1903Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        
          //repoCliente.save(new Cliente(1,"tut3","delj_19@hotmail.com"));
         // repoCliente.save(new Cliente(2,"Chavita","chavita@gmail.com"));
         
         //Buscar todos
         
         for(Cliente c: repoCliente.findAll()){
             System.out.println(c);
         }
         
         //Buscar por ID
         
         System.out.print(repoCliente.findById(2));
         
         //Borramos el primer despues lo vuelven a insertar
         
        // repoCliente.deleteById(1);
       
    }

}
