import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: Array<any> = []

  cartStream: Subject<any> = new Subject();

  constructor(private http: HttpClient,private router:Router) {
    let apiUrl = "http://localhost:8383/api/v1/cart/nag"
    this.http.get(apiUrl)
      .subscribe((items: any) => {
        this.cart = items;
        this.cartStream.next(this.cart.length)
      })
  }
  addToCart(item) {
    let apiUrl = "http://localhost:8383/api/v1/cart/nag"
    this.http.post(apiUrl, item)
      .subscribe(response => {
        this.cart = this.cart.concat(item)
        this.cartStream.next(this.cart.length)
      })
  }

  placeNewOrder() {
    let apiUrl = "http://localhost:8484/api/v1/orders/nag"
    this.http.post(apiUrl, {})
      .subscribe((response) => {
        this.router.navigate(['orders'])
      })
  }

  loadCartItems() {
    return this.cart;
  }


  getCartStream() {
    return this.cartStream;
  }

}
