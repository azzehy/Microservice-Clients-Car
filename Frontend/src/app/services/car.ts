import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from '../models/car';

@Injectable({
  providedIn: 'root',
})
export class CarService {

  private apiUrl = 'http://localhost:8889/api/cars';

  constructor(private http: HttpClient) { }

  getCars(): Observable<Car[]> {
    return this.http.get<Car[]>(this.apiUrl);
  }

  getCarsByClient(clientId: number): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.apiUrl}/client/${clientId}`);
  }
  
  getCar(id: number): Observable<Car> {
    return this.http.get<Car>(`${this.apiUrl}/${id}`);
  }

  createCar(Car: Car): Observable<Car> {
    return this.http.post<Car>(this.apiUrl, Car);
  }

  updateCar(id: number, Car: Car): Observable<Car> {
    return this.http.put<Car>(`${this.apiUrl}/${id}`, Car);
  }

  deleteCar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

}
