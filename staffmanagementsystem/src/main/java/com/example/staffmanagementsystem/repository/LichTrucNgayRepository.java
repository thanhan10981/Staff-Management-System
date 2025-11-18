package com.example.staffmanagementsystem.repository;

import com.example.staffmanagementsystem.entity.LichTrucNgay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface LichTrucNgayRepository extends JpaRepository<LichTrucNgay, Integer> {
    List<LichTrucNgay> findByNgayTrucBetween(LocalDate start, LocalDate end);

    @Query("select l from LichTrucNgay l where l.maNhanVien = :empId and l.ngayTruc = :date")
    List<LichTrucNgay> findByEmpAndDate(Integer empId, LocalDate date);

    @Query("select l from LichTrucNgay l where l.maPhong = :phongId and l.ngayTruc = :date and l.maCa = :maCa")
    List<LichTrucNgay> findByPhongDateCa(Integer phongId, LocalDate date, Integer maCa);
}
