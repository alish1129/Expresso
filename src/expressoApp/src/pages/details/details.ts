import {Component} from '@angular/core';
import {IonicPage, LoadingController, NavController, NavParams} from 'ionic-angular';
import {ExpressoServiceProvider} from "../../providers/expresso-service/expresso-service";
import {CompanyInfo} from "../../types/company-info";
import {StockDetail} from "../../types/stock-details";
import {News} from "../../types/news";
import {Quote} from "../../types/quote";

/**
 * Generated class for the DetailsPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-details',
  templateUrl: 'details.html',
})
export class DetailsPage {

  ticker: string;
  dataLabel = [];
  dataValue = [];
  company: CompanyInfo;
  stock: Quote[];
  news: News[];
  graphLoaded = false;

  constructor(public navCtrl: NavController, public navParams: NavParams,
              private service: ExpressoServiceProvider, private loadCtrl: LoadingController) {
    this.ticker = this.navParams.get('ticker');


  }

  ngOnInit() {
    let loader = this.loadCtrl.create({
      duration: 10000
    });

    loader.present()
      .then(() => {
        this.service.getDataForGraph(this.ticker)
          .then(() => {
            this.company = this.service.company;
            this.stock = this.service.stock.quote;
            this.news = this.service.stock.news;
          })
      })
      .then(() => this.graphLoaded= true)
      .then(() => loader.dismissAll())
  }

}
