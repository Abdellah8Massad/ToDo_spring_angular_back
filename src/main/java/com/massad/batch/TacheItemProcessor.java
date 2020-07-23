package com.massad.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.massad.todo.domaine.Tache;

@Component
public class TacheItemProcessor implements ItemProcessor<Tache,Tache> {

	@Override
	public Tache process(Tache item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

}
