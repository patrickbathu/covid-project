package com.patrickbathu.covidbatch.scheduler;

import com.patrickbathu.covidbatch.services.CovidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@Slf4j
public class CovidScheduler {

    @Autowired
    private CovidService covidService;

    @Scheduled(cron = "0 0/1 * * * *")
    public void covidUpdate() {
        log.info("CovidScheduler - start");
        covidService.getCountryDayOneRoute();
        log.info("CovidScheduler - end");
    }

}
