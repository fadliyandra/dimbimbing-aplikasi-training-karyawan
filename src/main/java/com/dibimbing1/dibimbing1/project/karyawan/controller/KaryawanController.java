package com.dibimbing1.dibimbing1.project.karyawan.controller;


import com.dibimbing1.dibimbing1.project.karyawan.model.Karyawan;
import com.dibimbing1.dibimbing1.project.karyawan.service.KaryawanService;
import com.dibimbing1.dibimbing1.project.karyawan.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/karyawan/")
public class KaryawanController {
    @Autowired
    public KaryawanService karyawanService;
    @Autowired
    public TemplateResponse templateResponse;


    @PostMapping("/add")
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map> save(@Valid @RequestBody Karyawan objModel) {
        Map obj = karyawanService.insert(objModel);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Map>update(@RequestBody Karyawan karyawanId) {
        Map obj = karyawanService.update(karyawanId);
        return new ResponseEntity<Map>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map>delete(@PathVariable(value = "id") Long id) {
        Map obj = karyawanService.delete(id);
        return new ResponseEntity<Map>(obj,HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Map>list(@RequestParam() Integer page, @RequestParam Integer size) {
        Map list = karyawanService.getAll(size,page);
        return new ResponseEntity<Map>(list,new HttpHeaders(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public  ResponseEntity<Map>getById(@PathVariable(value = "id")Karyawan id) {
        Map obj = karyawanService.getById(id);
        return new ResponseEntity<Map>(obj,HttpStatus.OK);
    }
}
