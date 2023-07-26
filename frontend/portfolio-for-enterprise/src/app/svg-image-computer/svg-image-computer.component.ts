import {Component, Input} from '@angular/core';

@Component({
  selector: '<app-svg-image-computer',
  templateUrl: './svg-image-computer.component.html',
  styleUrls: ['./svg-image-computer.component.css'],

})
export class SvgImageComputerComponent {

  @Input() src: string | undefined;
  @Input() svg = false;

}
