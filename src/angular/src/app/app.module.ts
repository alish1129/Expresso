import {BrowserModule} from '@angular/platform-browser';
import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';

import {AppComponent} from './app.component';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import {NavbarComponent} from './navbar/navbar.component';
import {IndexPageComponent} from './index-page/index-page.component';
import {PortfolioPageComponent} from './portfolio-page/portfolio-page.component';
import {WatchlistPageComponent} from './watchlist-page/watchlist-page.component';
import {LoginPageComponent} from './login-page/login-page.component';
import {RegisterPageComponent} from './register-page/register-page.component';
import {ForumPageComponent} from './forum-page/forum-page.component';
import {GraphComponent} from './graph/graph.component';
import {DetailStockInfoComponent} from './detail-stock-info/detail-stock-info.component';
import {TimeDatePipe} from './Pipes/time-date.pipe';
import {PricePipePipe} from './Pipes/price-pipe.pipe';
import {PercentChangeDirective} from './directives/percent-change.directive';
import {NgxPaginationModule} from 'ngx-pagination';
import {PercentIconPipe} from './Pipes/percent-icon.pipe';
import { DetailPageLogoDirective } from './directives/detail-page-logo.directive';
import { FilterPipe } from './Pipes/filter.pipe';
import { BarChartComponent } from './bar-chart/bar-chart.component';

@NgModule({
  declarations: [
    AppComponent,
    IndexPageComponent,
    PortfolioPageComponent,
    WatchlistPageComponent,
    NavbarComponent,
    LoginPageComponent,
    RegisterPageComponent,
    ForumPageComponent,
    GraphComponent,
    DetailStockInfoComponent,
    TimeDatePipe,
    PricePipePipe,
    PercentChangeDirective,
    PercentIconPipe,
    DetailPageLogoDirective,
    FilterPipe,
    BarChartComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    MDBBootstrapModule.forRoot(),
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  schemas: [NO_ERRORS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
