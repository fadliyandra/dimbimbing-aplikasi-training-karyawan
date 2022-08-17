package com.dibimbing1.dibimbing1.project.karyawan.sp.controller;



import com.dibimbing1.dibimbing1.project.karyawan.model.Karyawan;
import com.dibimbing1.dibimbing1.project.karyawan.model.KaryawanMybatis;
import com.dibimbing1.dibimbing1.project.karyawan.sp.service.KaryawanServiceMybatis;
import com.dibimbing1.dibimbing1.project.karyawan.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/sp/karyawan")
public class KaryawanControllerMybatis {

    @Autowired
    public KaryawanServiceMybatis karyawanServiceMybatis;

    @Autowired
    private TemplateResponse templateResponse;

    @PostMapping("/save")
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map> save(@Valid @RequestBody Karyawan kryModel){
        Map kry = karyawanServiceMybatis.insertProcedure(kryModel.getId(), kryModel.getNama(), kryModel.getJk(), kryModel.getDob(), kryModel.getAlamat(), kryModel.getStatus(), null,null);
        return new ResponseEntity<>(kry, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Map> update(@Valid @RequestBody Karyawan kryModel){
        Map kry = karyawanServiceMybatis.updateProcedure(kryModel.getId(), kryModel.getNama(), kryModel.getJk(), kryModel.getDob(), kryModel.getAlamat(), kryModel.getStatus(), null,null);
        return new ResponseEntity<>(kry, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable(value = "id") Long resid){
        Map kry = karyawanServiceMybatis.deleteProcedure(resid, "Ok",200);
        return new ResponseEntity<>(kry, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Map> listByNama(@RequestParam(required = false) String nama){
        List<KaryawanMybatis> list = karyawanServiceMybatis.selectList("%"+nama+"%");
        return new ResponseEntity<>(templateResponse.templateSukses(templateResponse.conversiToKaryawan(list)), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map> listById(@PathVariable(value = "id") Long id) {
        KaryawanMybatis obj = karyawanServiceMybatis.selectBlog(id);
        return new ResponseEntity<>(templateResponse.templateSukses(templateResponse.conversiToKaryawan(obj)), HttpStatus.OK);
    }



}
