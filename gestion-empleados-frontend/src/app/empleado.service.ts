import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Empleado} from "./empleado"

@Injectable({
  providedIn: 'root'
})

export class EmpleadoService {

  private baseURL = "http://localhost:8080/api/v1/empleados"; //Path al endpoint de los empleados

  constructor(private httpClient : HttpClient) {
  }

  obtenerListaDeEmpleados():Observable<Empleado[]>{
    return this.httpClient.get<Empleado[]>(`${this.baseURL}`);
  }

}

