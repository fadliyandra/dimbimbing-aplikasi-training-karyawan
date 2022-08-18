package com.dibimbing1.dibimbing1.project.karyawan.model;


import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "training")
@Where(clause = "deleted_date is null")
public class Training extends AbstractDate implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tema", length = 100)
    private String tema;

    @Column(name = "pengajar")
    private String pengajar;

//    @OneToMany(mappedBy = "training")
//    private List<KaryawanTraining> karyawanTrainingList;
}
