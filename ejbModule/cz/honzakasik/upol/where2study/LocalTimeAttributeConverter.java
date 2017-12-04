package cz.honzakasik.upol.where2study;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**Converter to persist LocalDate and LocalDateTime with 
 * JPA 2.1 and Hibernate older than 5.0 version**/

@Converter(autoApply = true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time>{

    @Override
    public Time convertToDatabaseColumn(LocalTime localTime) {
        return (localTime == null ? null : Time.valueOf(localTime));
    }

    @Override
    public LocalTime convertToEntityAttribute(Time time) {
    	final Calendar timeCal = Calendar.getInstance();
    	timeCal.setTime(time);
        return (time == null ? null : LocalTime.of(timeCal.get(Calendar.HOUR_OF_DAY), timeCal.get(Calendar.MINUTE))); 
    }
}
