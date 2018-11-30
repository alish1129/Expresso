import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { DetailsPage } from './details';
import {GraphComponent} from "../../components/graph/graph";

@NgModule({
  declarations: [
    DetailsPage,
    GraphComponent

  ],
  imports: [
    IonicPageModule.forChild(DetailsPage),
  ],
})
export class DetailsPageModule {}
