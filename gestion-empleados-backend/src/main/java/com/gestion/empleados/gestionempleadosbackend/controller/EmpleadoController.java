package com.gestion.empleados.gestionempleadosbackend.controller;

import com.gestion.empleados.gestionempleadosbackend.persistence.entity.Empleado;
import com.gestion.empleados.gestionempleadosbackend.persistence.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmpleadoController { //Para acceder a la docu swagger -> localhost:8080/swagger-ui.html

    @Autowired
    private EmpleadoRepository repository;

    @CrossOrigin(origins = "http://localhost:4200") //Para el intercambio entre front y back por parte de HttpClient | El origen es el path del front
    @GetMapping("/empleados")
    public List<Empleado> listarTodosLosEmpleados(){
        return this.repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200") //Para el intercambio entre front y back por parte de HttpClient | El origen es el path del front
    @PostMapping("/empleados")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado){
        return this.repository.save(empleado);
    }
}
