import {Component, Input} from '@angular/core';
import {ExpressoServiceProvider} from "../../providers/expresso-service/expresso-service";
import * as Chart from 'chart.js';


/**
 * Generated class for the GraphComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'graph',
  templateUrl: 'graph.html'
})
export class GraphComponent {

  @Input() ticker: string;
  @Input() dataValue: number[];
  @Input() dataLabel: string[];

  chart: any;

  constructor(private service: ExpressoServiceProvider) {

  }

  ngAfterViewInit() {
    console.log(this.dataLabel);
    console.log(this.dataValue);
    this.chart = new Chart('canvas', {
      type: 'line',
      data: {
        labels: this.dataLabel,
        datasets: [{
          data: this.dataValue,
          borderColor: '#3cba9f',
          fill: true,
          label: 'Market Average',
          backgroundColor: 'rgba(24,73,62,0.5)',
          pointRadius: 1,
        }]
      }
    });
  }
}
