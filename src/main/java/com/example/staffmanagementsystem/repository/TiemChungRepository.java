package com.example.staffmanagementsystem.repository;

import com.example.staffmanagementsystem.entity.TiemChung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TiemChungRepository extends JpaRepository<TiemChung, Integer> {

    List<TiemChung> findByNhanVien_MaNhanVien(Integer maNhanVien);
}
