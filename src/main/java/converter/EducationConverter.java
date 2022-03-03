package converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.StringUtils;

/**
 * @author: chenyutao
 * @date: 2022/2/25 3:51 下午
 */
public class EducationConverter  implements Converter<String> {
    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public String convertToJavaData(ReadConverterContext<?> context) throws Exception {
        //CellData转对象属性
        String cellStr = context.getReadCellData().getStringValue();
        if (StringUtils.isEmpty(cellStr)) {
            return null;
        }
        switch (cellStr) {
            case "小学":
                return "10";
            case "初中":
                return "9";
            case "普通高中":
                return "8";
            case "技工学校":
                return "7";
            case "职业高中":
                return "6";
            case "中等专科":
                return "5";
            case "大学专科":
            case "大专":
                return "4";
            case "大学本科":
                return "3";
            case "硕士研究生":
                return "2";
            case "博士研究生":
                return "1";
            case "其他":
                return "11";
        }
        return null;
    }


    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) throws Exception {
        return null;
    }
}
