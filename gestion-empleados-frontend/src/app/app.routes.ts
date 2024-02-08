import { Routes } from '@angular/router';
import {ListaEmpleadosComponent} from "./lista-empleados/lista-empleados.component";
import {RegistrarEmpleadoComponent} from "./registrar-empleado/registrar-empleado.component";

export const routes: Routes = [
  {path : 'empleados',component:ListaEmpleadosComponent},
  {path: '', redirectTo:'empleados',pathMatch:'full'},
  {path: 'registrar-empleado', component:RegistrarEmpleadoComponent}
];
