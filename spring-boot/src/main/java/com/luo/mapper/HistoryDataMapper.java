package com.luo.mapper;


import com.luo.model.StationHistoryData;

import java.util.List;
import java.util.Map;

/**
 * 站点历史数据Maaper
 *
 * @author luohaoyu
 * @since 2018-12-03 20:05
 **/
public interface HistoryDataMapper {
    /**
     * 插入
     */
    boolean insert(StationHistoryData stationHistoryData);

    /**
     * 参数查询列表
     */
    List<StationHistoryData> getList(Map<String, Object> paramMap);
}
