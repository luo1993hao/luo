package com.luo.controller;

import com.luo.common.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.luo.model.StationHistoryData;
import com.luo.service.HistoryDataService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 历史数据controller
 *
 * @author luohaoyu
 * @since 2018-12-04 20:02
 **/
@RestController
@Api(tags = "历史数据", description = "历史数据查询")
@RequestMapping(value = "/manage/data")
public class HistoryDataController {
    @Autowired
    private HistoryDataService historyDataService;

    @ApiOperation(value = "获取历史数据(测试接口默认分页。得到前10行)")
    @GetMapping(value = "/history")
    public HttpResult getHistoryData(@RequestParam String stationId,
                                     @RequestParam int areaCode,
                                     @RequestParam int sensorCode,
                                     @RequestParam String startTime,
                                     @RequestParam String endTime) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("stationId", stationId);
        paramMap.put("areaCode", areaCode);
        paramMap.put("sensorCode", sensorCode);
        paramMap.put("startTime", startTime);
        paramMap.put("endTime", endTime);
        List<StationHistoryData> resultList = historyDataService.getList(paramMap);
        Map<String, Object> result = new HashMap<>();
        if (CollectionUtils.isEmpty(resultList)) {
            result.put("data", new ArrayList<>());
            result.put("total", 0);
        } else {
            result.put("data", resultList.subList(0, 10));
            result.put("total", resultList.size());

        }
        return HttpResult.success(result);

    }
}
