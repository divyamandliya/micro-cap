import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  loadAllProducts() {
    let apiUrl = "http://localhost:8282/api/v1/products";
    return this.http.get(apiUrl)
  }
}
