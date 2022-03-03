package entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author: chenyutao
 * @date: 2022/2/23 2:28 下午
 */
@Data
public class PeopleInfoDTO {

    @ExcelProperty("姓名")
    private String realName;
    @ExcelProperty("身份证号")
    private String idCard;
    @ExcelProperty("手机号")
    private String phone;
    @ExcelProperty("户籍详细地址")
    private String householdAddress;

    @ExcelProperty("民族")
    private String nation;
    @ExcelProperty("政治面貌")
    private String politicalType;
    @ExcelProperty("文化程度")
    private String education;
    @ExcelProperty("人员类别")
    private String memberType;
    @ExcelProperty("是否户主")
    private String headHousehold;
    @ExcelProperty("脱贫状态")
    private String economicStatus;
    @ExcelProperty("健康状态")
    private String healthStatus;

    @ExcelProperty("就创业途径")
    private String businessChannel;
    @ExcelProperty("单位名称")
    private String companyName;
    @ExcelProperty("工作城市")
    private String businessCityPath;
    @ExcelProperty("工作详细地址")
    private String businessAddress;
    @ExcelProperty("工作开始时间")
    private String workBusinessDate;
    @ExcelProperty("从事行业")
    private String industry;
    @ExcelProperty("劳动技能")
    private String workSkills;
    @ExcelProperty("月收入")
    private String monthIncome;
    @ExcelProperty("输出渠道")
    private String laborChannel;

    @ExcelProperty("培训类型")
    private String trainedType;
    @ExcelProperty("下一步就业意愿")
    private String nextWorkPlan;

    @ExcelProperty("返乡时间")
    private String returnHometownDate;
    @ExcelProperty("计划离开时间")
    private String planGoOutDate;

}
