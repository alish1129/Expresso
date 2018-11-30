import {Component, OnInit} from '@angular/core';
import {ExpressoService} from '../services/expresso.service';
import {Router} from '@angular/router';
import {Stock} from '../types/stock';
import {SorterService} from '../services/sorter.service';

@Component({
  selector: 'app-index-page',
  templateUrl: './index-page.component.html',
  styleUrls: ['./index-page.component.scss']
})
export class IndexPageComponent implements OnInit {

  stocks: Stock[];
  searchResults: Stock[] = [];
  searchInput = '';
  showDropDown = false;
  pageLoaded = false;
  noOfClicks = 0;

  constructor(private expressoService: ExpressoService, private router: Router, private sorter: SorterService) {
    this.expressoService.getStocks()
      .then(() => {
        this.stocks = this.expressoService.stockList;
        this.pageLoaded = true;
      });
  }

  ngOnInit() {
  }

  onSearchResultsClick(ticker: string) {
    this.router.navigate(['/index', ticker])
      .catch((error) => {
        console.log(error);
      });
  }

  searchStock($event: Event) {
    this.searchInput = $event.srcElement['value'].toString().toLocaleLowerCase();
    this.searchResults = this.stocks.filter((stock: Stock) => {
      return stock.name.toLocaleLowerCase().includes(this.searchInput);
    });
    console.log(this.searchResults);
  }

  toggleDropDown() {
    this.showDropDown = !this.showDropDown;
  }

  sortNumber(value) {
    if (this.noOfClicks % 2 === 0) {
      this.noOfClicks++;
      this.stocks = this.sorter.sortNumberAscending(this.stocks, value);
    } else if (this.noOfClicks % 2 === 1) {
      this.noOfClicks++;
      this.stocks = this.sorter.sortNumberDescending(this.stocks, value);
    }
  }

  sortString(value) {
    if (this.noOfClicks % 2 === 0) {
      this.noOfClicks++;
      this.stocks = this.sorter.sortStringByAscendingOrder(this.stocks, value);
    } else if (this.noOfClicks % 2 === 1) {
      this.noOfClicks++;
      this.stocks = this.sorter.sortStringByDescendingOrder(this.stocks, value);
    }
  }

}
