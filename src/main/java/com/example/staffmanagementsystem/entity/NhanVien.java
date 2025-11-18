package com.example.staffmanagementsystem.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "NhanVien")

public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNhanVien")
    private Integer maNhanVien;

    @Column(name = "HoTen")
    private String tenNhanVien;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "Email")
    private String email;

    @Column(name = "TrangThai")
    private String trangThai;

    @ManyToOne
    @JoinColumn(name = "MaViTri")
    private ViTriCongViec viTriCongViec;

    @ManyToOne
    @JoinColumn(name = "MaPhongBan")
    private PhongBan phongBan;

    @ManyToOne
    @JoinColumn(name = "MaKhoa")
    private Khoa khoa;

    @Column(name = "CCCD")
    private String cccd;

    @Column(name = "NgayVaoLam")
    private LocalDate ngayVaoLam;

    @Column(name = "TrinhDoChuyenMon")
    private String trinhDoChuyenMon;

    @Column(name = "LienHeKhanCap")
    private String lienHeKhanCap;

    @Column(name = "SDTLienHeKhanCap")
    private String sdtLienHeKhanCap;

    // Lưu đường dẫn hoặc tên file
    @Column(name = "AnhDaiDien")
    private String anhDaiDien;

    @Column(name = "HopDongFile")
    private String hopDongFile;
}
