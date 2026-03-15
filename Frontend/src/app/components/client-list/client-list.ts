import { Component, OnInit } from '@angular/core';
import { Client } from '../../models/client';
import { Car } from '../../models/car';
import { CarService } from '../../services/car';
import { ClientService } from '../../services/client';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-client-list',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './client-list.html',
  styleUrl: './client-list.css',
})
export class ClientList implements OnInit{

  clients: Client[] = [];
  selectedClient: Client | null = null;
  clientCars: Car[] = [];
  showCarsModal = false;

  constructor(
    private clientService: ClientService,
    private carService: CarService
  ){}


  ngOnInit(): void {
    this.loadClients();
  }

  loadClients(): void{
    this.clientService.getClients().subscribe(data=>{
      this.clients = data;
    })
  }

  deleteClient(id: number): void {
    if (confirm('Are you sure you want to delete this client?')) {
      this.clientService.deleteClient(id).subscribe(() => {
        this.loadClients();
      });
    }
  }

  viewClientCars(client: Client): void {
    this.selectedClient = client;
    this.carService.getCarsByClient(client.id!).subscribe(data => {
      this.clientCars = data;
      this.showCarsModal = true;
    });
  }

  closeModal(): void {
    this.showCarsModal = false;
    this.selectedClient = null;
    this.clientCars = [];
  }

}
