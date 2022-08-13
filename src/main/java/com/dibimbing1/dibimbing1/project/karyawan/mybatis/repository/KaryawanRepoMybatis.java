package com.dibimbing1.dibimbing1.project.karyawan.mybatis.repository;

//import com.dibimbing.latihanspringboot.mybatis.model.KaryawanMybatis;
import com.dibimbing1.dibimbing1.project.karyawan.mybatis.model.KaryawanMybatis;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

@Mapper
public interface KaryawanRepoMybatis {

    @Insert(value = "call savekaryawan(" +
            "#{rqnama, mode = IN, jdbcType = VARCHAR}," +
            "#{rqjk, mode = IN, jdbcType = VARCHAR}," +
            "#{rqdob, mode = IN, jdbcType = DATE}," +
            "#{rqalamat, mode = IN, jdbcType = VARCHAR}," +
            "#{rqstatus, mode = IN, jdbcType = VARCHAR}," +
            "#{resid, mode = INOUT, jdbcType = BIGINT}," +
            "#{resnama, mode = INOUT, jdbcType = VARCHAR}," +
            "#{resjk, mode = INOUT, jdbcType = VARCHAR}," +
            "#{resdob, mode = INOUT, jdbcType = DATE}," +
            "#{resalamat, mode = INOUT, jdbcType = VARCHAR}," +
            "#{resstatus, mode = INOUT, jdbcType = VARCHAR}," +
            "#{reserordesc, mode = INOUT, jdbcType = VARCHAR}," +
            "#{reserorcode, mode = INOUT, jdbcType = INTEGER})")
    @Options(statementType = StatementType.CALLABLE)
    void insertProcedure(Map<String, Object> map);

    @Update(value = "call updatekaryawan(" +
            "#{rqid, mode = IN, jdbcType = BIGINT}," +
            "#{rqnama, mode = IN, jdbcType = VARCHAR}," +
            "#{rqjk, mode = IN, jdbcType = VARCHAR}," +
            "#{rqdob, mode = IN, jdbcType = DATE}," +
            "#{rqalamat, mode = IN, jdbcType = VARCHAR}," +
            "#{rqstatus, mode = IN, jdbcType = VARCHAR}," +
            "#{resid, mode = INOUT, jdbcType = BIGINT}," +
            "#{resnama, mode = INOUT, jdbcType = VARCHAR}," +
            "#{resjk, mode = INOUT, jdbcType = VARCHAR}," +
            "#{resdob, mode = INOUT, jdbcType = DATE}," +
            "#{resalamat, mode = INOUT, jdbcType = VARCHAR}," +
            "#{resstatus, mode = INOUT, jdbcType = VARCHAR}," +
            "#{reserordesc, mode = INOUT, jdbcType = VARCHAR}," +
            "#{reserorcode, mode = INOUT, jdbcType = INTEGER})")
    @Options(statementType = StatementType.CALLABLE)
    void updateProcedure(Map<String, Object> map);

    @Delete(value = "call deletekaryawan(" +
            "#{rqid, mode = IN, jdbcType = BIGINT})")
    @Options(statementType = StatementType.CALLABLE)
    void deleteProcedure(Long  rqid);

    @Select(value = "SELECT * from getkaryawan(#{rqid})")
    KaryawanMybatis getKaryawanById(int rqid);

    @Select(value = "SELECT * from getlistkaryawan(#{rqnama})")
    List<KaryawanMybatis> getKaryawanByName(String rqnama);
}