package com.luo.service;


import com.luo.mapper.HistoryDataMapper;
import com.luo.model.StationHistoryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 站点历史数据实现类
 *
 * @author luohaoyu
 * @since 2018-12-04 14:33
 **/
@Service
public class HistoryDataService {
    private static Logger logger = LoggerFactory.getLogger(HistoryDataService.class);
    @Autowired
    HistoryDataMapper historyDataMapper;

    public boolean insert(StationHistoryData stationHistoryData) {
        return historyDataMapper.insert(stationHistoryData);
    }

    public List<StationHistoryData> getList(Map<String, Object> paramMap) {
        long start = System.currentTimeMillis();
        List<StationHistoryData> result = historyDataMapper.getList(paramMap);
        logger.info("接口直接调用时间为{}", System.currentTimeMillis() - start);
        return result;


    }
}
