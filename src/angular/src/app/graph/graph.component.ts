import {AfterContentChecked, AfterContentInit, AfterViewInit, Component, Input, OnInit} from '@angular/core';
import * as Chart from 'chart.js';

@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.scss']
})


export class GraphComponent implements AfterViewInit{
  @Input() datasetlow: number[];
  @Input() datasethigh: number[];
  @Input() dataLabel: string[];

  chart: any;

  constructor() {
  }

  ngAfterViewInit() {
    this.chart = new Chart('canvas', {
      type: 'line',
      data: {
        labels: this.dataLabel,
        datasets: [{
          data: this.datasetlow,
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
