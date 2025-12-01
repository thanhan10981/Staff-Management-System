import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-leave-request-popup',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-leave-request-popup.html',
  styleUrls: ['./add-leave-request-popup.scss'],
})
export class AddLeaveRequestPopup {
  @Output() close = new EventEmitter<void>();
  @Output() submit = new EventEmitter<any>();

  // 👇 Khai báo đủ các field theo đúng HTML
  leaveRequest = {
    employeeId: '',
    departmentId: '',
    startDate: '',
    endDate: '',
    type: '',
    reason: ''
  };

  submitForm() {
    this.submit.emit(this.leaveRequest);
  }

  closePopup() {
    this.close.emit();
  }
}
