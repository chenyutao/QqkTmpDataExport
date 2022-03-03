package entity;

import lombok.Data;

import java.util.List;

/**
 * @author: chenyutao
 * @date: 2022/3/2 11:49 上午
 */
@Data
public class CityEntryDTO {
    private String cityCode;
    private String cityName;
    private List<CityEntryDTO> children;
}
