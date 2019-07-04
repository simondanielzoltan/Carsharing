import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  public baseUrl: String = '//localhost:8080';

  constructor(private http: HttpClient) { }

  public getAllCars(): Observable<any>{
    return this.http.get(this.baseUrl+'/cars/list-cars');
  }

}
