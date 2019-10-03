package com.dowsoft.swproject.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dowsoft.swproject.model.Audio;
import com.dowsoft.swproject.model.dto.AudioDto;
import com.dowsoft.swproject.repo.AudioRepository;
@Service
public class AudioServiceImpl implements AudioService {
	
	@Autowired
	AudioRepository audioRepository;

	@Autowired
	private ModelMapper modelMapper;

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public boolean addAudio(AudioDto audioDto) {

		if (audioDto != null) {
			Audio audio = convertToEntity(audioDto);
			audioRepository.save(audio);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAudioById(Long id) {
		
		if(id != null){
			audioRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<AudioDto> findAllAudios() {
		
		List<AudioDto> audioDtos = new ArrayList<>();
		List<Audio>audios = (List<Audio>) audioRepository.findAll();
		
		if(audios != null){
			for(Audio audio: audios){
				audioDtos.add(convertToDto(audio));
			}
		}
		return audioDtos;
	}

	@Override
	public AudioDto findAudioById(Long id) {
		
		if(id != null){
			Audio audio = audioRepository.findAudioById(id);
			
			if(audio != null){
				AudioDto audioDto = convertToDto(audio);
				return audioDto;
			}			
		}
		return null;
	}
	
	private AudioDto convertToDto(Audio audio) {
		AudioDto audioDto = modelMapper.map(audio, AudioDto.class);
		return audioDto;
	}

	private Audio convertToEntity(AudioDto audioDto) {

		Audio audio = modelMapper.map(audioDto, Audio.class);
		return audio;
	}

	@Override
	public AudioDto updateAudio(AudioDto audioDto) {
		
		if (audioDto != null) {			
			Audio savedAudio = audioRepository.findAudioById(audioDto.getId());
			
			if (savedAudio != null) {
				savedAudio = convertToEntity(audioDto);
				audioRepository.save(savedAudio);
				return audioDto;
			}
		}
		return null;
	}
	
	

}
