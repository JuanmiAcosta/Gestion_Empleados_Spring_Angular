package com.gestion.empleados.gestionempleadosbackend.controller;

import com.gestion.empleados.gestionempleadosbackend.exceptions.ResourceNotFoundException;
import com.gestion.empleados.gestionempleadosbackend.persistence.entity.Empleado;
import com.gestion.empleados.gestionempleadosbackend.persistence.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200") //Para el intercambio entre front y back por parte de HttpClient | El origen es el path del front
public class EmpleadoController { //Para acceder a la docu swagger -> localhost:8080/swagger-ui.html

    @Autowired
    private EmpleadoRepository repository;

    @GetMapping("/empleados")
    public List<Empleado> listarTodosLosEmpleados(){
        return this.repository.findAll();
    }

    @PostMapping("/empleados")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado){
        return this.repository.save(empleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id){
        Empleado empleado = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con el id " + id + "\n"));
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detallesEmpleado){
        Empleado empleado = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con el id " + id + "\n"));

        empleado.setNombre(detallesEmpleado.getNombre());
        empleado.setApellido(detallesEmpleado.getApellido());
        empleado.setEmail(detallesEmpleado.getEmail());

        Empleado empleadoActualizado = this.repository.save(empleado);

        return ResponseEntity.ok(empleadoActualizado);
    }
}
