package util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.*;


/**
 * 导入excel
 * Created by likaifeng on 2018/4/2.
 */
@Slf4j
public class ExcelImportUtil {

    /**
     * 识别后缀名
     */
    private final static String excel2003L = ".xls";
    private final static String excel2007U = ".xlsx";


//    /**
//     * 将流中的Excel数据转成 List<T>
//     * @param excelFile     文件对象
//     * @param mapping           表中列名与对象成员名的映射
//     * @param clazz             要解析成的class对象
//     */
//    public static <T> List<T> parseExcel(MultipartFile excelFile, Map<String, String> mapping, Class<T> clazz) throws Exception {
//        InputStream inputStream = excelFile.getInputStream();
//        String filename = excelFile.getOriginalFilename();
//        return parseExcel(inputStream, filename, mapping, clazz);
//    }

    /**
     * 将流中的Excel数据转成List<>
     *
     * @param in       输入流
     * @param fileName 带后缀名的文件名（判断Excel版本）
     * @param mapping  对象字段名-表头列名 对应关系
     * @return
     * @throws Exception
     */
    public static <T> List<T> parseExcel(InputStream in, String fileName, Map<String, String> mapping, Class<T> clazz) throws Exception {
        // 根据文件名来创建Excel工作薄
        Workbook work = getWorkbook(in, fileName);
        // 返回数据
        List<T> dataList = new ArrayList<>();

        // 遍历Excel中所有的sheet
        Sheet sheet = work.getSheetAt(0);
        if (sheet == null) {
            return Collections.emptyList();
        }
        // 取第一行标题
        Row headRow = sheet.getRow(0);
        if (headRow == null) {
            throw new RuntimeException("no sheet head");
        }
        short headLength = headRow.getLastCellNum();
        String[] column = new String[headLength];
        for (int y = headRow.getFirstCellNum(); y < headLength + 1; y++) {
            Cell cell = headRow.getCell(y);
            if (cell != null) {
                column[y] = cell.getStringCellValue();
            }
        }
        // 遍历当前sheet中的所有行
        for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
            Row row = sheet.getRow(j);
            //行不为空
            if (row == null) {
                continue;
            }
            JSONObject jsonData = new JSONObject();
            // 遍历所有的列
            short firstCellNum = row.getFirstCellNum();
            short lastCellNum = row.getLastCellNum();
            for (int y = firstCellNum; y < lastCellNum; y++) {
                Cell cell = row.getCell(y);
                //判断单元格内容是否为空
                String field = mapping.get(column[y]);
                jsonData.put(field, getCellValue(cell));

            }
            dataList.add(jsonData.toJavaObject(clazz));
        }
        return dataList;
    }

    /**
     * 描述：根据文件后缀，自适应上传文件的版本
     *
     * @param inStr ,fileName
     * @return
     * @throws Exception
     */
    private static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (excel2003L.equals(fileType)) {
            wb = new HSSFWorkbook(inStr);
        } else if (excel2007U.equals(fileType)) {
            wb = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    /**
     * 描述：对表格中数值进行格式化
     *
     * @param cell
     * @return
     */
    private static Object getCellValue(Cell cell) {
        Object value = null;
        if (cell != null) {
            switch (cell.getCellType()) {
                case STRING:
                    value = cell.getRichStringCellValue().getString();
                    break;
                case NUMERIC:
                    boolean isDate = HSSFDateUtil.isCellDateFormatted(cell);
                    if (isDate) {
                        Date dateCellValue = cell.getDateCellValue();
                        value = DateTimeUtil.parseDateToStr(dateCellValue);
                    } else {
                        value = cell.getNumericCellValue();
                    }
                    break;
                case BOOLEAN:
                    value = cell.getBooleanCellValue();
                    break;
                case BLANK:
                    value = "";
                    break;
                default:
                    break;
            }
        }
        return value;
    }


}
