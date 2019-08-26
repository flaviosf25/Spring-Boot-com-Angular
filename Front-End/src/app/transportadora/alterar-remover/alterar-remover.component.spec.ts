import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlterarRemoverComponent } from './alterar-remover.component';

describe('AlterarRemoverComponent', () => {
  let component: AlterarRemoverComponent;
  let fixture: ComponentFixture<AlterarRemoverComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlterarRemoverComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlterarRemoverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
