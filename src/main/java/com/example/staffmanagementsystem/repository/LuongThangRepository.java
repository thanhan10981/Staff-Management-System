package com.example.staffmanagementsystem.repository;

import com.example.staffmanagementsystem.entity.LuongThang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface LuongThangRepository extends JpaRepository<LuongThang, Integer> {

    // Lấy lương tháng gần nhất của 1 nhân viên
    @Query("SELECT l FROM LuongThang l WHERE l.nhanVien.maNhanVien = :maNV ORDER BY l.nam DESC, l.thang DESC")
    List<LuongThang> getLatestByNhanVien(@Param("maNV") Integer maNV);
}
