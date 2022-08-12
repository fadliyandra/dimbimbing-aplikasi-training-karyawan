package com.dibimbing1.dibimbing1.project.karyawan.service;

import com.dibimbing1.dibimbing1.project.karyawan.model.Karyawan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface KaryawanService {
    public Map insert(Karyawan karyawan);
    public Map update(Karyawan karyawan);
    public Map delete(Long karyawan);
    public Map getAll(int size, int page);

    public Map getById(Karyawan karyawan);
}

