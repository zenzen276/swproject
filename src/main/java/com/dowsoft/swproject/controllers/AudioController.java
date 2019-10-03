package com.dowsoft.swproject.controllers;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dowsoft.swproject.model.dto.AudioDto;
import com.dowsoft.swproject.model.dto.UserDto;
import com.dowsoft.swproject.model.rest.RestException;
import com.dowsoft.swproject.services.AudioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "AudioController", description = "operations on " + "audio", hidden = false)
@RequestMapping("/audios")
@RestController
public class AudioController {
	
	private static Logger logger = LogManager.getLogger(AudioController.class);

	private final AudioService audioService;

	@Autowired
	public AudioController(final AudioService audioService) {
		this.audioService = audioService;
	}
	
	@ApiOperation(value = "create new audio", notes = "create new audio", response = AudioDto.class)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "error adding new audio", response = RestException.class) })
	@RequestMapping(value = "/audio", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody boolean addNewAudio(@ApiParam(value = "The user data") @RequestBody AudioDto audioDto)
			throws Exception {

		try {			
			logger.info("Adding new audio", audioDto);
			return audioService.addAudio(audioDto);

		} catch (Exception e) {
			Exception ex = new Exception("Cannot insert audio", e);
			throw ex;
		}
	}
	
	@ApiOperation(value = "Get all audios", notes = "Get all audios", response = UserDto.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Cannot get Audio", response = RestException.class) })
	@RequestMapping(value = "/" + "audio", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AudioDto> getAllUsers() throws Exception {

		try {
			return audioService.findAllAudios();

		} catch (Exception e) {
			Exception ex = new Exception("Cannot get Audio", e);
			throw ex;
		}
	}
	
	@ApiOperation(value = "get audio by id", notes = "get audio by id", response = UserDto.class)
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "cannot get audio details", response = RestException.class) })
	@RequestMapping(value = "/audio" + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AudioDto getAudioById(
			@ApiParam(value = "The id of the audio") @PathVariable("id") String id) {

		if (id != null) {
			return audioService.findAudioById(Long.valueOf(id));
		}
		return null;
	}
	
	@ApiOperation(value = "delete audio by its id", notes = "delete audio by its id", response = Boolean.class)
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "cannot get delete audio", response = RestException.class) })
	@RequestMapping(value = "/audio" + "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean deleteByUserId(
			@ApiParam(value = "The id of the audio") @PathVariable("id") Long id) {

		if (id != null) {
			boolean flag = audioService.deleteAudioById(id); 
			return new Boolean(flag);
		}
		return null;
	}
	
	@ApiOperation(value = "update audio details", notes = "update audio details", response = AudioDto.class)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Cannot update audio", response = RestException.class) })
	@RequestMapping(value = "/audio", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AudioDto updateActivity(@ApiParam(value = "The updated audio data") @RequestBody AudioDto audioDto)
			throws Exception {

		if (audioDto != null) {
			return audioService.updateAudio(audioDto);
		}
		return null;
	}

}
