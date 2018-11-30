import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {IndexPageComponent} from './index-page/index-page.component';
import {PortfolioPageComponent} from './portfolio-page/portfolio-page.component';
import {WatchlistPageComponent} from './watchlist-page/watchlist-page.component';
import {LoginPageComponent} from './login-page/login-page.component';
import {RegisterPageComponent} from './register-page/register-page.component';
import {ForumPageComponent} from './forum-page/forum-page.component';
import {DetailStockInfoComponent} from './detail-stock-info/detail-stock-info.component';

const routes: Routes = [
  {path: '', component: IndexPageComponent},
  {path: 'portfolio', component: PortfolioPageComponent},
  {path: 'watchlist', component: WatchlistPageComponent},
  {path: 'signin', component: LoginPageComponent},
  {path: 'register', component: RegisterPageComponent},
  {path: 'forum', component: ForumPageComponent},
  {path: 'index/:ticker', component: DetailStockInfoComponent},
];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)]
})

export class AppRoutingModule {
}
