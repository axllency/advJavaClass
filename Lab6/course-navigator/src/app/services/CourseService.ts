import {Injectable} from '@angular/core';

@Injectable() // @ts-ignore
export class CourseService{
    findAllCourses = () => fetch('http://localhost:8080/api/courses').then(response => response.json())
}
