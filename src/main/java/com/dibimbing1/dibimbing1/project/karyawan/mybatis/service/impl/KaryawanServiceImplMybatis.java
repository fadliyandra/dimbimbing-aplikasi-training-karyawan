package com.dibimbing1.dibimbing1.project.karyawan.mybatis.service.impl;

//import com.dibimbing.latihanspringboot.model.Karyawan;
//import com.dibimbing.latihanspringboot.mybatis.model.KaryawanMybatis;
//import com.dibimbing.latihanspringboot.mybatis.repository.KaryawanRepoMybatis;
//import com.dibimbing.latihanspringboot.mybatis.service.KaryawanServiceMybatis;
//import com.dibimbing.latihanspringboot.utils.QuerySP;
//import com.dibimbing.latihanspringboot.utils.TemplateResponse;
import com.dibimbing1.dibimbing1.project.karyawan.model.Karyawan;
import com.dibimbing1.dibimbing1.project.karyawan.mybatis.model.KaryawanMybatis;
import com.dibimbing1.dibimbing1.project.karyawan.mybatis.repository.KaryawanRepoMybatis;
import com.dibimbing1.dibimbing1.project.karyawan.mybatis.service.KaryawanServiceMybatis;
import com.dibimbing1.dibimbing1.project.karyawan.utils.QuerySP;
import com.dibimbing1.dibimbing1.project.karyawan.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KaryawanServiceImplMybatis implements KaryawanServiceMybatis {

    @Autowired
    KaryawanRepoMybatis karyawanRepoMybatis;
    @Autowired
    TemplateResponse templateResponse;
    @Autowired
    QuerySP querySP;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map insertProcedure(String rqnama, String rqjk, Date rqdob, String rqalamat, String rqstatus) {

        jdbcTemplate.execute(querySP.saveKaryawan);
        Map<String, Object> map = new HashMap<>();
        map.put("rqnama",rqnama);
        map.put("rqjk",rqjk);
        map.put("rqdob",rqdob);
        map.put("rqalamat",rqalamat);
        map.put("rqstatus",rqstatus);
        map.put("resid",null);
        map.put("resnama",null);
        map.put("resjk",null);
        map.put("resdob",null);
        map.put("resalamat",null);
        map.put("resstatus",null);
        map.put("reserordesc",null);
        map.put("reserorcode",null);

        karyawanRepoMybatis.insertProcedure(map);

        System.out.println("resid = " + map.get("resid"));
        System.out.println("resnama = " + map.get("resnama"));
        System.out.println("resjk = " + map.get("resjk"));
        System.out.println("resdob = " + map.get("resdob"));
        System.out.println("resalamat = " + map.get("resalamat"));
        System.out.println("resstatus = " + map.get("resstatus"));
        System.out.println("reserordesc = " + map.get("reserordesc"));
        System.out.println("reserorcode = " + map.get("reserorcode"));


        Karyawan objKaryawan = new Karyawan();
        objKaryawan.setId((Long) map.get("resid"));
        objKaryawan.setNama((String) map.get("resnama"));
        objKaryawan.setJk((String) map.get("resjk"));
        objKaryawan.setDob((Date) map.get("resdob"));
        objKaryawan.setAlamat((String) map.get("resalamat"));
        objKaryawan.setStatus((String) map.get("resstatus"));
        return templateResponse.templateSukses(objKaryawan,(String) map.get("reserordesc"),String.valueOf(map.get("reserorcode")));
    }

    @Override
    public Map updateProcedure(Long rqid, String rqnama, String rqjk, Date rqdob, String rqalamat, String rqstatus) {
        jdbcTemplate.execute(querySP.updateKaryawan);
        Map<String, Object> map = new HashMap<>();
        map.put("rqid",rqid);
        map.put("rqnama",rqnama);
        map.put("rqjk",rqjk);
        map.put("rqdob",rqdob);
        map.put("rqalamat",rqalamat);
        map.put("rqstatus",rqstatus);
        map.put("resid",null);
        map.put("resnama",null);
        map.put("resjk",null);
        map.put("resdob",null);
        map.put("resalamat",null);
        map.put("resstatus",null);
        map.put("reserordesc",null);
        map.put("reserorcode",null);

        karyawanRepoMybatis.updateProcedure(map);

        System.out.println("resid = " + map.get("resid"));
        System.out.println("resnama = " + map.get("resnama"));
        System.out.println("resjk = " + map.get("resjk"));
        System.out.println("resdob = " + map.get("resdob"));
        System.out.println("resalamat = " + map.get("resalamat"));
        System.out.println("resstatus = " + map.get("resstatus"));
        System.out.println("reserordesc = " + map.get("reserordesc"));
        System.out.println("reserorcode = " + map.get("reserorcode"));


        Karyawan objKaryawan = new Karyawan();
        objKaryawan.setId((Long) map.get("resid"));
        objKaryawan.setNama((String) map.get("resnama"));
        objKaryawan.setJk((String) map.get("resjk"));
        objKaryawan.setDob((Date) map.get("resdob"));
        objKaryawan.setAlamat((String) map.get("resalamat"));
        objKaryawan.setStatus((String) map.get("resstatus"));
        return templateResponse.templateSukses(objKaryawan,(String) map.get("reserordesc"),String.valueOf(map.get("reserorcode")));
    }


    @Override
    public Map deleteProcedure(Long rqid) {

        jdbcTemplate.execute(querySP.deleteKaryawan);
        Map<String, Object> map = new HashMap<>();
        map.put("resid",rqid);

        System.out.println("resid = " + map.get("resid") + "  deleted");

        karyawanRepoMybatis.deleteProcedure(rqid);
        return null;
    }

    @Override
    public KaryawanMybatis getKaryawanById(int rqid) {
        return karyawanRepoMybatis.getKaryawanById(rqid);
    }

    @Override
    public List<KaryawanMybatis> getKaryawanByName(String rqnama) {
        return karyawanRepoMybatis.getKaryawanByName(rqnama);
    }


}
