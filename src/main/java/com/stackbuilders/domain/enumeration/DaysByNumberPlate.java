
package com.stackbuilders.domain.enumeration;
import java.util.*;

public enum DaysByNumberPlate {
	Monday (Arrays.asList( 1,2)),
	Thuesday(Arrays.asList( 1,2));
	
	public final List<Integer> values;

	private DaysByNumberPlate(List<Integer> values) {
		this.values = values;
	}
	
	

}
