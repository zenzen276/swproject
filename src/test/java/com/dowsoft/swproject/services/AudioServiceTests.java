package com.dowsoft.swproject.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.dowsoft.swproject.abstraction.AbstractRepoTest;
import com.dowsoft.swproject.model.dto.AudioDto;
import com.dowsoft.swproject.types.AudioType;
import com.dowsoft.swproject.types.Genre;


@RunWith(SpringRunner.class)
@SpringBootTest()
public class AudioServiceTests extends AbstractRepoTest{
	
	@Autowired
	AudioService audioService;
	
	@Before
	public void initialise(){
		  modelMapper();
	}
	
	@Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "clear_tables.sql")
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "insert_audio.sql")
	public void addAudiotest() {		
		
		List<AudioDto> audioDtos =  audioService.findAllAudios();
		assertEquals(10L, audioDtos.size());
		
		AudioDto audioDto = new AudioDto();
		audioDto.setId(11L);
		audioDto.setAudioType(AudioType.CD);
		audioDto.setAuthor("Titanic");
		audioDto.setTitle("Eagle Rock");
		audioDto.setDuration("70 minute");
		audioDto.setGenre(Genre.PROG);
		audioDto.setFeaturing("");
		audioDto.setImageUrl("https://m.media-amazon.com/images/I/81sChYu7gEL._SS500_.jpg");
		audioService.addAudio(audioDto);
		
		audioDtos =  audioService.findAllAudios();
		assertEquals(11L, audioDtos.size());
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "clear_tables.sql")
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "insert_audio.sql")
	public void searchAudioByIdtest() {	
		
		 AudioDto audioDto = audioService.findAudioById(8L);
		 assertNotNull(audioDto);		 
		 assertEquals("Genesis", audioDto.getAuthor());
		 assertEquals("Nursery Cryme", audioDto.getTitle());
		 assertEquals(Genre.PROG, audioDto.getGenre());
		 assertEquals(AudioType.TAPE, audioDto.getAudioType());
		 
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "clear_tables.sql")
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "insert_audio.sql")
	public void deleteAudioByIdtest() {	
		
		 AudioDto audioDto = audioService.findAudioById(8L);
		 assertNotNull(audioDto);	
		 audioService.deleteAudioById(8L);
		 audioDto = audioService.findAudioById(8L);
		 assertNull(audioDto);		 
	}
	
	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "clear_tables.sql")
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = sqlpath +  "insert_audio.sql")
	public void testUpdateUser() {
		
		AudioDto audioDto = audioService.findAudioById(8L);
		audioDto.setGenre(Genre.ROCK);
		audioService.updateAudio(audioDto);
		AudioDto updatedAudioDto = audioService.findAudioById(8L);
		assertEquals(Genre.ROCK, updatedAudioDto.getGenre());
	}



}
