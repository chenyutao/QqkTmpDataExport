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
public class NextWorkPlanConverter implements Converter<String> {
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
            case "返岗":
                return "1";
            case "外出再就业":
                return "2";
            case "本地就业":
                return "3";
            case "本地创业":
                return "4";
            case "外出创业":
                return "5";
        }
        return null;
    }


    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) throws Exception {
        return null;
    }
}
