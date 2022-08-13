package com.dibimbing1.dibimbing1.project.karyawan.utils;

import org.springframework.stereotype.Component;

@Component
public class QuerySP {
    public String saveKaryawan = "CREATE OR REPLACE PROCEDURE public.savekaryawan" +
            "(IN rqnama varchar,\n" +
            "IN rqjk varchar,\n" +
            "IN rqdob date,\n" +
            "IN rqalamat varchar,\n" +
            "IN rqstatus varchar,\n" +
            "INOUT resid bigint,\n" +
            "INOUT resnama varchar,\n" +
            "INOUT resjk varchar,\n" +
            "INOUT resdob date,\n" +
            "INOUT resalamat varchar,\n" +
            "INOUT resstatus varchar,\n" +
            "INOUT reserordesc varchar,\n" +
            "INOUT reserorcode integer)\n" +
            " LANGUAGE plpgsql\n" +
            "AS $procedure$\n" +
            "\tBEGIN\n" +
            "\n" +
            "\tinsert into public.karyawan\n" +
            "\t(id,nama,jk,dob,alamat,status,created_date,updated_date)\n" +
            "\tselect nextval('karyawan_id_seq') ,\n" +
            "\trqnama,\n" +
            "\trqjk,\n" +
            "\trqdob,\n" +
            "\trqalamat,\n" +
            "\trqstatus,\n" +
            "\tNOW(),\n" +
            "\tNOW()\n" +
            "\treturning id into resid;" +
            "resnama = rqnama;\n"+
            "resjk = rqjk;\n"+
            "resdob = rqdob;\n"+
            "resalamat = rqalamat;\n"+
            "resstatus = rqstatus;\n"+
            "reserordesc = 'sukses';\n" +
            "\treserorcode = 200;\n" +
            "     commit;\n" +
            "\tEND;\n" +
            "$procedure$\n" +
            ";\n";

    public String updateKaryawan = "CREATE OR REPLACE PROCEDURE public.updatekaryawan" +
            "(IN rqid bigint,\n" +
            "IN rqnama varchar,\n" +
            "IN rqjk varchar,\n" +
            "IN rqdob date,\n" +
            "IN rqalamat varchar,\n" +
            "IN rqstatus varchar,\n" +
            "INOUT resid bigint,\n" +
            "INOUT resnama varchar,\n" +
            "INOUT resjk varchar,\n" +
            "INOUT resdob date,\n" +
            "INOUT resalamat varchar,\n" +
            "INOUT resstatus varchar,\n" +
            "INOUT reserordesc varchar,\n" +
            "INOUT reserorcode integer)\n" +
            " LANGUAGE plpgsql\n" +
            "AS $procedure$\n" +
            "\tBEGIN\n" +
            "\n" +
            "\tupdate public.karyawan\n" +
            "\tset nama = rqnama,\n"+
            "\tjk = rqjk,\n" +
            "\tdob = rqdob,\n" +
            "\talamat = rqalamat,\n" +
            "\tstatus = rqstatus,\n" +
            "\tupdated_date  = NOW()\n" +
            "\twhere id = rqid\n" +
            "\treturning id into resid;\n" +
            "resnama = rqnama;\n"+
            "resjk = rqjk;\n"+
            "resdob = rqdob;\n"+
            "resalamat = rqalamat;\n"+
            "resstatus = rqstatus;\n"+
            "reserordesc = 'sukses';\n" +
            "\treserorcode = 200;\n" +
            "commit;\n" +
            "\tEND;\n" +
            "$procedure$\n" +
            ";\n";

    public String deleteKaryawan = "CREATE OR REPLACE PROCEDURE public.deletekaryawan(INOUT rqid bigint)\n" +
            "\tLANGUAGE plpgsql\n" +
            "AS $procedure$\n" +
            "\tBEGIN\n" +
            "\t\tdelete from public.karyawan where id = rqid;\n" +
            "\tcommit;\n" +
            "\tEND;\n" +
            "$procedure$\n" +
            ";\n";

    public String getKaryawanById = "CREATE OR REPLACE FUNCTION public.getkaryawan(INOUT rqid bigint)\n" +
            " RETURNS TABLE(resid bigint," +
            " resnama character varying," +
            " resjk character varying," +
            " resdob date," +
            " resalamat character varying," +
            " resstatus character varying)\n" +
            " LANGUAGE plpgsql\n" +
            "AS $function$\n" +
            "\tBEGIN\n" +
            "\n" +
            "\t\treturn query\n" +
            "\t\t\tselect id,nama,jk,dob,alamat,status \n" +
            "\t\t\tfrom public.karyawan\n" +
            "\t\t\twhere id = rqid;\n" +
            "\tEND;\n" +
            "$function$\n" +
            ";\n";

    public String getKaryawanByName = "CREATE OR REPLACE FUNCTION public.getlistkaryawan(rqnama character varying)\n" +
            " RETURNS TABLE(resid bigint,\n" +
            " resnama character varying,\n" +
            " resjk character varying,\n" +
            " resdob date,\n" +
            " resalamat text,\n" +
            " resstatus character varying)\n" +
            " LANGUAGE plpgsql\n" +
            "AS $function$\n" +
            "\tBEGIN\n" +
            "\t\treturn query\n" +
            "\t\t\tselect id,nama,jk,dob,alamat,status \n" +
            "\t\t\tfrom public.karyawan\n" +
            "\t\t\twhere nama ilike rqnama;\n" +
            "\tEND;\n" +
            "$function$\n" +
            ";\n";
}
