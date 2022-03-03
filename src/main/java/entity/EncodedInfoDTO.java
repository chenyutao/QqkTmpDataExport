package entity;

import com.alibaba.excel.annotation.ExcelProperty;
import converter.*;
import lombok.Data;

/**
 * @author: chenyutao
 * @date: 2022/2/23 2:28 下午
 */
@Data
public class EncodedInfoDTO {

    @ExcelProperty("姓名")
    private String realName;
    @ExcelProperty("身份证号")
    private String idCard;
    @ExcelProperty("手机号")
    private String phone;
    @ExcelProperty("户籍详细地址")
    private String householdAddress;

    @ExcelProperty(value = "民族",converter = NationConverter.class)
    private String nation;
    @ExcelProperty(value = "政治面貌",converter = PoliticDataConverter.class)
    private String politicalType;
    @ExcelProperty(value = "文化程度",converter = EducationConverter.class)
    private String education;
    @ExcelProperty(value = "人员类别",converter = MemberTypeConverter.class)
    private String memberType;
    @ExcelProperty(value = "是否户主",converter = HouseHoldConverter.class)
    private String headHousehold;
    @ExcelProperty(value = "脱贫状态",converter = EconomicStatusConverter.class)
    private String economicStatus;
    @ExcelProperty(value = "健康状态",converter = HealthStatusConverter.class)
    private String healthStatus;

    @ExcelProperty(value = "就创业途径",converter = BusinessChannelConverter.class)
    private String businessChannel;
    @ExcelProperty("单位名称")
    private String companyName;
    @ExcelProperty("工作城市")
    private String businessCityPath;
    @ExcelProperty("工作详细地址")
    private String businessAddress;
    @ExcelProperty(value = "工作开始时间",converter = WorkBusinessDateConverter.class)
    private String workBusinessDate;
    @ExcelProperty(value = "从事行业",converter = IndustryConverter.class)
    private String industry;
    @ExcelProperty(value = "劳动技能",converter = WorkSkillsConverter.class)
    private String workSkills;
    @ExcelProperty("月收入")
    private String monthIncome;
    @ExcelProperty(value = "输出渠道",converter = LaborChannelConverter.class)
    private String laborChannel;

    @ExcelProperty(value = "培训类型",converter = TrainTypeConverter.class)
    private String trainedType;
    @ExcelProperty(value = "下一步就业意愿",converter = NextWorkPlanConverter.class)
    private String nextWorkPlan;

    @ExcelProperty(value = "返乡时间",converter = DateConverter01.class)
    private String returnHometownDate;
    @ExcelProperty(value = "计划离开时间", converter = DateConverter01.class)
    private String planGoOutDate;

}
