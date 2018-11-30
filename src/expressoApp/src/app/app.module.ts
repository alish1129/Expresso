import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';

import { MyApp } from './app.component';
import { ExpressoServiceProvider } from '../providers/expresso-service/expresso-service';
import { SorterProvider } from '../providers/sorter/sorter';
import {HttpClientModule} from "@angular/common/http";
import {DirectivesModule} from "../directives/directives.module";

@NgModule({
  declarations: [
    MyApp,
   ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    HttpClientModule,
    DirectivesModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    ExpressoServiceProvider,
    SorterProvider
  ]
})
export class AppModule {}
