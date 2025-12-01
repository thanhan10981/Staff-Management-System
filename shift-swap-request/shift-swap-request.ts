import { Component } from '@angular/core';

@Component({
  selector: 'app-shift-swap-request',
  imports: [],
  templateUrl: './shift-swap-request.html',
  styleUrl: './shift-swap-request.scss',
})
export class ShiftSwapRequest {
activeMenu: number | null = null;

  toggleMenu(index: number) {
    this.activeMenu = this.activeMenu === index ? null : index;
  }

  closeAllMenus() {
    this.activeMenu = null;
  }

  ngOnInit() {
    document.addEventListener('click', (e) => {
      const target = e.target as HTMLElement;
      if (!target.closest('.action-cell')) {
        this.closeAllMenus();
      }
    });
  }

  // Popup chi tiết
  showDetailPopup = false;
  openDetailPopup() {
    this.showDetailPopup = true;
    this.closeAllMenus(); 
  }

  closeDetailPopup() {
    this.showDetailPopup = false;
  }

  // Popup thêm nhân viên
  isAddMenuVisible = false;
  toggleAddMenu() {
    this.isAddMenuVisible = !this.isAddMenuVisible;
  }

  showAddPopup = false;
  openAddPopup(method: string) {
    if (method === 'manual') this.showAddPopup = true;
    this.isAddMenuVisible = false;
  }

  closeAddPopup() {
    this.showAddPopup = false;
  }

  onExcelSelected(event: any) {
    const file = event.target.files[0];
    if (file) alert(`Đã chọn file: ${file.name}`);
    this.isAddMenuVisible = false;
  }
}
