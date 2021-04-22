package com.cyn.excelDemo;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenyanan
 * @date 2021/4/15
 * Created by chenyanan on 2021/4/15
 */
public class ExcelCreate {
    public static void main(String[] args) throws IOException {
        // 创建workbook
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        // 样式居中16号字体
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont font = hssfWorkbook.createFont();
        font.setFontHeightInPoints((short) 16);
        cellStyle.setFont(font);

        // 样式水平垂直居中12号字体
        HSSFCellStyle cellStyle1 = hssfWorkbook.createCellStyle();
        cellStyle1.setAlignment(HorizontalAlignment.CENTER);
        cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFFont font1 = hssfWorkbook.createFont();
        font1.setFontHeightInPoints((short) 12);
        cellStyle1.setFont(font1);

        // 样式居中12号字体灰色背景加边框
        HSSFCellStyle cellStylebg = hssfWorkbook.createCellStyle();
        cellStylebg.setAlignment(HorizontalAlignment.CENTER);
        cellStylebg.setBorderBottom(BorderStyle.THIN);
        cellStylebg.setBorderLeft(BorderStyle.THIN);
        cellStylebg.setBorderTop(BorderStyle.THIN);
        cellStylebg.setBorderRight(BorderStyle.THIN);
        HSSFFont font2 = hssfWorkbook.createFont();
        font2.setFontHeightInPoints((short) 12);
        cellStylebg.setFont(font2);
        cellStylebg.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cellStylebg.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 创建sheet
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("角色操作权限列表");
        hssfSheet.setColumnWidth(0, 30 * 256);
        hssfSheet.setColumnWidth(1, 30 * 256);
        hssfSheet.setColumnWidth(2, 30 * 256);
        hssfSheet.setColumnWidth(3, 30 * 256);

        // 单元格合并
        hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
        // row1行
        HSSFRow row1 = hssfSheet.createRow(0);
        // cell
        HSSFCell cell1 = row1.createCell((short) 0);
        // 文本内容
        cell1.setCellStyle(cellStyle);
        cell1.setCellValue("角色操作权限列表");


        // row2行
        HSSFRow row2 = hssfSheet.createRow(1);
        hssfSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));
        // cell
        HSSFCell cell2 = row2.createCell((short) 0);
        // 文本内容
        cell2.setCellValue("角色编号：123，角色名称：开发");
        cell2.setCellStyle(cellStyle1);

        // row3行
        HSSFRow row3 = hssfSheet.createRow(2);
        // cell列
        HSSFCell cell31 = row3.createCell((short) 0);
        HSSFCell cell32 = row3.createCell((short) 1);
        HSSFCell cell33 = row3.createCell((short) 2);
        HSSFCell cell34 = row3.createCell((short) 3);
        // cell1.setCellStyle(cellStyle);
        // 文本内容
        cell31.setCellValue("菜单编号");
        cell32.setCellValue("菜单名称");
        cell33.setCellValue("功能编号");
        cell34.setCellValue("功能名称");
        cell31.setCellStyle(cellStylebg);
        cell32.setCellStyle(cellStylebg);
        cell33.setCellStyle(cellStylebg);
        cell34.setCellStyle(cellStylebg);
        List<ExcelBean> excelBeans = new ArrayList<>();
        ExcelBean menu = new ExcelBean();
        menu.setCode("kaihu");
        menu.setName("开户");
        List<ExcelBean> funcs = new ArrayList<>();
        ExcelBean func = new ExcelBean();
        func.setCode("pkaihui");
        func.setName("个人开户");
        funcs.add(func);
        ExcelBean func1 = new ExcelBean();
        func1.setCode("skaihui");
        func1.setName("机构开户");
        funcs.add(func1);
        menu.setChild(funcs);
        excelBeans.add(menu);

        ExcelBean menu1 = new ExcelBean();
        menu1.setCode("kaihu2");
        menu1.setName("开户2");
        List<ExcelBean> funcs2 = new ArrayList<>();
        ExcelBean func2 = new ExcelBean();
        func2.setCode("pkaihui2");
        func2.setName("个人开户2");
        funcs2.add(func2);
        ExcelBean func3 = new ExcelBean();
        func3.setCode("skaihui2");
        func3.setName("机构开户2");
        funcs2.add(func3);
        menu1.setChild(funcs2);
        excelBeans.add(menu1);

        ExcelBean menu2 = new ExcelBean();
        menu2.setCode("kaihu2");
        menu2.setName("开户2");
        List<ExcelBean> funcs3 = new ArrayList<>();
        ExcelBean func4 = new ExcelBean();
        func4.setCode("pkaihui2");
        func4.setName("个人开户2");
        funcs3.add(func4);
        menu2.setChild(funcs3);
        excelBeans.add(menu2);
        AtomicInteger initDataRowCount = new AtomicInteger(3);

        excelBeans.forEach(excelBean -> {
            int funcSize = excelBean.getChild().size();
            for (int i = 0; i < funcSize; i++) {
                // 行
                HSSFRow rowList = hssfSheet.createRow(initDataRowCount.get());
                if (i == 0) {
                    // 列 相同不需要合并
                    boolean needMerge = !(initDataRowCount.get() == (initDataRowCount.get() + funcSize - 1));
                    if (needMerge) {
                        hssfSheet.addMergedRegion(new CellRangeAddress(initDataRowCount.get(), initDataRowCount.get() + funcSize - 1, 0, 0));
                        hssfSheet.addMergedRegion(new CellRangeAddress(initDataRowCount.get(), initDataRowCount.get() + funcSize - 1, 1, 1));
                    }
                    HSSFCell cellFor1 = rowList.createCell((short) 0);
                    HSSFCell cellFor2 = rowList.createCell((short) 1);
                    // 文本内容
                    cellFor1.setCellValue(excelBean.getCode());
                    cellFor2.setCellValue(excelBean.getName());
                    cellFor1.setCellStyle(cellStyle1);
                    cellFor2.setCellStyle(cellStyle1);

                }
                HSSFCell cellList2 = rowList.createCell((short) 2);
                cellList2.setCellValue(excelBean.getChild().get(i).getCode());
                cellList2.setCellStyle(cellStyle1);
                HSSFCell cellList3 = rowList.createCell((short) 3);
                cellList3.setCellValue(excelBean.getChild().get(i).getName());
                cellList3.setCellStyle(cellStyle1);
                initDataRowCount.getAndIncrement();
            }
        });

       /* Map<String, List<String>> listMap = new HashMap<>();
        List<String> stringList = new ArrayList<>();
        stringList.add("机构开户");
        stringList.add("个人开户");
        listMap.put("开户", stringList);
        List<String> stringList1 = new ArrayList<>();
        stringList1.add("机构开户123");
        stringList1.add("个人开户123123");
        stringList1.add("个人开户123123r");
        listMap.put("开户2", stringList1);
        AtomicInteger initDataRowCount = new AtomicInteger(3);
        listMap.forEach((mapK, mapV) -> {
            for (int i = 0; i < mapV.size(); i++) {
                // 行
                HSSFRow rowList = hssfSheet.createRow(initDataRowCount.get());
                if (i == 0) {
                    // 列
                    hssfSheet.addMergedRegion(new CellRangeAddress(initDataRowCount.get(), initDataRowCount.get() + mapV.size() - 1, 0, 0));
                    hssfSheet.addMergedRegion(new CellRangeAddress(initDataRowCount.get(), initDataRowCount.get() + mapV.size() - 1, 1, 1));
                    HSSFCell cellFor1 = rowList.createCell((short) 0);
                    HSSFCell cellFor2 = rowList.createCell((short) 1);
                    // 文本内容
                    cellFor1.setCellValue(mapK);
                    cellFor2.setCellValue(mapK);
                    cellFor1.setCellStyle(cellStyle1);
                    cellFor2.setCellStyle(cellStyle1);

                }
                HSSFCell cellList2 = rowList.createCell((short) 2);
                cellList2.setCellValue(mapV.get(i));
                cellList2.setCellStyle(cellStyle1);
                HSSFCell cellList3 = rowList.createCell((short) 3);
                cellList3.setCellValue(mapV.get(i));
                cellList3.setCellStyle(cellStyle1);
                initDataRowCount.getAndIncrement();
            }
        });*/
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String excelFileName = "角色操作权限列表信息" + sdf.format(date) + ".xls";
        FileOutputStream out = new FileOutputStream("/Users/chenyanan/Desktop/" + excelFileName);
        hssfWorkbook.write(out);
        out.flush();
    }
}

class ExcelBean {
    public String name;
    public String code;
    public List<ExcelBean> child;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ExcelBean> getChild() {
        return child;
    }

    public void setChild(List<ExcelBean> child) {
        this.child = child;
    }
}
