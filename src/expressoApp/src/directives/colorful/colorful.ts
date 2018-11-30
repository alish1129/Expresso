import {AfterViewInit, Directive, ElementRef, Input, Renderer2} from '@angular/core';

/**
 * Generated class for the ColorfulDirective directive.
 *
 * See https://angular.io/api/core/Directive for more info on Angular
 * Directives.
 */
@Directive({
  selector: '[colorful]' // Attribute selector
})
export class ColorfulDirective implements AfterViewInit {

  @Input('colorful') price: number;

  constructor(private renderer: Renderer2, private elementRef: ElementRef) {

  }
  ngAfterViewInit(){
    let value = (this.price);

    if (value > 0) {
      this.renderer.setStyle(this.elementRef.nativeElement, 'color', '#65bc00');
    } else if (value < 0) {
      this.renderer.setStyle(this.elementRef.nativeElement, 'color', '#ff0000');
    } else {
    }
  }
}
