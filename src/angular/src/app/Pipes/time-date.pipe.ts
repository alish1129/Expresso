import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'timeDate'
})
export class TimeDatePipe implements PipeTransform {

  transform(value: any, args?: any): any {
      var d = new Date(value);
      let date = d.toLocaleDateString() + " " + d.toLocaleTimeString();
    return date;
  }

}
