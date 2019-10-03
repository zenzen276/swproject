package com.dowsoft.swproject.model.dto;

import java.io.Serializable;
import com.dowsoft.swproject.types.AudioType;
import com.dowsoft.swproject.types.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class AudioDto implements Serializable {

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "The audio id")
	@JsonProperty
	private Long id;
	@ApiModelProperty(value = "The title of the audio")
	@JsonProperty
	private String title;
	@ApiModelProperty(value = "The duration of the audio")
	@JsonProperty
	private String duration;
	@ApiModelProperty(value = "The author")
	@JsonProperty
	private String author;
	@ApiModelProperty(value = "The type of the audio")
	@JsonProperty
	private AudioType audioType;
	@ApiModelProperty(value = "The artists featuring on the audio")
	@JsonProperty
	private String featuring;
	@ApiModelProperty(value = "The genre of the audio")
	@JsonProperty
	private Genre genre;
	@ApiModelProperty(value = "The cover url of the audio")
	@JsonProperty
	private String imageUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public AudioType getAudioType() {
		return audioType;
	}

	public void setAudioType(AudioType audioType) {
		this.audioType = audioType;
	}

	public String getFeaturing() {
		return featuring;
	}

	public void setFeaturing(String featuring) {
		this.featuring = featuring;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "AudioDto [id=" + id + ", title=" + title + ", duration=" + duration + ", author=" + author
				+ ", audioType=" + audioType + ", featuring=" + featuring + ", genre=" + genre + ", imageUrl="
				+ imageUrl + "]";
	}

}
