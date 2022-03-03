package converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.StringUtils;

import java.math.BigDecimal;

/**
 * @author: chenyutao
 * @date: 2022/2/25 3:51 下午
 */
public class WorkBusinessDateConverter implements Converter<String> {
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
        ReadCellData<?> readCellData = context.getReadCellData();
        String cellStr = "2021.3";
        if(readCellData.getNumberValue()!=null){
            cellStr = readCellData.getNumberValue().toString();
        }
        if(readCellData.getStringValue()!=null){
            cellStr = readCellData.getStringValue();
        }
        if (StringUtils.isEmpty(cellStr)) {
            return null;
        }
        String[] strs = cellStr.split("\\.");
        StringBuilder builder= new StringBuilder();
        builder.append(strs[0]).append("-");
        if(strs[1].length()==1){
            builder.append("0");
        }
        builder.append(strs[1]);
        return builder.toString();
    }


    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) throws Exception {
        return null;
    }
}
