import {Spectator} from "@ngneat/spectator";
import {AppComponent} from "./app.component";
import {createComponentFactory} from "@ngneat/spectator/jest";
import {AppRoutingModule} from "./app-routing.module";

describe("AppComponent", () => {
  let spectator: Spectator<AppComponent>;

  const createComponent = createComponentFactory({
    component: AppComponent,
    imports: [AppRoutingModule],
  });

  beforeEach(() => {
    spectator = createComponent();
  });

  it('should have a title', () => {
    expect(spectator.component.title).toEqual('portfolio-for-enterprise')
  });

})
