package co.grandcircus.grandcircus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import co.grandcircus.grandcircus.controller.webapi.enums.OrderBy;
import co.grandcircus.grandcircus.controller.webapi.enums.Search;
import co.grandcircus.grandcircus.entity.Task;
import co.grandcircus.grandcircus.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	static private Map<Integer, String> mapSort = new HashMap<>();

	static {
		mapSort.put(1, "user.userName");
		mapSort.put(2, "priority.description");
		mapSort.put(3, "startDate");
		mapSort.put(4, "endDate");
		mapSort.put(5, "complete");
		mapSort.put(-1, "user.userName");
		mapSort.put(-2, "priority.description");
		mapSort.put(-3, "startDate");
		mapSort.put(-4, "endDate");
		mapSort.put(-5, "complete");
	}

	Map<Integer, BiFunction<String, Sort, List<Task>>> mapSearch = new HashMap<>();

	private void loadSearchRules() {

		mapSearch.put(Search.ALL.getValue(), taskRepository::findAll);
		mapSearch.put(Search.TASK.getValue(), taskRepository::findByTaskName);
		mapSearch.put(Search.USER.getValue(), taskRepository::findByUser);
		mapSearch.put(Search.PRIORITY.getValue(), taskRepository::findByPriority);
		mapSearch.put(Search.STATUS.getValue(), taskRepository::findByStatus);
		mapSearch.put(Search.END_DATE.getValue(), taskRepository::findByEndDate);
		mapSearch.put(Search.END_DATE_GREATER_THAN.getValue(), taskRepository::findByEndDateGreaterThan);
		mapSearch.put(Search.END_DATE_LESS_THAN.getValue(), taskRepository::findByEndDateLessThan);
	}

	private Map<Integer, BiFunction<Float, Sort, List<Task>>> mapSearchNumber = new HashMap<>();

	private void loadSearchRulesForNumber() {
		mapSearchNumber.put(Search.COMPLETE.getValue(), taskRepository::findByComplete);
		mapSearchNumber.put(Search.COMPLETE_GREATER_THAN.getValue(), taskRepository::findByCompleteGreaterThan);
		mapSearchNumber.put(Search.COMPLETE_LESS_THAN.getValue(), taskRepository::findByCompleteLessThan);
	}

	public List<Task> search(Search enumSearchMode, Object value, OrderBy orderBy) {
		
		if (enumSearchMode == Search.END_DATE || enumSearchMode == Search.END_DATE_GREATER_THAN
				|| enumSearchMode == Search.END_DATE_LESS_THAN	){
			value = value.toString().replace("-", ".");
		}
		if (mapSearch.size() == 0) {
			loadSearchRules();
			loadSearchRulesForNumber();
		}

		var stringFunction = mapSearch.getOrDefault(enumSearchMode.getValue(), null);
		
		int sortBy = orderBy.getValue();
		var sortName = mapSort.getOrDefault(sortBy, "taskId");
		List<Task> results = new ArrayList<Task>();
		Sort sort = sortBy >= 0 ? Sort.by(Direction.ASC, sortName) : Sort.by(Direction.DESC, sortName) ;

		if (stringFunction != null) {			
			results = stringFunction.apply(value.toString(), sort);
			return results;
		}		
		else {			
			var numberFunction = mapSearchNumber.getOrDefault(enumSearchMode.getValue(), taskRepository::findByComplete);
			float numberValue = Float.parseFloat(value.toString());
			results = numberFunction.apply(numberValue, sort);			
			return results;
		}		
	}

}
