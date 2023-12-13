package com.sub.scheduler;

import com.sub.configuration.BatchJobConfiguration;
import com.sub.configuration.SubBatchJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableScheduling
public class BatchScheduler {

    private final JobLauncher jobLauncher;
    private final SubBatchJob subBatchJob;
    @Scheduled(cron = "0/10 * * * * ?")
    public void runJob(){

        Map<String, JobParameter> configMap =new HashMap<>();
        configMap.put("runJobTime",new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(configMap);

        try{
            jobLauncher.run(subBatchJob.stepNextJob(), jobParameters);
        } catch (JobInstanceAlreadyCompleteException | JobExecutionAlreadyRunningException | JobParametersInvalidException |JobRestartException  e) {
         log.error(e.getMessage());
         log.info("e오익");
        }


    }

}
