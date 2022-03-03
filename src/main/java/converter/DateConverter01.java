package converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.StringUtils;

/**
 * @author: chenyutao
 * @date: 2022/2/25 4:23 下午
 */
public class DateConverter01 implements Converter<String> {
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
        String[] strs = cellStr.split("\\/");
        StringBuilder builder = new StringBuilder();
        builder.append("20" + strs[2]);
        for (int i = 0; i < 2; i++) {
            builder.append("-");
            if (strs[i].length() == 1) {
                builder.append("0");
            }
            builder.append(strs[i]);
        }
        return builder.toString();
    }


    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) throws Exception {
        return null;
    }
}
