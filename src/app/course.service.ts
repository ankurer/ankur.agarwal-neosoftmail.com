import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  
  endpoint ="http://localhost:8086";

  constructor(private http:HttpClient) { }

  get(id:number,comCb){

    let url = this.endpoint+"/course/"+id;
    var observable = this.http.get(url);
    observable.subscribe(
      (data)=>{
        //console.log(data)
        comCb(data);
      },
      (data)=>{
        comCb(data,true);
      });

  }


  save(form,comCB){

    let url = this.endpoint+"/add";
    var observable = this.http.post(url,form);
    observable.subscribe(
      (data)=>{
        comCB(data);
      },
       (data)=>{
         comCB(data,true);
       }); 
  }



  delete(id:number,comCB){

    let url = this.endpoint+"course/"+id;
    var observable = this.http.get(url);
    observable.subscribe(
      (data)=>{comCB(data)},
      (data)=>{comCB(data,true);
      
      });
  }


//   search(form,comCB){

//     let url = this.endpoint +"courses";
//     var obs = this.http.get(url);
//     obs.subscribe(
//       (data)=>{console.log(data)},
//       (data)=>{comCB(data,true);
//       });


// }
}