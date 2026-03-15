import { Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ClientList } from './components/client-list/client-list';
import { ClientForm } from './components/client-form/client-form';
import { CarList } from './components/car-list/car-list';
import { CarForm } from './components/car-form/car-form';

export const routes: Routes = [
    { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
    { path: 'dashboard', component: DashboardComponent },
    { path: 'clients', component: ClientList },
    { path: 'clients/new', component: ClientForm },
    { path: 'clients/edit/:id', component: ClientForm },
    { path: 'cars', component: CarList },
    { path: 'cars/new', component: CarForm },
    { path: 'cars/edit/:id', component: CarForm }
];
