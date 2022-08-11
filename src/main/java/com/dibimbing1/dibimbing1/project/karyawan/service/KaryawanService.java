package com.dibimbing1.dibimbing1.project.karyawan.service;

import com.dibimbing1.dibimbing1.project.karyawan.model.Karyawan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KaryawanService {
    public Karyawan save(Karyawan obj);
    public Karyawan update(Karyawan obj);
    public List<Karyawan> deleted(Long id);
    public List<Karyawan> dataKaryawan(int row,int page);
    public Karyawan findById(long id);
}
