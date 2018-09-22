import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ExpressoServiceProviderService {

  constructor(private httpClient: HttpClient) {
  }

  getData() {
    return this.httpClient.get('/data/todaysprice');
  }
}
