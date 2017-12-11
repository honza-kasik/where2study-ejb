package cz.honzakasik.upol.where2study.schedule;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import cz.honzakasik.upol.where2study.LocalTimeAttributeConverter;
import cz.honzakasik.upol.where2study.services.LocalTimeAdapter;

/**
 * Event from room's schedule
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Event{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	@Convert(converter = LocalTimeAttributeConverter.class)
	@XmlElement
    @XmlJavaTypeAdapter(value = LocalTimeAdapter.class)
	private LocalTime startTime;
	
	@Column
	@Convert(converter = LocalTimeAttributeConverter.class)
	@XmlElement
    @XmlJavaTypeAdapter(value = LocalTimeAdapter.class)
	private LocalTime endTime;
	
	@Column
	private int dayOfWeek;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="schedule_id")
	@XmlTransient
	private Schedule schedule;
	
	/**
	 * Create new Event instance
	 * @param startTime start time of event
	 * @param endTime end time of event
	 * @param dayOfWeek day of week on whcih the event takes place
	 */
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
	
	/**
	 * Return true if this event is running now
	 * @param time time of day
	 * @param dayOfWeek day of week
	 * @return true if this event is running in spoecified time frame
	 */
	public boolean isRunningAtTime(LocalTime time, int dayOfWeek) {
		return dayOfWeek == this.dayOfWeek && time.isAfter(startTime) && time.isBefore(endTime);
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;		
	}

	public Schedule getSchedule() {
		return schedule;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", dayOfWeek=" + dayOfWeek
				+ "]";
	}

}
