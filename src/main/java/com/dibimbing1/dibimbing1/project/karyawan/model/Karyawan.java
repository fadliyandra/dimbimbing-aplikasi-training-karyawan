package com.dibimbing1.dibimbing1.project.karyawan.model;


import lombok.Data;

@Data
public class Karyawan {
    private long id;
    private String name;
    private String jk;
    private String dob;
    private String alamat;
    private String status;
    private String created_date;
    private String updated_date;
}
