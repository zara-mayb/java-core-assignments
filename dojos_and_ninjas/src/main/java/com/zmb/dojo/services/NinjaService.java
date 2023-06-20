package com.zmb.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.dojo.models.Ninjas;
import com.zmb.dojo.repositories.NinjaRepository;
@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
	//get all
	public List<Ninjas> getAll(){
		return ninjaRepo.findAll();
	}
	//create one
	public Ninjas create(Ninjas ninja) {
		return ninjaRepo.save(ninja);
	}
	//retrieves one
	public Ninjas find(Long id) {
		Optional<Ninjas> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
	//update one
	public Ninjas update(Ninjas ninja) {
		return ninjaRepo.save(ninja);
	}
	//delete one
	public void delete(Long id) {
		Optional<Ninjas> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			ninjaRepo.deleteById(id);
		}
	}
}
