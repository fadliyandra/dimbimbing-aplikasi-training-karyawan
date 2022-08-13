package com.dibimbing1.dibimbing1.project.karyawan.mybatis.service;

//import com.dibimbing.latihanspringboot.mybatis.model.KaryawanMybatis;

import com.dibimbing1.dibimbing1.project.karyawan.mybatis.model.KaryawanMybatis;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface KaryawanServiceMybatis {
    Map insertProcedure(String rqnama, String rqjk, Date rqdob,
                        String rqalamat, String rqstatus);

    Map updateProcedure(Long rqid, String rqnama, String rqjk, Date rqdob,
                        String rqalamat, String rqstatus);

    Map deleteProcedure(Long rqid);

    KaryawanMybatis getKaryawanById(int rqid);

    List<KaryawanMybatis> getKaryawanByName(String rqnama);
}
