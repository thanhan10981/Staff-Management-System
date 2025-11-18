package com.example.staffmanagementsystem.repository;

import com.example.staffmanagementsystem.entity.LuongPhuCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LuongPhuCapRepository extends JpaRepository<LuongPhuCap, Integer> {

    List<LuongPhuCap> findByLuongThang_MaLuong(Integer maLuong);
}
