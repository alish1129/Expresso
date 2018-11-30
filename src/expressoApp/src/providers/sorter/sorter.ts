import { Injectable } from '@angular/core';
import {Stock} from "../../types/stock";

@Injectable()
export class SorterProvider {

  constructor() {
  }

  sortNumberAscending(stocks: Stock[], value) {
    stocks = stocks.sort(function (a, b) {
      if (a[value] < b[value]) {
        return -1;
      } else if (a[value] > b[value]) {
        return 1;
      }
      return 0;
    });
    return stocks;
  }

  sortNumberDescending(stocks: Stock[], value) {
    stocks = stocks.sort(function (a, b) {
      if (a[value] > b[value]) {
        return -1;
      } else if (a[value] < b[value]) {
        return 1;
      }

      return 0;
    });
    return stocks;
  }

  sortStringByAscendingOrder(stocks: Stock[], value) {
    stocks = stocks.sort(function (a, b) {
      if (a[value].toLocaleLowerCase() > b[value].toLocaleLowerCase()) {
        return -1;
      } else if (a[value].toLocaleLowerCase() < b[value].toLocaleLowerCase()) {
        return 1;
      }
      return 0;
    });
    return stocks;

  }

  sortStringByDescendingOrder(stocks: Stock[], value) {
    stocks = stocks.sort(function (a, b) {
      if (a[value].toLocaleLowerCase() < b[value].toLocaleLowerCase()) {
        return -1;
      } else if (a[value].toLocaleLowerCase() > b[value].toLocaleLowerCase()) {
        return 1;
      }
      return 0;
    });
    return stocks;
  }

}
