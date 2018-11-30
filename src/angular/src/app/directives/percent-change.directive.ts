import {AfterViewInit, Directive, ElementRef, Input, Renderer2} from '@angular/core';

@Directive({
  selector: '[appPercentChange]'
})
export class PercentChangeDirective implements AfterViewInit {
  @Input('appPercentChange') price: any;

  constructor(private elementRef: ElementRef, private renderer: Renderer2) {

  }

  ngAfterViewInit() {
    let value = (this.price);

    if (value > 0){
      this.renderer.setStyle(this.elementRef.nativeElement, 'color', '#65bc00');
    } else if (value < 0){
      this.renderer.setStyle(this.elementRef.nativeElement, 'color', '#ff0000');
    } else {
    }
  }
}
