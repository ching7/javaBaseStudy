package com.cyn.demo.sqlutils;


/**
 * @Description: <p>
 * 3.1 update语句本身就可以多次执行，因此不用进行特殊处理
 * 3.2 insert语句只需要在insert之前追加delete语句即可
 * delete from t_vehicle_info where VEHICLE_ID = 1763154645;
 * <p>
 * insert into t_th_int_redbook_info (VEHICLE_ID,MAKE_NAME, FAMILY_NAME, DESCRIPTION, UPDATE_TIME)
 * values (1763154645, 'BMW', '430i', 'BMW 430i Coupe M Sport', '11-JUL-17');
 * <p>
 * @Author: ynchen9
 * @CreateTime: 2022-01-25
 */
public class GeneraterPKGUtils {
    public static final String FILE_SPLIT = "_";

    public static void main(String[] args) {

        //调用函数
        System.out.println(generaterModifyColType("create_by", "acd_router_log", "varchar(100)"));
        //生成文件

    }

    public static String generaterModifyColType(String column, String tableName, String type) {
        StringBuffer pkg = new StringBuffer();
        pkg.append("declare\r\n");
        pkg.append("    v_column varchar2(100):='" + column + "';\r\n");
        pkg.append("    v_table varchar2(100):='" + tableName + "';\r\n");
        pkg.append("    v_sql varchar2(2000):='ALTER TABLE " + tableName + " MODIFY " + column + type + "';\r\n");
        pkg.append("    v_cnt number:=0;\r\n");
        pkg.append("begin\r\n");
        pkg.append("    select count(1) into v_cnt from user_tab_columns t where t.TABLE_NAME=v_table and t.COLUMN_NAME=v_column;\r\n");
        pkg.append("    if v_cnt>0 then\r\n");
        pkg.append("       execute immediate v_sql;\r\n");
        pkg.append("    end if;\r\n");
        pkg.append("end;\r\n");
        pkg.append("/\r\n");
        return pkg.toString().toUpperCase();
    }


    public static String generaterRenameColumn(String column, String tableName) {
        StringBuffer pkg = new StringBuffer();
        pkg.append("declare\r\n");
        pkg.append("    v_column varchar2(100):='" + column + "';\r\n");
        pkg.append("    v_table varchar2(100):='" + tableName + "';\r\n");
        pkg.append("    v_sql varchar2(2000):='alter table " + tableName.toUpperCase() + " rename column " + column + " to " + column.replaceAll("Insured", "Holder").toUpperCase() + "';\r\n");
        pkg.append("    v_cnt number:=0;\r\n");
        pkg.append("begin\r\n");
        pkg.append("    select count(1) into v_cnt from user_tab_columns t where t.TABLE_NAME=v_table and t.COLUMN_NAME=v_column ;\r\n");
        pkg.append("    if v_cnt>0 then\r\n");
        pkg.append("       execute immediate v_sql;\r\n");
        pkg.append("    end if;\r\n");
        pkg.append("end;\r\n");
        pkg.append("/\r\n");
        return pkg.toString().toUpperCase();
    }

    public static String generateCreateTable(String tableStr, String tableName) {
        StringBuffer pkg = new StringBuffer();
        pkg.append("declare\r\n");
        pkg.append("    v_table varchar2(100):='" + tableName + "';\r\n");
        pkg.append("    v_sql varchar2(2000):='" + tableStr.trim() + "';\r\n");
        pkg.append("    v_cnt number:=0;\r\n");
        pkg.append("begin\r\n");
        pkg.append("    select count(1) into v_cnt from user_tables t where t.TABLE_NAME=v_table ;\r\n");
        pkg.append("    if v_cnt=0 then\r\n");
        pkg.append("       execute immediate v_sql;\r\n");
        pkg.append("    end if;\r\n");
        pkg.append("end;\r\n");
        pkg.append("/\r\n");
        return pkg.toString().toUpperCase();
    }

    public static String renameColumn(String column, String tableName, String type) {
        StringBuffer pkg = new StringBuffer();
        pkg.append("declare\r\n");
        pkg.append("    v_column varchar2(100):='" + column.trim() + "';\r\n");
        pkg.append("    v_table varchar2(100):='" + tableName.trim() + "';\r\n");
        pkg.append("    v_sql varchar2(2000):='ALTER TABLE " + tableName + " rename column " + column + " to " + type + "';\r\n");
        pkg.append("    v_cnt number:=0;\r\n");
        pkg.append("begin\r\n");
        pkg.append("    select count(1) into v_cnt from user_tab_columns t where t.TABLE_NAME=v_table and t.COLUMN_NAME=v_column  ;\r\n");
        pkg.append("    if v_cnt>0 then\r\n");
        pkg.append("       execute immediate v_sql;\r\n");
        pkg.append("    end if;\r\n");
        pkg.append("end;\r\n");
        pkg.append("/\r\n");
        return pkg.toString().toUpperCase();
    }

