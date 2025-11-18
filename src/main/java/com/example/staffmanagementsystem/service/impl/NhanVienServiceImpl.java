package com.example.staffmanagementsystem.service.impl;

import com.example.staffmanagementsystem.dto.NhanVienDTO;
import com.example.staffmanagementsystem.entity.NhanVien;
import com.example.staffmanagementsystem.mapper.NhanVienMapper;
import com.example.staffmanagementsystem.repository.KhoaRepository;
import com.example.staffmanagementsystem.repository.NhanVienRepository;
import com.example.staffmanagementsystem.repository.PhongBanRepository;
import com.example.staffmanagementsystem.repository.ViTriCongViecRepository;
import com.example.staffmanagementsystem.service.NhanVienService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository repo;
    private final ViTriCongViecRepository viTriRepo;
    private final PhongBanRepository phongBanRepo;
    private final KhoaRepository khoaRepo;
    private final NhanVienMapper mapper;

    @Override
    public List<NhanVienDTO> getAll() {
        return repo.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public NhanVienDTO getById(Integer id) {
        return repo.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public NhanVienDTO create(NhanVienDTO dto) {

        NhanVien nv = new NhanVien();
        nv.setTenNhanVien(dto.getTenNhanVien());
        nv.setNgaySinh(dto.getNgaySinh());
        nv.setGioiTinh(dto.getGioiTinh());
        nv.setEmail(dto.getEmail());
        nv.setSdt(dto.getSdt());
        nv.setTrangThai(dto.getTrangThai());

        nv.setViTriCongViec(viTriRepo.findById(dto.getMaViTri()).orElse(null));
        nv.setPhongBan(phongBanRepo.findById(dto.getMaPhongBan()).orElse(null));
        nv.setKhoa(khoaRepo.findById(dto.getMaKhoa()).orElse(null));
        nv.setCccd(dto.getCccd());
        nv.setNgayVaoLam(dto.getNgayVaoLam());
        nv.setTrinhDoChuyenMon(dto.getTrinhDoChuyenMon());
        return mapper.toDto(
                repo.save(nv));
    }

    @Override
    public NhanVienDTO update(Integer id, NhanVienDTO dto) {

        NhanVien nv = repo.findById(id).orElseThrow();

        nv.setTenNhanVien(dto.getTenNhanVien());
        nv.setNgaySinh(dto.getNgaySinh());
        nv.setGioiTinh(dto.getGioiTinh());
        nv.setSdt(dto.getSdt());
        nv.setEmail(dto.getEmail());
        nv.setTrangThai(dto.getTrangThai());

        nv.setViTriCongViec(viTriRepo.findById(dto.getMaViTri()).orElse(null));
        nv.setPhongBan(phongBanRepo.findById(dto.getMaPhongBan()).orElse(null));
        nv.setKhoa(khoaRepo.findById(dto.getMaKhoa()).orElse(null));

        nv.setCccd(dto.getCccd());
        nv.setNgayVaoLam(dto.getNgayVaoLam());
        nv.setTrinhDoChuyenMon(dto.getTrinhDoChuyenMon());
        nv.setLienHeKhanCap(dto.getLienHeKhanCap());
        nv.setSdtLienHeKhanCap(dto.getSdtLienHeKhanCap());

        nv.setAnhDaiDien(dto.getAnhDaiDien());
        nv.setHopDongFile(dto.getHopDongFile());
        return mapper.toDto(repo.save(nv));
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
