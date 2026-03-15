import { Component, OnInit } from '@angular/core';
import { Car } from '../../models/car';
import { CarService } from '../../services/car';
import { ClientService } from '../../services/client';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-car-list',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './car-list.html',
  styleUrl: './car-list.css',
})
export class CarList implements OnInit {
  cars: Car[] = [];
  clients: Map<number, string> = new Map();

  constructor(
    private carService: CarService,
    private clientService: ClientService
  ) { }

  ngOnInit(): void {
    this.loadClients();
  }

  loadClients(): void {
    this.clientService.getClients().subscribe(clients => {
      clients.forEach(client => {
        this.clients.set(client.id!, client.name);
      });
      this.loadCars();
    });
  }

  loadCars(): void {
    this.carService.getCars().subscribe(data => {
      this.cars = data.map(car => ({
        ...car,
        clientName: this.clients.get(car.clientId)
      }));
    });
  }

  deleteCar(id: number): void {
    if (confirm('Are you sure you want to delete this car?')) {
      this.carService.deleteCar(id).subscribe(() => {
        this.loadCars();
      });
    }
  }
}