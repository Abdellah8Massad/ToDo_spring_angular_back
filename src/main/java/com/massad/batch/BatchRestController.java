package com.massad.batch;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.massad.todo.service.JwtService;

@Controller
public class BatchRestController {
	
	public static final Logger LOGGER = LogManager.getLogger(BatchRestController.class);

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	@GetMapping("/startJob")
	public ResponseEntity<BatchStatus> load() throws Exception {
		Map<String, JobParameter> params=new HashMap<>();
		params.put("time",new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters=new JobParameters(params);
		JobExecution jobExecution=jobLauncher.run(job,jobParameters);
		while(jobExecution.isRunning()) {
			LOGGER.info("Batch running ..........");
		}
		LOGGER.info("Batch finished : {}",jobExecution.getStatus());
		return ResponseEntity.ok(jobExecution.getStatus());
	}
	
}
