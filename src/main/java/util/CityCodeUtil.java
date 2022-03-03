package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import entity.CityEntryDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: chenyutao
 * @date: 2022/3/2 6:03 下午
 */
public class CityCodeUtil {

    private static List<CityEntryDTO> cityRoots;

    public static List<String> cityPathToCityList(String cityPath) {
        if (cityRoots == null) {
            try {
                init();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        List<CityEntryDTO> pathCityList = new ArrayList<>();
        String tmpPath=cityPath;
        List<CityEntryDTO> tmpCityList = cityRoots;
        for (int i = 0; i < 3; i++) {
            if(tmpCityList.size()==1){
                CityEntryDTO tmpRootCity = tmpCityList.get(0);
                pathCityList.add(tmpRootCity);
                tmpCityList = tmpRootCity.getChildren();
                continue;
            }
            for (CityEntryDTO tmpRootCity : tmpCityList) {
                boolean hit = tmpPath.startsWith(tmpRootCity.getCityName());
                if (hit) {
                    pathCityList.add(tmpRootCity);
                    tmpPath = tmpPath.substring(tmpRootCity.getCityName().length());
                    tmpCityList = tmpRootCity.getChildren();
                    break;
                }
            }
        }
        List<String> cityCodes = new ArrayList<>();
        for (CityEntryDTO cityEntryDTO : pathCityList) {
            cityCodes.add(cityEntryDTO.getCityCode());
        }
        return cityCodes;
    }


    private static synchronized void init() throws Exception {
        if (cityRoots != null) {
            return;
        }
//        InputStream path = CityCodeUtil.class.getResourceAsStream("page/city.data.json2");
        InputStream path = new FileInputStream(new File("/Users/chenyutao/GitHubProjects/QqkTmpDataExport/src/main/resources/page/city.data.json2"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(path));
        String jsonStr = reader.readLine();
        JSONArray jsonArray = JSON.parseArray(jsonStr);
        cityRoots = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject entry = jsonArray.getJSONObject(i);
            CityEntryDTO cityCodeDTO = entry.toJavaObject(CityEntryDTO.class);
            cityRoots.add(cityCodeDTO);
        }
    }

}
