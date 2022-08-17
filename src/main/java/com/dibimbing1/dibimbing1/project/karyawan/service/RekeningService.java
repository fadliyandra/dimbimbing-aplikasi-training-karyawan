package com.dibimbing1.dibimbing1.project.karyawan.service;



import com.dibimbing1.dibimbing1.project.karyawan.model.Rekening;

import java.util.Map;

public interface RekeningService {

    public Map insert(Rekening rekening, Long idkaryawan);
    public Map update(Rekening rekening, Long idkaryawan);
    public Map delete(Long rekening);
}
