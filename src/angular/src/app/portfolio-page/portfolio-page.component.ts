import {Component, OnInit, ViewChild} from '@angular/core';
import {ExpressoService} from '../services/expresso.service';
import {Stock} from '../types/stock';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';
import {ModalDirective} from 'angular-bootstrap-md';

@Component({
  selector: 'app-portfolio-page',
  templateUrl: './portfolio-page.component.html',
  styleUrls: ['./portfolio-page.component.scss']
})
export class PortfolioPageComponent implements OnInit {
  @ViewChild('basicModal') basicModal: ModalDirective;
  @ViewChild('successModal') successModal: ModalDirective;
  @ViewChild('deleteModal') deleteModal: ModalDirective;

  portfolio: any[];
  stocks: Stock[];
  tickerToAdd: string;
  quantity: number;
  date: number;
  pricePaid: number;
  profitLoss: number [];
  pageLoaded = false;
  tickerToRemove = '';
  message = '';

  constructor(private service: ExpressoService, private route: Router) {

    this.service.loggedIn()
      .then(() => {
        if (this.service.userLoggedIn === false) {
          return this.route.navigate(['signin']);
        } else {
          this.getStocks();
        }
      });
  }

  ngOnInit() {

  }

  getStocks() {
    this.service.getStocks()
      .then(() => this.stocks = this.service.stockList);
    this.service.getPortfolio()
      .then(() => {
        this.portfolio = this.service.portfolio;
        this.profitLoss = this.portfolio.map((value) => {
          return value.difference;
        });
        this.pageLoaded = true;
        console.log(this.portfolio);
      });
  }

  addToPortfolio(f: NgForm) {
    this.tickerToAdd = f.value.stock;
    this.quantity = f.value.quantity;
    this.pricePaid = f.value.pricePaid;
    this.date = f.value.DOP;
    console.log(this.date);
    this.service.addToPortfolio(this.tickerToAdd, this.quantity, this.date, this.pricePaid)
      .then(() => {
        this.basicModal.hide();
        this.message = 'Successfully Added ' + this.tickerToAdd + ' to Portfolio!';
        this.successModal.show();
        setTimeout(() => {
          this.successModal.hide();
        }, 2000);
      })
      .then(() => location.reload());
  }

  stockDetails(id) {
    this.route.navigate(['index/', id]);
  }


  removeStock() {
    this.service.removeStockFromPortfolio(this.tickerToRemove)
      .then(() => {
        this.deleteModal.hide();
        this.message = 'Successfully deleted ' + this.tickerToRemove + ' from Portfolio!';
        this.successModal.show();
        setTimeout(() => {
          this.successModal.hide();
        }, 2000);
      })
      .then(() => location.reload());
  }
}