    public static String generatePrimaryKey(String column, String tableName, String type, String constraintName) {
        StringBuffer pkg = new StringBuffer();
        pkg.append("declare\r\n");
        pkg.append("    v_column varchar2(100):='" + column.toUpperCase() + "';\r\n");
        pkg.append("    v_table varchar2(100):='" + tableName.toUpperCase() + "';\r\n");
        pkg.append("    v_sql varchar2(2000):='alter table " + tableName.toUpperCase() + " add constraint " + constraintName.toUpperCase() + " primary key (" + column.toUpperCase() + ") ';\r\n");
        pkg.append("    v_cnt number:=0;\r\n");
        pkg.append("begin\r\n");
        pkg.append("    select count(1) into v_cnt from user_constraints t where t.CONSTRAINT_NAME='" + constraintName.toUpperCase() + "' and constraint_type='" + type.toUpperCase() + "' and table_name=v_table ;\r\n");
        pkg.append("    if v_cnt=0 then\r\n");
        pkg.append("       execute immediate v_sql;\r\n");
        pkg.append("    end if;\r\n");
        pkg.append("end;\r\n");
        pkg.append("/\r\n");
        return pkg.toString().toUpperCase();
    }

    public static String createIndex(String column, String tableName, String type, String indexName) {
        StringBuffer pkg = new StringBuffer();
        pkg.append("declare\r\n");
        pkg.append("    v_column varchar2(100):='" + column.toUpperCase() + "';\r\n");
        pkg.append("    v_table varchar2(100):='" + tableName.toUpperCase() + "';\r\n");
        pkg.append("    v_sql varchar2(2000):='create index " + indexName.toUpperCase() + " on " + tableName.toUpperCase() + "(" + column.toUpperCase() + ")';\r\n");
        pkg.append("    v_cnt number:=0;\r\n");
        pkg.append("begin\r\n");
        pkg.append("    select count(1) into v_cnt from user_indexes t where t.INDEX_NAME='" + indexName.toUpperCase() + "' and index_type='" + type.toUpperCase() + "' and table_name=v_table ;\r\n");
        pkg.append("    if v_cnt=0 then\r\n");
        pkg.append("       execute immediate v_sql;\r\n");
        pkg.append("    end if;\r\n");
        pkg.append("end;\r\n");
        pkg.append("/\r\n");
        return pkg.toString().toUpperCase();
    }


    public static String dropColumn(String column, String tableName) {
        StringBuffer pkg = new StringBuffer();
        pkg.append("declare\r\n");
        pkg.append("    v_column varchar2(100):='" + column + "';\r\n");
        pkg.append("    v_table varchar2(100):='" + tableName + "';\r\n");
        pkg.append("    v_sql varchar2(2000):='alter table " + tableName + " drop column " + column + "';\r\n");
        pkg.append("    v_cnt number:=0;\r\n");
        pkg.append("begin\r\n");
        pkg.append("    select count(1) into v_cnt from user_tab_columns t where t.TABLE_NAME=v_table and t.COLUMN_NAME=v_column ;\r\n");
        pkg.append("    if v_cnt>0 then\r\n");
        pkg.append("       execute immediate v_sql;\r\n");
        pkg.append("    end if;\r\n");
        pkg.append("end;\r\n");
        pkg.append("/\r\n");
        return pkg.toString().toUpperCase();
    }

    public static String addComment(String column, String tableName, String comments) {
        StringBuffer pkg = new StringBuffer();
        pkg.append("declare\r\n");
        pkg.append("    v_column varchar2(100):='" + column + "';\r\n");
        pkg.append("    v_table varchar2(100):='" + tableName.toUpperCase() + "';\r\n");
        pkg.append("    v_sql varchar2(2000):='COMMENT ON COLUMN " + tableName + "." + column + " IS ''" + comments + "'''\r\n;");
        pkg.append("    v_cnt number:=0;\r\n");
        pkg.append("begin\r\n");
        pkg.append("    select count(1) into v_cnt from user_tab_columns t where t.TABLE_NAME=v_table and t.COLUMN_NAME=v_column ;\r\n");
        pkg.append("    if v_cnt>0 then\r\n");
        pkg.append("       execute immediate v_sql;\r\n");
        pkg.append("    end if;\r\n");
        pkg.append("end;\r\n");
        pkg.append("/\r\n");
        return pkg.toString().toUpperCase();
    }

    public static String addCommentOnTable(String tableName, String comments) {
        StringBuffer pkg = new StringBuffer();
        pkg.append("declare\r\n");
        pkg.append("    v_table varchar2(100):='" + tableName.toUpperCase() + "';\r\n");
        pkg.append("    v_sql varchar2(2000):='comment on table " + tableName.toUpperCase() + " IS ''" + comments + "'''");
        pkg.append("    v_cnt number:=0;\r\n");
        pkg.append("begin\r\n");
        pkg.append("    select count(1) into v_cnt from user_tab_columns t where t.TABLE_NAME=v_table ;\r\n");
        pkg.append("    if v_cnt>0 then\r\n");
        pkg.append("       execute immediate v_sql;\r\n");
        pkg.append("    end if;\r\n");
        pkg.append("end;\r\n");
        pkg.append("/\r\n");
        return pkg.toString().toUpperCase();
    }

}
