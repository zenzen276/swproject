package com.dowsoft.swproject.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dowsoft.swproject.model.Audio;
import com.dowsoft.swproject.types.Genre;

@Repository
public interface AudioRepository extends CrudRepository<Audio, Long>{
	
	@Query("from Audio a where a.id=:audioId")
	public Audio findAudioById(@Param("audioId") Long audioId);
	
	@Query("from Audio a where a=:audio")
	public Audio findAudioByAudio(@Param("audio") Audio audio);	
	
	@Query("from Audio a where a.genre=:agendre")
	public Audio findAudioByAudio(@Param("agendre") Genre agenre);	
	
}
