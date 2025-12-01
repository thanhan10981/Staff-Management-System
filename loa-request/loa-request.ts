import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { EmployeeDetailPopup } from '../../employee/employee-detail-popup/employee-detail-popup';
import { AddLeaveRequestPopup } from './add-leave-request-popup';
import { EmployeeService } from '../../../service/employees';
import { EmployeeModel } from '../../../model/model';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-loa-request',
  standalone: true,
  imports: [ CommonModule, FormsModule, HttpClientModule,EmployeeDetailPopup, AddLeaveRequestPopup],
  templateUrl: './loa-request.html',
  styleUrls: ['./loa-request.scss'],
})
export class LoaRequest implements OnInit {

  employees: EmployeeModel[] = [];
  filteredEmployees: EmployeeModel[] = [];

  searchText: string = '';

  isAddMenuVisible = false;
  showDetailPopup = false;
  showAddPopup = false;
  

  activeMenu: number | null = null;

  selectedEmployee: EmployeeModel | null = null;

  constructor(private employeeService: EmployeeService) {}

  ngOnInit() {
    this.employeeService.getAllEmployees().subscribe({
      next: (data: EmployeeModel[]) => {
        this.employees = data;
        this.filteredEmployees = [...data];
      },
      error: (err: any) => console.error('Lỗi load nhân viên:', err)
    });
  }

  toggleAddMenu() {
    this.isAddMenuVisible = !this.isAddMenuVisible;
  }

  openAddPopup(type: string) {
    if (type === 'manual') this.showAddPopup = true;
    this.isAddMenuVisible = false;
  }

  closeAddPopup() {
    this.showAddPopup = false;
  }

  submitLeaveRequest(data: any) {
    console.log("Yêu cầu nghỉ phép mới:", data);

    // TODO: Gọi API POST để thêm yêu cầu vào DB
    // this.leaveService.createLeaveRequest(data).subscribe(...)

    this.showAddPopup = false;
  }

  toggleMenu(index: number) {
    this.activeMenu = this.activeMenu === index ? null : index;
  }

  getInitials(name: string): string {
    if (!name) return '';
    const parts = name.trim().split(' ');
    const last2 = parts.slice(-2);
    return last2.map(p => p[0]).join('').toUpperCase();
  }

  applyFilter() {
    const text = this.searchText.toLowerCase();

    this.filteredEmployees = this.employees.filter(emp =>
      emp.tenNhanVien.toLowerCase().includes(text) ||
      emp.maNhanVien.toLowerCase().includes(text) ||
      (emp.tenKhoa?.toLowerCase().includes(text)) ||
      (emp.tenPhongBan?.toLowerCase().includes(text))
    );
  }

  openDetailPopup(emp: EmployeeModel) {
    this.selectedEmployee = emp;
    this.employeeService.selectedEmployee = emp; // share data
    this.showDetailPopup = true;
  }

  closeDetailPopup() {
    this.showDetailPopup = false;
    this.selectedEmployee = null;
  }

  updateEmployee(emp: EmployeeModel) {
    alert(`Cập nhật: ${emp.tenNhanVien}`);
  }

  deleteEmployee(emp: EmployeeModel) {
    const ok = confirm(`Xóa: ${emp.tenNhanVien}?`);
    if (ok) {
      this.employees = this.employees.filter(e => e.maNhanVien !== emp.maNhanVien);
      this.applyFilter();
    }
  }

  getStatusClass(status: string) {
    switch (status) {
      case 'Đang làm việc': return 'status active';
      case 'Tạm nghỉ': return 'status pending';
      case 'Nghỉ việc': return 'status inactive';
      default: return 'status';
    }
  }
}
