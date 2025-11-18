package com.example.staffmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "LichTrucNgay")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LichTrucNgay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLichTruc;

    @ManyToOne
    @JoinColumn(name = "MaNhanVien")
    private NhanVien nhanVien;

    private Integer maCa;
    private Integer maPhong;

    private LocalDate ngayTruc;

    private String trangThai;
    private String ghiChu;
}
