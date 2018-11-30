import {Component, OnInit} from '@angular/core';
import {IonicPage, LoadingController, NavController, NavParams, ToastController} from 'ionic-angular';
import {ExpressoServiceProvider} from "../../providers/expresso-service/expresso-service";
import {Stock} from "../../types/stock";

@IonicPage()
@Component({
  selector: 'page-home',
  templateUrl: 'home.html',
})
export class HomePage implements OnInit{

  stocks: Stock[];
  searchList: Stock[];
  searchToggled: boolean;

  constructor(public navCtrl: NavController, public navParams: NavParams,
              private service: ExpressoServiceProvider, private loadCtrl: LoadingController,
              private toastCtrl: ToastController) {

    this.stocks = [];
    this.searchList = [];
    this.searchToggled = false;

  }

  ngOnInit(){

    let loader = this.loadCtrl.create({
      duration: 10000
    });

    let toaster = this.toastCtrl.create({
      duration: 3000,
    });

    loader.present()
      .then(()=> {
        this.service.getStocks()
          .then(()=> this.stocks = this.service.stockList)
          .then(()=> loader.dismiss())
          .then(()=> {
            toaster.setCssClass('success-toaster');
            toaster.setMessage('Stock successfully loaded');
            return toaster.present();
          })
          .catch(() => {
            toaster.setMessage('Something went wrong.');
            toaster.setCssClass('failure-toaster');
            return toaster.present();
          })
      })

  }

  ionViewDidLoad() {

    console.log('ionViewDidLoad HomePage');
  }


  searchOption(event: any) {
    this.searchList = this.stocks.filter((stock: Stock) => {
      console.log(event.value);
      return stock.name.toLowerCase().includes(event.value.toLowerCase())
    });
    console.log(this.searchList);
  }

  toggleClosed(){
    this.searchToggled = !this.searchToggled;
    this.searchList = [];
  }
}
