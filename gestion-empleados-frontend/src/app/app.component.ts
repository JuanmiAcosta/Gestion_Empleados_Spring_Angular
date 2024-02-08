import { Component } from '@angular/core';
import {RouterLink, RouterLinkActive, RouterOutlet} from '@angular/router';
import {ListaEmpleadosComponent} from "./lista-empleados/lista-empleados.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ListaEmpleadosComponent, RouterLink, RouterLinkActive],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'gestion-empleados-frontend';
}
