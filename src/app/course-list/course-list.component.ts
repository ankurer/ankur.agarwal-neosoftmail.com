import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {


  message="";

  list=[];

  form={

    title:"",
    description:""
  }

  constructor(private service:CourseService,private router:Router,private http:HttpClient) { }

  ngOnInit(){
   
     this.search();

  }


   search(){

    var _self =this;
    _self.http.get("http://localhost:8086/courses").subscribe(
      (res)=>{console.log(res)
       
          _self.list=res.data;
      
      },(error)=>{
        console.log(error);
      }
      
       

    )

   }

  // search() {
  //   var _self = this;
  //   this.service.search(this.form, function (res, error) {
  //     if (error) {
  //       alert("Error " + res.message);
  //       return;
  //     }
  //     _self.list = res.result.data;
  //   });
  // }

  edit(id) {
    this.router.navigateByUrl('/course/' + id);
  }

  /**
   * Deletes a record
   * @param id 
   */
  delete(id) {
    var _self = this;
    this.service.delete(id, function (res, error) {
      if (error) {
        alert("Error " + res.message);
        return;
      }
      _self.search();
    });
  }

}
