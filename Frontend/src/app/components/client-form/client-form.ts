import { Component, OnInit } from '@angular/core';
import { Client } from '../../models/client';
import { ClientService } from '../../services/client';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-client-form',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './client-form.html',
  styleUrl: './client-form.css',
})
export class ClientForm implements OnInit {
  client: Client = {
    name: '',
    age: 0
  };
  isEditMode = false;

  constructor(
    private clientService: ClientService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      this.clientService.getClient(Number(id)).subscribe(data => {
        this.client = data;
      });
    }
  }

  onSubmit(): void {
    if (this.isEditMode) {
      this.clientService.updateClient(this.client.id!, this.client).subscribe(() => {
        this.router.navigate(['/clients']);
      });
    } else {
      this.clientService.createClient(this.client).subscribe(() => {
        this.router.navigate(['/clients']);
      });
    }
  }
}
