import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common'
import {Empleado} from "../empleado";
import {EmpleadoService} from "../empleado.service";

@Component({
  selector: 'app-lista-empleados',
  imports: [CommonModule],
  templateUrl: './lista-empleados.component.html',
  standalone: true,
  styleUrl: './lista-empleados.component.css'
})
export class ListaEmpleadosComponent implements OnInit{

  empleados:Empleado[];

  constructor(private empleadoServicio:EmpleadoService){}

  ngOnInit(): void {
    this.obtenerEmpleados();
  }

  private obtenerEmpleados(){
    this.empleadoServicio.obtenerListaDeEmpleados().subscribe(dato =>{
      this.empleados = dato;
    });
  }

}
