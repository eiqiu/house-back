package com.xinjia.house.configuration;

import com.xinjia.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
    @Autowired
    private HouseService houseService;
    /**
     * 每天凌晨1点执行一次，更新热门房子
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void countHotHouse() {
        houseService.modifyHotHouse();
    }
}
