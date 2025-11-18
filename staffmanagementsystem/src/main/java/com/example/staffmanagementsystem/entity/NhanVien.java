package com.example.staffmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "NhanVien")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNhanVien")
    private Integer maNhanVien;

    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "NgaySinh")
    private java.time.LocalDate ngaySinh;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "Email")
    private String email;

    @Column(name = "MaViTri")
    private Integer maViTri;

    @Column(name = "MaPhongBan")
    private Integer maPhongBan;

    @Column(name = "MaKhoa")
    private Integer maKhoa;

    @Column(name = "TrangThai")
    private String trangThai;
}
