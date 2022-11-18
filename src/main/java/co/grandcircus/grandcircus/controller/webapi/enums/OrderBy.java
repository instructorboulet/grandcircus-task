package co.grandcircus.grandcircus.controller.webapi.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderBy {
	
	USER_NAME(1), PRIORITY(2), START_DATE(3),
	END_DATE(4), COMPLETE(5), 
	
	USER_NAME_REVERSE(-1), PRIORITY_REVERSE(-2), START_DATE_REVERSE(-3),
	END_DATE_REVERSE(-4), COMPLETE_REVERSE(-5);

	private final int value;

	OrderBy(int value) {
		this.value = value;
	}
	
    private static Map<Integer, OrderBy> map = new HashMap<>();
    
    static {
        for (var currentRow : OrderBy.values()) {
            map.put(currentRow.value, currentRow);
        }
    }    
    
    public static OrderBy valueOf(int value) {
        return map.get(value);
    }
	
	public int getValue() {
		return this.value;
	}	
}
