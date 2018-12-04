import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Array<any> = []

  constructor(private productService: ProductService, private cartService: CartService) { }

  ngOnInit() {
    this.productService.loadAllProducts()
      .subscribe((products: any) => {
        this.products = products;
      })
  }

  addToCart(item) {
    this.cartService.addToCart(item)
  }

}
