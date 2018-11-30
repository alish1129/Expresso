import {Component, Input, OnInit} from '@angular/core';
import * as Chart from 'chart.js';

@Component({
  selector: 'app-bar-chart',
  templateUrl: './bar-chart.component.html',
  styleUrls: ['./bar-chart.component.scss']
})

export class BarChartComponent implements OnInit {
  @Input() dataLabel: string[];
  @Input() dataset: number[];

  barChart: any;

  constructor() {
  }

  ngOnInit() {
    const densityCanvas = <HTMLCanvasElement> document.getElementById('canvas');

    Chart.defaults.global.defaultFontFamily = 'Lato';
    Chart.defaults.global.defaultFontSize = 18;

    const densityData = {
      label: 'Density of Planet (kg/m3)',
      data: [5427, 5243, 5514, 3933, 1326, 687, 1271, 1638],
      backgroundColor: 'rgba(0, 99, 132, 0.6)',
      borderWidth: 0,
      yAxisID: 'y-axis-density'
    };

    const gravityData = {
      label: 'Gravity of Planet (m/s2)',
      data: [3.7, 8.9, 9.8, 3.7, 23.1, 9.0, 8.7, 11.0],
      backgroundColor: 'rgba(99, 132, 0, 0.6)',
      borderWidth: 0,
      yAxisID: 'y-axis-gravity'
    };

    const planetData = {
      labels: ['Mercury', 'Venus', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'Uranus', 'Neptune'],
      datasets: [densityData, gravityData]
    };

    const chartOptions = {
      scales: {
        xAxes: [{
          barPercentage: 1,
          categoryPercentage: 0.6
        }],
        yAxes: [{
          id: 'y-axis-density'
        }, {
          id: 'y-axis-gravity'
        }]
      }
    };

    this.barChart = new Chart(densityCanvas, {
      type: 'bar',
      data: planetData,
      options: chartOptions
    });

  }
}
