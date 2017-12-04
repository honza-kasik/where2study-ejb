package cz.honzakasik.upol.where2study.schedule;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import cz.honzakasik.upol.where2study.LocalTimeAttributeConverter;

/**
 * Event from room's schedule
 */
@Entity
public class Event{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Convert(converter = LocalTimeAttributeConverter.class)
	private LocalTime startTime;
	
	@Column
	@Convert(converter = LocalTimeAttributeConverter.class)
	private LocalTime endTime;
	
	@Column
	private int dayOfWeek;
	
	public Event(LocalTime startTime, LocalTime endTime, int dayOfWeek) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.dayOfWeek = dayOfWeek;
	}

	public Event() {
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}
	
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	public boolean isRunningAtTime(LocalTime time, int dayOfWeek) {
		return dayOfWeek == this.dayOfWeek && time.isAfter(startTime) && time.isBefore(endTime);
	}

}
