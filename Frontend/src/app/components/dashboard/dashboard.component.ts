import { Component, OnInit } from '@angular/core';
import { Client } from '../../models/client';
import { Car } from '../../models/car';
import { ClientService } from '../../services/client';
import { CarService } from '../../services/car';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-dashboard.component',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css',
})
export class DashboardComponent implements OnInit {

  clients: Client[] = [];
  cars: Car[] = [];
  totalClients = 0;
  totalCars = 0;
  recentClients: Client[] = [];
  recentCars: Car[] = [];

  constructor(
    private clientService: ClientService,
    private carService: CarService
  ) { }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(): void {
    this.clientService.getClients().subscribe(data => {
      this.clients = data;
      this.totalClients = data.length;
      this.recentClients = data.slice(-3);
    });

    this.carService.getCars().subscribe(data => {
      this.cars = data;
      this.totalCars = data.length;
      this.recentCars = data.slice(-3);
    });


  }

}
