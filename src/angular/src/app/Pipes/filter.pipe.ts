import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(stocks: any[], searchInput: string): any[] {

    if (!stocks) {
      return [];
    }
    if (!searchInput) {
      return stocks;
    }
    searchInput = searchInput.toLocaleLowerCase();

    return stocks.filter(it => {
      return it.toLocaleLowerCase().includes(searchInput);
    });
  }

}

