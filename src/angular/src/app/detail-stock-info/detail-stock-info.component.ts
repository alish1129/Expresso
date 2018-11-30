import {Component, OnInit} from '@angular/core';
import {ExpressoService} from '../services/expresso.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Quote} from '../types/quote';
import {StockDetail} from '../types/stock-details';
import {News} from '../types/news';
import {CompanyInfo} from '../types/company-info';

@Component({
  selector: 'app-detail-stock-info',
  templateUrl: './detail-stock-info.component.html',
  styleUrls: ['./detail-stock-info.component.scss']
})
export class DetailStockInfoComponent implements OnInit {

  stock: Quote[];
  pageLoaded = false;
  ticker: string;
  graphDataLow: number[] = [];
  graphLabel: string[] = [];
  news: News[];
  company: CompanyInfo;
  tags: string[];
  selectedGraphDate = '1d';
  userLoggedIn: boolean;

  constructor(private service: ExpressoService, private routes: ActivatedRoute, private router: Router) {

    this.userLoggedIn = this.service.userLoggedIn;

    this.ticker = this.routes.snapshot.params['ticker'];
    this.service.getDataForGraph(this.ticker)
      .then(() => {
        this.company = this.service.company;
        this.stock = this.service.stock.quote;
        this.news = this.service.stock.news;
        this.service.stock.chart.forEach((value) => {
          if (value.marketAverage !== -1) {
            this.graphDataLow.push(value.open);
            this.graphLabel.push(value.label);
          }
        });
      })
      .then(() => {
        this.pageLoaded = true;
      });
  }

  ngOnInit() {
  }


  addToWatchlist() {
    this.service.addStockToWatchList(this.ticker)
      .then(() => {
        this.router.navigate(['watchlist']);
      });
  }

  addToPortfolio(f) {
    const ticker = this.ticker;
    const date = f.value.date;
    const quantity = f.value.quantity;
    const pricePaid = f.value.pricePaid;
    this.service.addToPortfolio(ticker, quantity, date, pricePaid)
      .then(() => {
        this.router.navigate(['portfolio']);
   });
  }

}
