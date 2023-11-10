import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostEventTrackingComponent } from './post-event-tracking.component';

describe('PostEventTrackingComponent', () => {
  let component: PostEventTrackingComponent;
  let fixture: ComponentFixture<PostEventTrackingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostEventTrackingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostEventTrackingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
