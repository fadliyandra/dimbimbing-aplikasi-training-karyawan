package com.dibimbing1.dibimbing1.project.karyawan.repository;


import com.dibimbing1.dibimbing1.project.karyawan.model.Karyawan;
import com.dibimbing1.dibimbing1.project.karyawan.model.Training;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TrainingRepository extends PagingAndSortingRepository<Training, Long> {

    @Query("select t from Training t Where t.id = :id")
    public Training getbyID(@Param("id") Long id);

    public Page<Training> findByPengajar (String pengajar, Pageable pageable);

    @Query("select t from Training t")
    public Page<Training> getAllData(Pageable pageable);

    public Page<Karyawan> findByTema(String tema, Pageable show_data);
}
