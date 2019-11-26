import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {NgxSpinnerModule} from 'ngx-spinner';

import {BsDropdownModule} from 'ngx-bootstrap/dropdown';
import {TooltipModule} from 'ngx-bootstrap/tooltip';
import {ModalModule} from 'ngx-bootstrap/modal';
import {CollapseModule} from 'ngx-bootstrap/collapse';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker';
import {CarouselModule} from 'ngx-bootstrap/carousel';
import {TabsModule} from 'ngx-bootstrap/tabs';

import {AppComponent} from './app.component';
import {UserComponent} from './user/user.component';
import {NavbarComponent} from './navbar/navbar.component';
import {ProductsComponent} from './products/products.component';
import {RouterModule, Routes} from '@angular/router';
import {WalletTableComponent} from './walletTable/walletTable.component';
import {WalletsComponent} from './wallets/wallets.component';
import {AuthService} from './service/auth/auth.service';
import {TokenStorage} from './service/auth/token.storage';
import {Interceptor} from './app.interceptor';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {HttpModule} from '@angular/http';
import {ProductComponent} from './product/product.component';
import {MySubscriptionsComponent} from './my-subscriptions/my-subscriptions.component';
import {ButtonsModule} from 'ngx-bootstrap';

import {NgBootstrapFormValidationModule} from 'ng-bootstrap-form-validation';
import {AlertModule} from 'ngx-bootstrap/alert';
import {ManagerProductsComponent} from './manager-products/manager-products.component';
import {SubscriptionsComponent} from './subscriptions/subscriptions.component';

const appRoutes: Routes = [
  {path: '', redirectTo: '/products', pathMatch: 'full'},
  {path: 'products', component: ProductsComponent},
  {path: 'products/id/:id', component: ProductComponent},
  {path: 'products/category_id/:id', component: ProductsComponent},
  {path: 'my-products', component: ManagerProductsComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'users', component: UserComponent},
  {path: 'wallets', component: WalletsComponent},
  {path: 'all-wallets', component: WalletTableComponent},
  {path: 'subscriptions', component: MySubscriptionsComponent},
  {path: 'all-subscriptions', component: SubscriptionsComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    NavbarComponent,
    ProductsComponent,
    WalletTableComponent,
    WalletsComponent,
    LoginComponent,
    RegisterComponent,
    ProductComponent,
    MySubscriptionsComponent,
    ManagerProductsComponent,
    SubscriptionsComponent
  ],
  imports: [
    HttpModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxSpinnerModule,
    NgBootstrapFormValidationModule,
    NgBootstrapFormValidationModule.forRoot(),
    AlertModule.forRoot(),
    ButtonsModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    CollapseModule.forRoot(),
    BsDatepickerModule.forRoot(),
    CarouselModule.forRoot(),
    TabsModule.forRoot()
  ],
  providers: [
    AuthService,
    TokenStorage,
    Interceptor,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: Interceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
