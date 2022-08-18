package com.dibimbing1.dibimbing1.project.karyawan.sp.service;



import com.dibimbing1.dibimbing1.project.karyawan.model.KaryawanMybatis;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface KaryawanServiceMybatis {

    KaryawanMybatis selectBlog(Long rqid);

    List<KaryawanMybatis> selectList(String rqnama);

    Map deleteProcedure(Long resid, String reserordesc, Integer reserorcode);

    Map insertProcedure(Long resid, String resnama, String resjk, Date resdob, String resalamat, String resstatus, String reserordesc, Integer reserorcode);

    Map updateProcedure(Long resid, String resnama, String resjk, Date resdob, String resalamat, String resstatus, String reserordesc, Integer reserorcode);

}
