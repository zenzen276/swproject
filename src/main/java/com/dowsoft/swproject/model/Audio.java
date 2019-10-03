package com.dowsoft.swproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dowsoft.swproject.types.AudioType;
import com.dowsoft.swproject.types.Genre;

@Entity
@Table
public class Audio {
	
	@Id
	private Long id;
	private String title;
	private String duration;
	private String author;
	
	@Column(name = "audiotype", length=45)
	@Enumerated(EnumType.STRING)
	private AudioType audioType;	
	 
	private String featuring;	
	
	@Column(name="genre", length=45)
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@Column(name="audio_url")
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
	
}
