import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { EmployeeModel } from '../model/model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiUrl = 'http://localhost:9090/api';
  
  selectedEmployee: EmployeeModel | null = null;
  constructor(private http: HttpClient) {}

  // Lấy toàn bộ nhân viên
  getAllEmployees(): Observable<EmployeeModel[]> {
    return this.http.get<EmployeeModel[]>(`${this.apiUrl}/NhanVien`);
  }

  // 🔥 DÙNG STRING — THEO ĐÚNG MODEL EmployeeModel
  getEmployeeById(id: string): Observable<EmployeeModel> {
    return this.http.get<EmployeeModel>(`${this.apiUrl}/NhanVien/${id}`);
  }

  // Thêm nhân viên
  createEmployee(emp: EmployeeModel): Observable<EmployeeModel> {
    return this.http.post<EmployeeModel>(`${this.apiUrl}/NhanVien`, emp);
  }

  
  updateEmployee(id: string, emp: EmployeeModel): Observable<EmployeeModel> {
    return this.http.put<EmployeeModel>(`${this.apiUrl}/NhanVien/${id}`, emp);
  }


  deleteEmployee(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/NhanVien/${id}`);
  }
}
