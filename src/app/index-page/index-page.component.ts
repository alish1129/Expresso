import { Component, OnInit } from '@angular/core';
import { Observable} from 'rxjs';
import { ExpressoServiceProviderService} from '../expresso-service-provider.service';

@Component({
  selector: 'app-index-page',
  templateUrl: './index-page.component.html',
  styleUrls: ['./index-page.component.scss']
})
export class IndexPageComponent implements OnInit {

  stocks$: Object;

  constructor(private data: ExpressoServiceProviderService) {
  }

  ngOnInit() {
    this.data.getData().subscribe(
      data => {
        this.stocks$ = data;
        console.log(this.stocks$);
      }
    );
  }

}
