package com.zmb.saveTravel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.saveTravel.models.ExpenseModel;
import com.zmb.saveTravel.repositories.ExpenseRepo;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepo expenseRepository;
	
	//get all
	public List<ExpenseModel> getAll(){
		return expenseRepository.findAll();
	}
	//create one
	public ExpenseModel createExpense(ExpenseModel expense) {
		return expenseRepository.save(expense);
	}
	//retrieves one
	public ExpenseModel findExpense(Long id) {
		Optional<ExpenseModel> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
	}
	//update one
	public ExpenseModel updateExpense(ExpenseModel expense) {
		return expenseRepository.save(expense);
	}
	//delete one
	public void deleteExpense(Long id) {
		Optional<ExpenseModel> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			expenseRepository.deleteById(id);
		}
	}
}
