package com.zmb.dojo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zmb.dojo.models.Dojo;
import com.zmb.dojo.services.DojoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	@Autowired
	DojoService dojoService;
	

	@GetMapping("/new")
	public String add(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojos = dojoService.getAll();
		model.addAttribute("dojos", dojos);
		return "/dojo/add.jsp";
	}
	
	@PostMapping("/add")
	public String create(@Valid@ModelAttribute("dojo")  Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojos = dojoService.getAll();
			model.addAttribute("dojos", dojos);
			return "/dojo/add.jsp";
		}
		dojoService.create(dojo);
		return "redirect:/dojos/new";
	}
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.find(id));
		return "/dojo/index.jsp";
	}
}
