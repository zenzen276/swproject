package com.dowsoft.swproject.services;

import java.util.List;

import com.dowsoft.swproject.model.dto.AudioDto;

public interface AudioService {

	public boolean addAudio(AudioDto audioDto);

	public boolean deleteAudioById(Long id);

	public List<AudioDto> findAllAudios();

	public AudioDto findAudioById(Long id);	
	
	public AudioDto updateAudio(AudioDto audioDto);	

}
