package com.zmb.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.dojo.models.Dojo;
import com.zmb.dojo.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
	
	//get all
	public List<Dojo> getAll(){
		return dojoRepo.findAll();
	}
	//create one
	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	//retrieves one
	public Dojo find(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	//update one
	public Dojo update(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	//delete one
	public void delete(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			dojoRepo.deleteById(id);
		}
	}
}
