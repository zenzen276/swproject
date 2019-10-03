package com.dowsoft.swproject.repo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.dowsoft.swproject.abstraction.AbstractRepoTest;
import com.dowsoft.swproject.model.Audio;
import com.dowsoft.swproject.types.AudioType;
import com.dowsoft.swproject.types.Genre;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class AudioRepoTest extends AbstractRepoTest {
	
	@Autowired
	AudioRepository audioRepository;

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "clear_tables.sql")
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "insert_audio.sql")
	public void createAudioTest() {
		
		Audio audio = new Audio();		
		audio.setId(11L);
		audio.setAudioType(AudioType.VINYL);
		audio.setAuthor("King Crimson");
		audio.setGenre(Genre.PROG);
		audio.setTitle("Lizard");
		audio.setDuration("60 minutes");
		audio.setFeaturing("Greg Lake, Bill Bruford, Jon Anderson");
		audio.setImageUrl("https://m.media-amazon.com/images/I/81k5ig-1axL._SS500_.jpg");
		audioRepository.save(audio);		
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "clear_tables.sql")
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "insert_audio.sql")
	public void searchAudioByIdTest() {
		
		Audio audio = audioRepository.findAudioById(8L);
		assertNotNull(audio);
		assertEquals("Nursery Cryme", audio.getTitle());
		assertEquals("Genesis", audio.getAuthor());
		assertEquals(AudioType.TAPE, audio.getAudioType());
		assertEquals(Genre.PROG, audio.getGenre());		
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "clear_tables.sql")
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "insert_audio.sql")
	public void searchAudioByAudioTest() {
		
		Audio audio = new Audio();		
		audio.setId(11L);
		audio.setAudioType(AudioType.VINYL);
		audio.setAuthor("King Crimson");
		audio.setGenre(Genre.PROG);
		audio.setTitle("Lizard");
		audio.setDuration("60 minutes");
		audio.setFeaturing("Greg Lake, Bill Bruford, Jon Anderson");
		Audio retrievedAudio = audioRepository.findAudioByAudio(audio);
		assertNull(retrievedAudio);
		audio.setId(10L);
		audio.setAudioType(AudioType.CD);
		audio.setFeaturing("Lake, Bruford,Fripp");
		retrievedAudio = audioRepository.findAudioByAudio(audio);
		assertNotNull(retrievedAudio);
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "clear_tables.sql")
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "insert_audio.sql")
	public void deleteAudioByIdTest() {
		
		List<Audio> audios = (List<Audio>)audioRepository.findAll();
		assertEquals(10, audios.size());
		audioRepository.deleteById(8L);
		audios = (List<Audio>)audioRepository.findAll();
		assertEquals(9, audios.size());
		Audio retrievedAudio = audioRepository.findAudioById(8L);
		assertNull(retrievedAudio);
	
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "clear_tables.sql")
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "insert_audio.sql")
	public void getAllAudiosTest() {
		
		List<Audio> audios = (List<Audio>)audioRepository.findAll();
		assertEquals(10, audios.size());
	}

}
