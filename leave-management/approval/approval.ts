import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-approval',
  imports: [FormsModule, CommonModule],
  templateUrl: './approval.html',
  styleUrl: './approval.scss',
})
export class Approval {
filterType: string = '';
  filterDate: string = '';

  
  pendingRequests: any[] = [
    {
      id: 1,
      employee: 'Nguyễn Văn A',
      type: 'leave',
      date: '2025-01-15',
      shift: 'Ca sáng',
      reason: 'Ốm',
    },
    {
      id: 2,
      employee: 'Trần Thị B',
      type: 'shift-swap',
      date: '2025-01-16',
      shift: 'Ca tối',
      reason: 'Đổi ca với nhân viên C',
    }
  ];

  applyFilter() {
    console.log('Filter applied:', this.filterType, this.filterDate);
  }

  approve(req: any) {
    alert(`✔ Đã duyệt yêu cầu của ${req.employee}`);
  }

  deny(req: any) {
    alert(`✖ Từ chối yêu cầu của ${req.employee}`);
  }
}
