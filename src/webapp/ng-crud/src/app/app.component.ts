import { Component,OnInit } from '@angular/core';
import { HttpService } from "./http.service";
import { Response } from "@angular/http";
@Component({
  selector: 'crud-root',
  templateUrl: './app.component.html',
  providers: [HttpService],
  styles: ['th{ text-align: center;} td{vertical-align:middle !important}']
})
export class AppComponent implements OnInit {
  persons :any[];
  constructor(private httpService: HttpService){
  }
  ngOnInit(){
    this.httpService.getData().subscribe(
    (data:Response) => {this.persons=JSON.parse(data['_body']);data}
    );
  }
  onSubmit(name:string, lastName:string,email:string,age:Number){
    this.httpService.postData({name: name, lastName:lastName,email:email,age:age})
    .subscribe((data:Response)=>this.persons.push(JSON.parse(data['_body'])));
  }
  delete(id:Number){
    this.persons = this.persons.filter(
      p => p.id!=id
    );
    this.httpService.deleteData(id).subscribe();
    }
  title = 'crud';
}
