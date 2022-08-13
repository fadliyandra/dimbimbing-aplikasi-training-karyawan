package com.dibimbing1.dibimbing1.project.karyawan.mybatis.controller;


import com.dibimbing1.dibimbing1.project.karyawan.model.Karyawan;
import com.dibimbing1.dibimbing1.project.karyawan.mybatis.model.KaryawanMybatis;
import com.dibimbing1.dibimbing1.project.karyawan.mybatis.service.KaryawanServiceMybatis;
import com.dibimbing1.dibimbing1.project.karyawan.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/sp/karyawan")
public class KaryawanControllerMybatis {
    @Autowired
    KaryawanServiceMybatis karyawanServiceMybatis;
    @Autowired
    TemplateResponse templateResponse;

    @PostMapping("/save")
    public ResponseEntity<Map> save(@RequestBody Karyawan objModel) {
        Map map = karyawanServiceMybatis.insertProcedure(objModel.getNama(),
                objModel.getJk(),
                objModel.getDob(),
                objModel.getAlamat(),
                objModel.getStatus());
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Map> update(@RequestBody Karyawan objModel) {
        Map map = karyawanServiceMybatis.updateProcedure(
                objModel.getId(),
                objModel.getNama(),
                objModel.getJk(),
                objModel.getDob(),
                objModel.getAlamat(),
                objModel.getStatus());
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable(value = "id") Long id) {
        Map map = karyawanServiceMybatis.deleteProcedure(id);
        return new ResponseEntity<Map>(templateResponse.templateSukses("Deleted ID : " + id),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map> getById(@PathVariable(value = "id") Integer id) {
        KaryawanMybatis obj = karyawanServiceMybatis.getKaryawanById(id);
        return new ResponseEntity<Map>(templateResponse.templateSukses(templateResponse.conversiToKaryawan(obj)), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Map> getById(@RequestParam(required = true) String nama) {
        List<KaryawanMybatis> list = karyawanServiceMybatis.getKaryawanByName("%"+nama+"%");
        return new ResponseEntity<Map>(templateResponse.templateSukses(templateResponse.conversiToKaryawan(list)), new HttpHeaders(), HttpStatus.OK);
    }

}
