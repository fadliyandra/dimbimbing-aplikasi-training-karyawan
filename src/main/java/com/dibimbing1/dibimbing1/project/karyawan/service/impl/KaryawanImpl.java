package com.dibimbing1.dibimbing1.project.karyawan.service.impl;

import com.dibimbing1.dibimbing1.project.karyawan.model.Karyawan;
import com.dibimbing1.dibimbing1.project.karyawan.service.KaryawanService;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class KaryawanImpl implements KaryawanService {
    static List<Karyawan> listKaryawan = new ArrayList<>();
    static int idIncrement = 0;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date;

    @Override
    public Karyawan save(Karyawan obj) {
        date = new Date();
        obj.setId(idIncrement++);
        obj.setUpdated_date(null);
        obj.setCreated_date(dateFormat.format(date.getTime()));
        listKaryawan.add(obj);
        return obj;
    }

    @Override
    public Karyawan update(Karyawan obj) {
        for(Karyawan data: listKaryawan) {
            if(obj.getId() == data.getId()) {
                date = new Date();
                Karyawan update = new Karyawan();
                update.setId(obj.getId());
                update.setName(obj.getName());
                update.setJk(obj.getJk());
                update.setDob(obj.getDob());
                update.setAlamat(obj.getAlamat());
                update.setStatus(obj.getStatus());
                update.setCreated_date(obj.getCreated_date());
                update.setUpdated_date(dateFormat.format(date.getTime()));
                listKaryawan.remove(data);
                listKaryawan.add(update);
                return update;
            }
        }
        return null;
    }

    @Override
    public List<Karyawan> deleted(Long id) {
        for (Karyawan data: listKaryawan) {
            if (id == data.getId()) {
                Karyawan update = new Karyawan();
                update.setId(data.getId());
                update.setName(data.getName());
                update.setJk(data.getJk());
                update.setDob(data.getDob());
                update.setAlamat(data.getAlamat());
                update.setStatus(data.getStatus());
                update.setCreated_date(data.getCreated_date());
                update.setUpdated_date(data.getUpdated_date());
                listKaryawan.remove(data);
                return listKaryawan;
            }
        }
        return null;
    }

    @Override
    public List<Karyawan> dataKaryawan(int row, int page) {
        return listKaryawan;
    }

    @Override
    public Karyawan findById(long id) {
        for(Karyawan data: listKaryawan) {
            if (id == data.getId()) {
                return data;
            }
        }
        return null;
    }
}
