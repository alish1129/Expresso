import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../types/user';
import {Stock} from '../types/stock';
import 'rxjs/Rx';
import {StockDetail} from '../types/stock-details';
import 'rxjs/add/operator/toPromise';
import {CompanyInfo} from '../types/company-info';
import {reject} from "q";

@Injectable({
  providedIn: 'root'
})
export class ExpressoService {

  stock: StockDetail;
  company: CompanyInfo;
  stockList: Stock[];
  watchList: Stock[];
  userLoggedIn: boolean;
  regisMessage: string;
  portfolio: any[];
  user: any;

  constructor(private http: HttpClient) {
  }

  signUp(user: User) {

    return new Promise((resolve, reject) => {
      this.http.post('/user/authenticate', user)
        .toPromise()
        .catch((err) => {
          console.log(err);
          if (err.error.text === 'success') {
            resolve();
          } else {
            reject();
            this.regisMessage = err.error.text;
          }
        });
    });
  }

  login(user) {
    const params = 'username=' + user.username + '&password=' + user.password;
    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });

    return new Promise((resolve, reject) => {
      console.log(params);
      this.http.post('/login', params, {headers: headers, withCredentials: true})
        .toPromise()
        .catch((err) => {
          console.log(err.url);
          if (err.url === 'http://localhost:8000/portfolio') {
            this.userLoggedIn = true;
            resolve();
          } else {
            this.userLoggedIn = false;

            reject();
          }
        });
    });
  }

  logout() {
    return new Promise((resolve, reject) => {
      this.http.get('logout')
        .toPromise()
        .then(() => {
        })
        .catch(() => {
          resolve();
        });
    });
  }


  getStocks() {
    return new Promise((resolve, reject) => {
      this.http.get('stock/getQuotes')
        .toPromise()
        .then((res: Stock[]) => {
          this.stockList = res;

        })
        .then(() => resolve());
    });
  }

  addStockToWatchList(id): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.get('/stock/createQuoteWatchlist/' + id)
        .toPromise()
        .then((res: Stock[]) => {
          this.watchList = res;
        })
        .then(() => resolve());
    });
  }

  getWatchlist() {
    return new Promise((resolve, reject) => {
      this.http.get('/stock/getQuoteWatchlist')
        .toPromise()
        .then((res: Stock[]) => {
          this.watchList = res;
        })
        .then(() => resolve());
    });
  }

  getDataForGraph(ticker) {
    return new Promise((resolve, reject) => {
      this.http.get('/1.0/stock/' + ticker + '/batch?types=quote,news,chart&range=6m&last=10')
        .toPromise()
        .then((res: StockDetail) => {
          this.stock = res;
          console.log(res);
        })
        .then(() => this.getCompanyInfo(ticker))
        .then(() => resolve());

    });
  }

  getCompanyInfo(ticker) {
    return new Promise((resolve, reject) => {
      this.http.get('/1.0/stock/' + ticker + '/company')
        .toPromise()
        .then((res: CompanyInfo) => {
          this.company = res;
          resolve();
        });
    });
  }

  addToPortfolio(id, quantity, date, pricePaid) {
    return new Promise((resolve, reject) => {
      this.http.get('/stock/createQuotePortfolio/' + id + '/' + quantity + '/' + date + '/' + pricePaid)
        .toPromise()
        .then((res) => {
          resolve();
        });
    });
  }

  getPortfolio() {
    return new Promise((resolve, reject) => {
      this.http.get('/stock/getQuotePortfolio')
        .toPromise()
        .then((res: any[]) => {
          this.portfolio = res;
          console.log(res);
        })
        .then(() => resolve());
    });
  }

  loggedIn() {
    return new Promise((resolve, reject) => {
      this.http.get('/stock/isUserAuthenticated')
        .toPromise()
        .then((res) => {
        })
        .catch((err) => {
          console.log(err.error.text);
          if (err.error.text === 'yes') {
            this.userLoggedIn = true;
          } else {
            this.userLoggedIn = false;
          }
          resolve();
        });
    });
  }

  getUser() {
    return new Promise((resolve) => {
      this.http.get('/stock/getUserDetail')
        .toPromise()
        .then((res: any[]) => {
          res.map((user) => {
            this.user = user;
          });
        })
        .then(() => resolve());
    });
  }

  removeStockFromWatchlist(ticker) {
    return new Promise((resolve) => {
      this.http.get(('stock/deleteQuoteWatchlist/' + ticker))
        .toPromise()
        .then(() => {
          resolve();
        });
    });
  }

  removeStockFromPortfolio(ticker) {
    return new Promise((resolve) => {
      this.http.get(('stock/deleteQuotePortfolio/' + ticker))
        .toPromise()
        .then(() => {
          resolve();
        });
    });
  }

}
