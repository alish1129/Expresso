import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'percentIcon'
})
export class PercentIconPipe implements PipeTransform {

  transform(value: any, args?: any): any {

    if (value < 0) {
      return 'fa arrow-down';
    } else if (value > 0) {
      return 'fa arrow-up';
    } else {
      return 'fa exchange';
    }
  }

}
