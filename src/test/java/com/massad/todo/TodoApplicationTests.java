package com.massad.todo;

import com.massad.todo.domaine.Tache;
import com.massad.todo.repository.TacheRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class TodoApplicationTests {

	@Autowired
	private TacheRepository tacheRepository;

	@Test
	void findTache_byTitre() {
		Tache tache = new Tache();
		tache.setTitre("tacheX");
		tache.setActivated(true);
		tache.setMessage("message test");
		tacheRepository.save(tache);
		Tache tache1 = tacheRepository.findByTitre(tache.getTitre());
		assertThat(tache1.getTitre()).isEqualTo(tache.getTitre());
	}

}
