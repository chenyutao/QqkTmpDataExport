import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: chenyutao
 * @date: 2022/2/23 11:06 上午
 */
public class TmpTest {
    @Test
    public void test() {
        String[] lines = hhh.split("\n");
        List<String> names = new LinkedList<>();
        for (String line : lines) {
            String tmpStr1 = line.substring(0, line.indexOf(":"));
            String tmpStr2 = tmpStr1.substring(tmpStr1.lastIndexOf(" ")+1);
            names.add(tmpStr2);
        }
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println(names);
    }

    String hhh = " realName: realName, //姓名\n" +
            "                nation: nation, //民族\n" +
            "                idCard: idCard, //身份证号\n" +
            "                phone: phone, //手机号\n" +
            "                householdProvinceId: householdProvinceId, //省份id-户籍\n" +
            "                householdCityId: householdCityId, //市id-户籍\n" +
            "                householdCountyId: householdCountyId, //县id-户籍\n" +
            "                householdTownId: householdTownId, //乡/镇id-户籍\n" +
            "                householdVillageId: householdVillageId, //行政村id-户籍\n" +
            "                householdAddress: householdAddress, //详细地址-户籍\n" +
            "                education: education, //文化程度\n" +
            "                politicalType: politicalType, //政治面貌\n" +
            "                memberType: memberType, //类别（1-返乡农民工，返乡大学生，复退军人，下乡职工，下乡科技人员，在乡就业，在家务农，灵活就业，在乡创业，在外就业，其他（在外周商、在外周才））\n" +
            "                headHousehold: headHousehold, //是否户主\n" +
            "                relationHeadHousehold: relationHeadHousehold, //与户主关系\n" +
            "                economicStatus: economicStatus, //脱贫状态\n" +
            "                healthStatus: healthStatus, //健康状况\n" +
            "                businessStatus: isWorking, //是否就（创）业\n" +
            "                businessChannel: businessChannel, //就（创）业途径\n" +
            "                businessProvinceId: businessProvinceId, //就（创）业地\n" +
            "                businessCountyId: businessCountyId, //市id-就（创）业地\n" +
            "                businessCityId: businessCityId, //县id-就（创）业地\n" +
            "                businessAddress: businessAddress, //就（创）业详细地址\n" +
            "                companyName: companyName, //单位名称\n" +
            "                workBusinessDate: workBusinessDate, //就（创）业日期\n" +
            "                industry: industry, //从事行业\n" +
            "                homeServiceStatus: isWaiter, //是否为家庭服务业从业人员\n" +
            "                workType: workType, //从业类型\n" +
            "                receiveTrainStatus: isTrained, //是否接受培训\n" +
            "                contractStatus: getRadioRes('getContract'), //是否签订合同\n" +
            "                laborChannel: laborChannel, //输出渠道\n" +
            "                workSkills: workSkills, //劳动技能\n" +
            "                monthIncome: monthIncome, //月收入（元）\n" +
            "                notWorkReason: notWorkReason, //未就业原因\n" +
            "                trainedStatus: getRadioRes('trained'), //是否参加过培训\n" +
            "                trainedType: trainedType, //培训类型\n" +
            "                trainedCertificate: isGetCertificate, //是否取得培训证书\n" +
            "                trainedCertificateCount: trainedCertificateCount, //所得证书份数\n" +
            "                trainedWorkStatus: getRadioRes('work'), //培训后:\n" +
            "                noWorkPlanReason: \"无\", //无就业、培训原因\n" +
            "                trainPlanStatus: isTrainHope, //是否有培训意愿\n" +
            "                trainPlan: trainPlan, //培训意向\n" +
            "                returnHometownDate: returnHometownDate, //返乡日期\n" +
            "                planGoOutDate: planGoOutDate, //拟外出日期\n" +
            "                nextWorkPlan: nextWorkPlan //下一步就业意愿\n";
}
