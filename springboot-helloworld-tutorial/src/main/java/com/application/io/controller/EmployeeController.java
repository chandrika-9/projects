package com.application.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.io.model.Employee;
import com.application.io.service.EmployeeService;

@Controller
public class EmployeeController {
	
	 @Autowired
	    private EmployeeService employeeService;

	    // display list of employees
	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        model.addAttribute("listEmployees", employeeService.getAllEmployees());
	        return "index";
	    }
	    
	    @GetMapping("/showNewEmployeeForm")
	    public String showNewEmployeeForm(Model model) {
	        // create model attribute to bind form data
	        Employee employee = new Employee();
	        model.addAttribute("employee", employee);
	        return "new_employee";
	    }
	    @PostMapping("/save")
	    public String saveEmployees(@ModelAttribute Employee emp) {
	        employeeService.saveEmployee(emp);
	        return "redirect:/";
	    }
	    
	    @GetMapping("/showFormForUpdate/{id}")
	    public String showFormUpdate(@PathVariable (value="id") int id,Model model) {
	        Employee employee = employeeService.getEmployeeId(id);
	        model.addAttribute("employee", employee);
	        return "update_employee";
	    }
	    
		@GetMapping("/deleteEmployee/{id}")
		public String deleteEmployee(@PathVariable(value = "id") int id) {

			this.employeeService.deleteEmployeeId(id);
			return "redirect:/";
		}

}
