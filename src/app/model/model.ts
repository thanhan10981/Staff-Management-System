export interface EmployeeModel {
  maNhanVien: string;
  tenNhanVien: string;
  ngaySinh: string;
  gioiTinh: string;
  sdt: string;
  email: string;
  trangThai: string;
  maViTri: string;
  maPhongBan: string;
  maKhoa: string;
  tenViTri: string;
  tenPhongBan: string;
  tenKhoa: string;
  cccd: string;
  ngayVaoLam: string;
  trinhDoChuyenMon: string;
}
export interface PhanCongCaTruc {
  maPhanCong: number;
  maNhanVien: number;
  hoTen: string;
  maCa: number;
  maPhong: number;
  maKhoa: number;
  ngayBatDau: string;
  ngayKetThuc: string;
  lapLaiHangTuan: number;
  trangThai: number;
  ghiChu: string;
}
export interface LichTrucNgay {
  maLichTruc: number;
  maNhanVien: number;
  hoTen: string;
  maCa: number;
  maPhong: number;
  ngayTruc: string;
  trangThai: string;
  ghiChu: string;
}
