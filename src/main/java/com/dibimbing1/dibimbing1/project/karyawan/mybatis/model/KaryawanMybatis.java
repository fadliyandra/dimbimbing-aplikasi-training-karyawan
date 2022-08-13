package com.dibimbing1.dibimbing1.project.karyawan.mybatis.model;

import lombok.Data;

import java.sql.Date;

@Data
public class KaryawanMybatis {
    Long resid;
    String resnama;
    String resjk;
    Date resdob;
    String resalamat;
    String resstatus;
    String reserordesc;
    Integer reserorcode;
}
