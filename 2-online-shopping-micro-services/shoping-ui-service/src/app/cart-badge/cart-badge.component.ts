import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart-badge',
  templateUrl: './cart-badge.component.html',
  styleUrls: ['./cart-badge.component.css']
})
export class CartBadgeComponent implements OnInit {

  constructor(private cartService: CartService) { }
  count = 0;

  ngOnInit() {
    this.cartService.getCartStream()
      .subscribe(count => this.count = count)
  }

}
