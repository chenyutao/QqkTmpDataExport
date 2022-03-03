import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import entity.CityEntryDTO;
import org.junit.Test;
import util.CityCodeUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: chenyutao
 * @date: 2022/3/2 11:50 上午
 */
public class CityInfoTest {
    @Test
    public void test() throws Exception {
        InputStream path = this.getClass().getResourceAsStream("page/city.data.json2");
        BufferedReader reader = new BufferedReader(new InputStreamReader(path));
        String jsonStr = reader.readLine();
        JSONArray jsonArray = JSON.parseArray(jsonStr);
        List<CityEntryDTO> cityRoots = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject entry = jsonArray.getJSONObject(i);
            CityEntryDTO cityCodeDTO = entry.toJavaObject(CityEntryDTO.class);
            cityRoots.add(cityCodeDTO);
        }
        System.out.println(cityRoots.size());
        System.out.println(cityRoots.get(2));
    }

    @Test
    public void test2() {
        String str = "{\"cityCode\":\"110000\",\"cityName\":\"北京市\",\"children\":[{\"cityCode\":\"110100\",\"cityName\":\"北京市\",\"children\":[{\"cityCode\":\"110101\",\"cityName\":\"东城区\"},{\"cityCode\":\"110102\",\"cityName\":\"西城区\"},{\"cityCode\":\"110103\",\"cityName\":\"崇文区\"},{\"cityCode\":\"110104\",\"cityName\":\"宣武区\"},{\"cityCode\":\"110105\",\"cityName\":\"朝阳区\"},{\"cityCode\":\"110106\",\"cityName\":\"丰台区\"},{\"cityCode\":\"110107\",\"cityName\":\"石景山区\"},{\"cityCode\":\"110108\",\"cityName\":\"海淀区\"},{\"cityCode\":\"110109\",\"cityName\":\"门头沟区\"},{\"cityCode\":\"110111\",\"cityName\":\"房山区\"},{\"cityCode\":\"110112\",\"cityName\":\"通州区\"},{\"cityCode\":\"110113\",\"cityName\":\"顺义区\"},{\"cityCode\":\"110114\",\"cityName\":\"昌平区\"},{\"cityCode\":\"110115\",\"cityName\":\"大兴区\"},{\"cityCode\":\"110116\",\"cityName\":\"怀柔区\"},{\"cityCode\":\"110117\",\"cityName\":\"平谷区\"},{\"cityCode\":\"110228\",\"cityName\":\"密云县\"},{\"cityCode\":\"110229\",\"cityName\":\"延庆县\"},{\"cityCode\":\"110230\",\"cityName\":\"其它区\"}]}]}";
        CityEntryDTO cityEntryDTO = JSON.parseObject(str, CityEntryDTO.class);
        System.out.println(cityEntryDTO);
    }

    @Test
    public void test3() {
        String cityPath = "广西省钦州市钦州区";
        List<String> codes = CityCodeUtil.cityPathToCityList(cityPath);
        System.out.println(codes);
    }

}
