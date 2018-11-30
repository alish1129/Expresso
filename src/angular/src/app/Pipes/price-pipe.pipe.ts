import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'pricePipe'
})
export class PricePipePipe implements PipeTransform {

  transform(value: any, args?: any): any {

  }
}
