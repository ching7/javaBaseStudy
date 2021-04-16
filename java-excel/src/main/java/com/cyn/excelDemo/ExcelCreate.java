package com.cyn.excelDemo;

import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author chenyanan
 * @date 2021/4/15
 * Created by chenyanan on 2021/4/15
 */
public class ExcelCreate {
    public static void main(String[] args) throws IOException {
        // 创建workbook
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        // 样式居中
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);

        // 创建sheet
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("sheet");
        // 单元格合并
        hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
        // row行
        HSSFRow row = hssfSheet.createRow(0);
        // cell
        HSSFCell cell = row.createCell((short) 0);
        // 文本内容
        cell.setCellStyle(cellStyle);
        cell.setCellValue("角色操作权限列表");
        // row行
        HSSFRow row1 = hssfSheet.createRow(1);
        hssfSheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));
        // cell
        HSSFCell cell1 = row1.createCell((short) 0);
        // cell1.setCellStyle(cellStyle);
        // 文本内容
        cell1.setCellValue("角色编号：123，角色名称：开发");
        FileOutputStream out = new FileOutputStream("/Users/chenyanan/Desktop/test.xls");
        hssfWorkbook.write(out);
        out.flush();
    }
}
