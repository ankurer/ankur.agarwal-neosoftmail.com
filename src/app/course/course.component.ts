import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from '../course.service';



@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  //College form    
  form = {
    id: 0,
    title: "",
    description: ""
    
  };

  //Input errors
  // inputError = {
  //   "name": "",
  //   "address": "",
  //   "state": "",
  //   "city": "",
  //   "phoneNo": ""
  // };

  //Server success/fail message
  message = "";



  //Server error
  success: boolean = true;
  /**
   * Injects services 
   * 
   * @param aroute 
   * @param router 
   * @param service 
   */
  constructor(private aroute: ActivatedRoute, private router: Router, private service:CourseService) { }


  /**
   * Display record if primary key is received 
   */
  ngOnInit() {
    var _self = this;
    this.form.id = parseInt(this.aroute.snapshot.paramMap.get("id"));
    if ( !isNaN(this.form.id) && this.form.id > 0) {
      this.service.get(this.form.id, function (res, error) {
        if (error) {
          alert("Error:" + error.message);
          return;
        }
        _self.form = res.result.data;
      });
    }
  }

  /**
   * Save a record
   */
  save() {
    var _self = this;
    this.service.save(this.form, function (res, error) {
      if (error) {
        _self.success = false;
        _self.message = res.message;
        return;
      }

      _self.success = res.success;
      if(_self.success){
        _self.message = "Record is successfully saved..";
        // _self.inputError = {
        //   "name": "",
        //   "address": "",
        //   "state": "",
        //   "city": "",
        //   "phoneNo": ""
        // };
      }else{
        _self.message = "Data Error";
       // _self.inputError = res.result.inputerror
      }
    });
  }

  /**
   * Go to search page 
   */
  search() {
    this.router.navigateByUrl('/courselist');
  }

}
