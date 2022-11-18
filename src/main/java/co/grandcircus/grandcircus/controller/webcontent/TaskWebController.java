package co.grandcircus.grandcircus.controller.webcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.grandcircus.entity.Priority;
import co.grandcircus.grandcircus.entity.Status;
import co.grandcircus.grandcircus.entity.Task;
import co.grandcircus.grandcircus.entity.User;
import co.grandcircus.grandcircus.handlingformsubmission.TaskForm;
import co.grandcircus.grandcircus.repository.PriorityRepository;
import co.grandcircus.grandcircus.repository.StatusRepository;
import co.grandcircus.grandcircus.repository.TaskRepository;
import co.grandcircus.grandcircus.repository.UserRepository;

@Controller
@RequestMapping("/web")
public class TaskWebController {

	@Autowired
	PriorityRepository priorityRepository;

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	TaskRepository taskRepository;
	

	@Autowired
	UserRepository userRepository;

	@GetMapping("/tasks")
	public String findAllTask(Model model) {

		System.out.println("2model:" + model);
		return "taskdesign";
	}

	@GetMapping("/task")
	public String getATask(@ModelAttribute TaskForm taskForm, Model model) {

		Iterable<Priority> options = priorityRepository.findAll();
		Iterable<Status> status = statusRepository.findAll();
		Iterable<User> users = userRepository.findAll();
		Task task = new Task();
		
		int taskId = taskForm.getTaskId();

		if (taskId != -999) {
			task = taskRepository.findById(taskForm.getTaskId()).get();
			taskForm.populateForm(task);
		}

		//taskForm.populateForm(task);
		model.addAttribute("options", options);
		model.addAttribute("statuses", status);
		model.addAttribute("task", taskForm);
		model.addAttribute("users", users);
		
		return "taskformdesign";
	}

	@PostMapping("/task")
	public ModelAndView postATask(@ModelAttribute TaskForm taskForm, ModelMap model) {
		model.addAttribute("taskId", taskForm.getTaskId());
		int taskId = taskForm.getTaskId();
		
		Task task = null;
		
		if (taskId != -999) {
			task = taskRepository.findById(taskId).get();
		}
		else {
			task = new Task();
		}
		
		task.insert(taskForm);
		
		taskRepository.save(task);
		
		return new ModelAndView("redirect:/web/tasks", model);
	}
}