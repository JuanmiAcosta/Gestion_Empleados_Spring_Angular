import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'
import {Empleado} from "../empleado";
import {FormsModule} from "@angular/forms";
import {EmpleadoService} from "../empleado.service";
import {Router} from "@angular/router";
import Swal from "sweetalert2";

@Component({
  selector: 'app-registrar-empleado',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './registrar-empleado.component.html',
  styleUrl: './registrar-empleado.component.css'
})
export class RegistrarEmpleadoComponent implements OnInit{

  empleado:Empleado = new Empleado();
  constructor(private empleadoServicio:EmpleadoService, private router:Router){}

  ngOnInit(): void {
    console.log(this.empleado);
  }

  guardarEmpleado(){
    this.empleadoServicio.registrarEmpleado(this.empleado).subscribe(dato => {
      console.log(dato);
      this.irAListaDeEmpleados();
    }, error => console.log(error));
  }

  irAListaDeEmpleados(){
    this.router.navigate(['/empleados']);
    Swal.fire('Empleado registrado',`El empleado ${this.empleado.nombre} ha sido registrado con éxito`,`success`);
  }

  onSubmit() {
    this.guardarEmpleado()
  }
}
