import {Injectable} from '@angular/core';

@Injectable()
export class UserService {
  users = [
    { id: 123, username: 'bob', password: 'bobpassword'},
    { id: 567, username: 'mike', password: 'mikepassword'}
  ];
  // tslint:disable-next-line:typedef
  findUserByCredentials(username: string, password: string) {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.users.length; i++) {
      const user = this.users[i];
      if (username === user.username && password === user.password) {
        return user;
      }
    }
    return null;
  }
  // tslint:disable-next-line:typedef
  findUserById(id: number) {
    return this.users.find(u => u.id == id);
  }
}