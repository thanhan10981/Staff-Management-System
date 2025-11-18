package com.example.staffmanagementsystem.repository;

import com.example.staffmanagementsystem.entity.PhanCongCaTruc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PhanCongCaTrucRepository extends JpaRepository<PhanCongCaTruc, Integer> {

    List<PhanCongCaTruc> findByNhanVien_MaNhanVien(Integer maNV);

    @Query("SELECT pc FROM PhanCongCaTruc pc WHERE pc.nhanVien.maNhanVien = :id AND pc.ngayBatDau <= :date AND pc.ngayKetThuc >= :date")
    List<PhanCongCaTruc> findLichTrongTuan(@Param("id") Integer id, @Param("date") LocalDate date);
}
