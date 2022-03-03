import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import entity.EncodedInfoDTO;
import entity.PeopleInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.CityCodeUtil;
import util.OkhttpUtil;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: chenyutao
 * @date: 2022/2/25 2:55 下午
 */
@Slf4j
public class MyMain {

    private String filePath = "/Users/chenyutao/Desktop/ProdData_03.xlsx";

    @Test
    public void test() {
        List<PeopleInfoDTO> peopleInfo = EasyExcel.read(filePath)
                .head(PeopleInfoDTO.class)
                .sheet()
                .doReadSync();

        List<EncodedInfoDTO> encodedInfoList = EasyExcel.read(filePath)
                .head(EncodedInfoDTO.class)
                .sheet()
                .doReadSync();

        System.out.println("totalSize: "+ peopleInfo.size());
//        System.out.println(encodedInfoList);
        AtomicInteger successCount = new AtomicInteger();
        AtomicInteger failCount = new AtomicInteger();
        for (int i = 0; i < encodedInfoList.size(); i++) {
            EncodedInfoDTO entity = encodedInfoList.get(i);
            if(!StringUtils.isBlank(entity.getIdCard())){
                boolean bool = sendRequest(entity);
                if(bool){
                    successCount.incrementAndGet();
                }else {
                    failCount.incrementAndGet();
                    System.out.println(i);
//                    System.out.println(peopleInfo.get(i));
                }
            }
        }
        System.out.println("failCount:" +failCount);
        System.out.println("successCount:" +successCount);

    }

    private static String targetUrl = "https://api.zkyjr.ssnyjt.com:4430/api/member/add";

    private boolean sendRequest(EncodedInfoDTO entity) {
        JSONObject json = buildRequest(entity);
        String response = OkhttpUtil.post(targetUrl, json.toJSONString());
//        System.out.println("  ");
//        System.out.println("req: " + entity.toString());
//        System.out.println("res: " + response);
        if(response.contains("你已登记过")|| response.contains("200")){
            return true;
        }else {
            return false;
        }

    }

    private JSONObject buildRequest(EncodedInfoDTO entity) {
        JSONObject json = JSON.parseObject(JSON.toJSONString(entity));
        String cityPath = entity.getBusinessCityPath();
        List<String> cityCodes = CityCodeUtil.cityPathToCityList(cityPath);
        if(cityCodes.size()<3){
            System.out.println("err: "+cityPath);
        }
        json.putIfAbsent("businessProvinceId", cityCodes.get(0));
        json.putIfAbsent("businessCountyId", cityCodes.get(1));
        json.putIfAbsent("businessCityId", cityCodes.get(2));

        json.putIfAbsent("householdProvinceId", "410000");
        json.putIfAbsent("householdCityId", "411600");
        json.putIfAbsent("householdCountyId", "411681");
        json.putIfAbsent("householdTownId", "411681100");
        json.putIfAbsent("householdVillageId", "411681100210");
        json.putIfAbsent("nation", "1");
        json.putIfAbsent("education", "10");
        json.putIfAbsent("politicalType", "13");
        json.putIfAbsent("memberType", "1");
        json.putIfAbsent("headHousehold", 0);
        json.putIfAbsent("relationHeadHousehold", "101");
        json.putIfAbsent("economicStatus", 0);
        json.putIfAbsent("healthStatus", 0);
        json.putIfAbsent("businessStatus", 1);
        json.putIfAbsent("businessChannel", 0);
        json.putIfAbsent("businessProvinceId", "410000");
        json.putIfAbsent("businessCountyId", "411600");
        json.putIfAbsent("businessCityId", "411681");
        json.putIfAbsent("industry", 0);
        json.putIfAbsent("homeServiceStatus", 0);
        json.putIfAbsent("workType", 0);
        json.putIfAbsent("receiveTrainStatus", 1);
        json.putIfAbsent("contractStatus", 1);
        json.putIfAbsent("laborChannel", 0);
        json.putIfAbsent("workSkills", 0);
        json.putIfAbsent("notWorkReason", 0);
        json.putIfAbsent("trainedStatus", 1);
        json.putIfAbsent("trainedType", 0);
        json.putIfAbsent("trainedCertificate", 1);
        json.putIfAbsent("trainedCertificateCount", "0");
        json.putIfAbsent("trainedWorkStatus", 1);
        json.putIfAbsent("noWorkPlanReason", "无");
        json.putIfAbsent("trainPlanStatus", 1);
        json.putIfAbsent("trainPlan", 0);
        json.putIfAbsent("nextWorkPlan", 0);
//        System.out.println(json);
        return json;
    }
}
