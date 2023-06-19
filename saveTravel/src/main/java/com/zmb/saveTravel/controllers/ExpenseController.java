package com.zmb.saveTravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zmb.saveTravel.models.ExpenseModel;
import com.zmb.saveTravel.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("expense") ExpenseModel expense, Model model) {
		List<ExpenseModel> expenses = expenseService.getAll();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	@PostMapping("/add")
	public String create(@Valid@ModelAttribute("expense") ExpenseModel expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<ExpenseModel> expenses = expenseService.getAll();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id")Long id, @ModelAttribute("expense") ExpenseModel expense, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		return "edit.jsp";
	}
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("expense")ExpenseModel expense, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expense", expense);
			return "edit.jsp";
		}
		expenseService.updateExpense(expense);
		return "redirect:/";
	}
    @DeleteMapping("/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/";
    }
    @GetMapping("/show/{id}")
    public String show(@PathVariable("id")Long id, Model model) {
    	model.addAttribute("expense", expenseService.findExpense(id));
    	return "show.jsp";
    }


	
}
