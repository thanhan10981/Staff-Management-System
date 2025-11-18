package com.example.staffmanagementsystem.repository;

import com.example.staffmanagementsystem.entity.ChungChi;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChungChiRepository extends JpaRepository<ChungChi, Integer> {

    List<ChungChi> findByNhanVien_MaNhanVien(Integer maNhanVien);
}
