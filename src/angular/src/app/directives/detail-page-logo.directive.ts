import {AfterViewInit, Directive, ElementRef, Input, OnInit, Renderer2} from '@angular/core';

@Directive({
  selector: '[appDetailPageLogo]'
})
export class DetailPageLogoDirective implements AfterViewInit {
 @Input('appDetailPageLogo')value: string;

  constructor(private renderer: Renderer2, private elementRef: ElementRef) {
  }

  ngAfterViewInit() {
    console.log(this.value);
    // this.renderer.setStyle(this.elementRef.nativeElement, 'color', 'red');
    // this.renderer.setStyle(this.elementRef.nativeElement, 'background', 'rgba(255, 255, 255, 0.4) url(' + this.value + ') no-repeat center');
    this.renderer.setStyle(this.elementRef.nativeElement, 'background-size', '300px, 300px');

  }
}
