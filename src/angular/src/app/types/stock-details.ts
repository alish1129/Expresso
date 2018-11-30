import {Quote} from './quote';
import {News} from './news';
import {Chart} from './chart';

export interface StockDetail {
    quote: Quote[];
    chart: Chart[];
    news: News[];
}
