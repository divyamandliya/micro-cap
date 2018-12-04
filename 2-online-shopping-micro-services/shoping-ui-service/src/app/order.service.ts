import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  loadOrders() {
    let apiUrl = "http://localhost:8484/api/v1/orders/nag"
    return this.http.get(apiUrl);
  }
}
