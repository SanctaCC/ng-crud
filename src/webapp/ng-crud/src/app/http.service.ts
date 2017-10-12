import { Injectable } from '@angular/core';
import { Http,RequestOptions,Headers } from "@angular/http";

@Injectable()
export class HttpService {

  constructor(private http: Http) { }

  getData(){
    return this.http.get('http://localhost:8080/api/persons.json');
  }
  postData(person:any){
    const body = JSON.stringify(person);
    const headers = new Headers();
    headers.append("Content-Type","application/json");
    const options = new RequestOptions({ headers: headers });
    return this.http.post('http://localhost:8080/api/persons.json',body,options
  );
  }

  deleteData(id:Number){
    console.log("deleteData");
    return this.http.delete("http://localhost:8080/api/persons/"+id+".json");
  }
}
