import { Component, OnInit } from '@angular/core';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-view-order',
  templateUrl: './view-order.component.html',
  styleUrls: ['./view-order.component.css']
})
export class ViewOrderComponent implements OnInit {

  orders = []
  constructor(private orderService: OrderService) { }

  ngOnInit() {
    this.orderService.loadOrders()
      .subscribe((orders:any) => {
        this.orders = orders
      })
  }

}
