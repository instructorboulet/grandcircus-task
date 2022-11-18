package co.grandcircus.grandcircus.controller.webapi.enums;

import java.util.HashMap;
import java.util.Map;

public enum Search {

	ALL(1), TASK(2), USER(3), PRIORITY(4), STATUS(5), END_DATE(6), END_DATE_GREATER_THAN(7), END_DATE_LESS_THAN(8),
	COMPLETE(9), COMPLETE_GREATER_THAN(10), COMPLETE_LESS_THAN(11);

	private int value;

	Search(int value) {
		this.value = value;
	}

	private static Map<Integer, Search> map = new HashMap<>();

	static {
		for (Search currentRow : Search.values()) {
			map.put(currentRow.value, currentRow);
		}
	}

	public static Search valueOf(int value) {
		return map.get(value);
	}

	public int getValue() {
		return this.value;
	}

}
