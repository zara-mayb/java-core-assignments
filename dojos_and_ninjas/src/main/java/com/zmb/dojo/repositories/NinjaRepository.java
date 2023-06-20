package com.zmb.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zmb.dojo.models.Ninjas;

@Repository
public interface NinjaRepository extends CrudRepository<Ninjas,Long> {
	List<Ninjas> findAll();

}
