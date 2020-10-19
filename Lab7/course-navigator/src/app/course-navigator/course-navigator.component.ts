import { Component, OnInit } from '@angular/core';
import {CourseService} from '../services/CourseService';

@Component({
  selector: 'app-course-navigator',
  templateUrl: './course-navigator.component.html',
  styleUrls: ['./course-navigator.component.css']
})
export class CourseNavigatorComponent implements OnInit {

  constructor(private courseService: CourseService) {
  }

  courses: [];
  selectedCourse = {
    modules: []
  };
  selectedModule = {
    lessons: []
  };
  selectedLesson: [];

  ngOnInit(): void {
    this.courseService.findAllCourses()
        .then(courses => this.courses = courses);
  }
  selectCourse(course) {
    this.selectedCourse = course;
  }
  selectModule(module){
    this.selectedModule = module;
  }
  selectLesson(lesson) {
    this.selectedLesson = lesson;
  }

}
