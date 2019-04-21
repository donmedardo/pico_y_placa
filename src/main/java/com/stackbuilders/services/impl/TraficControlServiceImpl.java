package com.stackbuilders.services.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stackbuilders.services.TraficControlService;

public class TraficControlServiceImpl  implements TraficControlService{
	
	public static LocalTime START_PICO_PLACA_MORNING = LocalTime.parse("07:00");
	public static LocalTime END_PICO_PLACA_MORNING = LocalTime.parse("09:30");
	public static LocalTime START_PICO_PLACA_AFTERNOON = LocalTime.parse("16:30");
	public static LocalTime END_PICO_PLACA_AFTERNOON = LocalTime.parse("19:00");
	
	@Override
	public boolean predictPicoPlaca(String plate, String date, String hour ){
		
		String lastDigitAsString = plate.substring(plate.length() - 1);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
		//convert String to LocalDate
		LocalDate a = LocalDate.parse(date, formatter);

		DayOfWeek dayIn= a.getDayOfWeek();
		DayOfWeek picoYPlacaDay= keys(getRules(),Integer.valueOf(lastDigitAsString));
		LocalTime time =LocalTime.parse(hour);
//		System.out.println(dayIn);
//		System.out.println(picoYPlacaDay);
//		System.out.println(START_PICO_PLACA_MORNING);
//		System.out.println(END_PICO_PLACA_MORNING);
//		System.out.println(START_PICO_PLACA_AFTERNOON);
//		System.out.println(END_PICO_PLACA_AFTERNOON);
		boolean isPosibleMorning= isOpen(START_PICO_PLACA_MORNING,END_PICO_PLACA_MORNING,time);
		boolean isPosiblefternoon= isOpen(START_PICO_PLACA_AFTERNOON,END_PICO_PLACA_AFTERNOON,time);
		return !(dayIn.equals(picoYPlacaDay) && (isPosibleMorning || isPosiblefternoon)) ;
	}

	public static boolean isOpen(LocalTime start, LocalTime end, LocalTime time) {
		  if (start.isAfter(end)) {
		    return !time.isBefore(start) || !time.isAfter(end);
		  } else {
		    return !time.isBefore(start) && !time.isAfter(end);
		  }
		}
	
	public Map<DayOfWeek,List<Integer>>  getRules(){
		Map<DayOfWeek,List<Integer>> days = new HashMap<>();
		
		days.put(DayOfWeek.MONDAY, Arrays.asList(1,2));
		days.put(DayOfWeek.TUESDAY, Arrays.asList(3,4));
		days.put(DayOfWeek.WEDNESDAY, Arrays.asList( 5,6));
		days.put(DayOfWeek.THURSDAY, Arrays.asList(7,8));
		days.put(DayOfWeek.FRIDAY, Arrays.asList(9,0));
		
		return days;
	}
	
	public DayOfWeek keys(Map<DayOfWeek, List<Integer>> map, Integer value) {
		for (Map.Entry<DayOfWeek, List<Integer>> entry : map.entrySet()) {
		    
			if(entry.getValue().stream().anyMatch(a->a.equals(value)))
			return entry.getKey(); 
		}
		
		return null;
	}
}
