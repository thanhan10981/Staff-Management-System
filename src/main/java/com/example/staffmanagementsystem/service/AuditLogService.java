package com.example.staffmanagementsystem.service;

import com.example.staffmanagementsystem.dto.AuditLogDTO;

import java.util.List;

public interface AuditLogService {
    List<AuditLogDTO> getLogsByEmployee(Integer maNV);
}
