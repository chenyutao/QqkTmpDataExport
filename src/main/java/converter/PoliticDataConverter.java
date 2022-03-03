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
public class PoliticDataConverter implements Converter<String> {
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
            case "群众":
                return "13";
            case "中共党员":
                return "1";
            case "中共预备党员":
                return "2";
            case "共青团员":
                return "3";
            case "无党派民主人士":
                return "12";
            // todo
        }
        return null;
    }


    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) throws Exception {
        return null;
    }
}
