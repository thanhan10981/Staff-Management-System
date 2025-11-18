package com.example.staffmanagementsystem.repository;

import com.example.staffmanagementsystem.entity.LichTrucNgay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LichTrucNgayRepository extends JpaRepository<LichTrucNgay, Integer> {

    List<LichTrucNgay> findByNhanVien_MaNhanVien(Integer id);

    List<LichTrucNgay> findByNhanVien_MaNhanVienAndNgayTrucBetween(Integer id, LocalDate start, LocalDate end);
}
