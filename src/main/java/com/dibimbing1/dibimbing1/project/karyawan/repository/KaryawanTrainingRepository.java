package com.dibimbing1.dibimbing1.project.karyawan.repository;


import com.dibimbing1.dibimbing1.project.karyawan.model.KaryawanTraining;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface KaryawanTrainingRepository extends PagingAndSortingRepository<KaryawanTraining, Long> {

    @Query("select c from KaryawanTraining c Where c.id = :id")
    public KaryawanTraining getbyID(@Param("id") Long id);

//    public Page<KaryawanTraining> findByNamaKaryawan (String nama, Pageable pageable);
//
//    public Page<KaryawanTraining> findByTemaTraining (String tema, Pageable pageable);

    @Query("select c from KaryawanTraining c")
    public Page<KaryawanTraining> getAllData(Pageable pageable);

}
