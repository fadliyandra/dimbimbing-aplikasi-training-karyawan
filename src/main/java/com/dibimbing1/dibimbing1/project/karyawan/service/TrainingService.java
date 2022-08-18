package com.dibimbing1.dibimbing1.project.karyawan.service;



import com.dibimbing1.dibimbing1.project.karyawan.model.Training;

import java.util.Map;

public interface TrainingService {

    public Map insert(Training training);
    public Map update(Training training);
    public Map findByTema(String tema, Integer page, Integer size);
    public Map findByPengajar(String pengajar, Integer page, Integer size);

    public Map getByID(Long idTraining);
    public Map getAll(int size, int page);

}
