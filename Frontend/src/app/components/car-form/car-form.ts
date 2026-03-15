import { Component, OnInit } from '@angular/core';
import { Car } from '../../models/car';
import { Client } from '../../models/client';
import { CarService } from '../../services/car';
import { ClientService } from '../../services/client';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-car-form',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './car-form.html',
  styleUrl: './car-form.css',
})
export class CarForm implements OnInit {
  car: Car = {
    type: '',
    plateNumber: '',
    model: '',
    clientId: 0
  };
  clients: Client[] = [];
  isEditMode = false;

  constructor(
    private carService: CarService,
    private clientService: ClientService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadClients();
    
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      this.carService.getCar(Number(id)).subscribe(data => {
        this.car = data;
      });
    }
  }

  loadClients(): void {
    this.clientService.getClients().subscribe(data => {
      this.clients = data;
    });
  }

  onSubmit(): void {
    if (this.isEditMode) {
      this.carService.updateCar(this.car.id!, this.car).subscribe(() => {
        this.router.navigate(['/cars']);
      });
    } else {
      this.carService.createCar(this.car).subscribe(() => {
        this.router.navigate(['/cars']);
      });
    }
  }
}