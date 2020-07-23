package com.massad.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.massad.todo.domaine.Tache;
import com.massad.todo.repository.TacheRepository;

@Component
public class TacheItemWriter implements ItemWriter<Tache>{

	@Autowired
	private TacheRepository tacheRepository;
	
	@Override
	public void write(List<? extends Tache> items) throws Exception {
		tacheRepository.saveAll(items);
	}

}
