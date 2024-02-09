import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common'
import {Empleado} from "../empleado";
import {EmpleadoService} from "../empleado.service";
import {Router} from "@angular/router";
import Swal from "sweetalert2";

@Component({
  selector: 'app-lista-empleados',
  imports: [CommonModule],
  templateUrl: './lista-empleados.component.html',
  standalone: true,
  styleUrl: './lista-empleados.component.css'
})
export class ListaEmpleadosComponent implements OnInit{

  empleados:Empleado[];

  constructor(private empleadoServicio:EmpleadoService, private router:Router){}

  ngOnInit(): void {
    this.obtenerEmpleados();
  }

  private obtenerEmpleados(){
    this.empleadoServicio.obtenerListaDeEmpleados().subscribe(dato =>{
      console.log(dato);
      this.empleados = dato;
    });
  }

  public actualizarEmpleado(id:number){
    this.router.navigate(['actualizar-empleado',id]);
  }

  public eliminarEmpleado(id:number){
    Swal.fire({
      title: 'Estás seguro de que deseas eliminar al empleado?',
      icon: "question",
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Sí',
      denyButtonText: 'No',
    }).then((result) => {
      if (result.isConfirmed) {
        this.empleadoServicio.eliminarEmpleado(id).subscribe(dato =>{
          console.log(dato);
          this.obtenerEmpleados();
        });
        Swal.fire('Empleado eliminado!', '', 'success')
      } else if (result.isDenied) {
        Swal.fire('No se eliminó al empleado', '', 'info')
      }
    })
  }

}
