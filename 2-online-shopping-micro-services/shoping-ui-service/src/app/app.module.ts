import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CartBadgeComponent } from './cart-badge/cart-badge.component';
import { ViewCartComponent } from './view-cart/view-cart.component';
import { ProductListComponent } from './product-list/product-list.component';
import { HomeComponent } from './home/home.component';
import { ViewOrderComponent } from './view-order/view-order.component';

let routes = [
  { path: '', component: HomeComponent },
  { path: 'products', component: ProductListComponent },
  { path: 'cart', component: ViewCartComponent },
  { path: 'orders', component: ViewOrderComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    CartBadgeComponent,
    ViewCartComponent,
    ProductListComponent,
    HomeComponent,
    ViewOrderComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
