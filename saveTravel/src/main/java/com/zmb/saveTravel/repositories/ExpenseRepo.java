package com.zmb.saveTravel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zmb.saveTravel.models.ExpenseModel;

@Repository
public interface ExpenseRepo  extends CrudRepository<ExpenseModel,Long>{
	List<ExpenseModel> findAll();
}
