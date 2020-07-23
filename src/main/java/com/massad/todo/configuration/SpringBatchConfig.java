package com.massad.todo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.massad.todo.domaine.Tache;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	@Autowired private JobBuilderFactory jobBuilderFactory;
	@Autowired private StepBuilderFactory stepBuilderFactory;
	@Autowired private ItemReader<Tache> tacheItemReader;
	@Autowired private ItemWriter<Tache> tacheItemWriter;
	@Autowired private ItemProcessor<Tache,Tache> tacheItemProcessor;
	
	@Bean
	public Job myJob() {
		Step step=stepBuilderFactory.get("ETL-Transaction-File-Load")
				  .<Tache,Tache>chunk(100)
				  .reader(tacheItemReader)
				  .writer(tacheItemWriter)
				  .processor(tacheItemProcessor)
				  .build();
		
		return jobBuilderFactory.get("ETL-Load")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}
	
	@Bean
	public FlatFileItemReader<Tache> getItemReader(@Value("${inputFile}") Resource resource){
		FlatFileItemReader<Tache> flatFileItemReader=new FlatFileItemReader();
		flatFileItemReader.setName("CSV-READER");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}
	
	@Bean
	public LineMapper<Tache> lineMapper(){
		DefaultLineMapper<Tache> lineMapper=new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("titre","description","activated","message");
		lineMapper.setLineTokenizer(lineTokenizer);
		BeanWrapperFieldSetMapper<Tache> fieldSetMapper=new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Tache.class);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}



}
