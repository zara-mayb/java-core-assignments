package com.zmb.dojo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zmb.dojo.models.Ninjas;
import com.zmb.dojo.services.DojoService;
import com.zmb.dojo.services.NinjaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	@Autowired
	NinjaService ninjaService;
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/new")
	public String add(@ModelAttribute("ninja") Ninjas ninja, Model model) {
		model.addAttribute("dojos", dojoService.getAll());
		return "/ninja/add.jsp";
	}
	@PostMapping("/add")
	public String create(@Valid@ModelAttribute("ninja") Ninjas ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.getAll());
			return "/ninja/add.jsp";
		}
		ninjaService.create(ninja);
		return "redirect:/dojos/new";
	}
	
}
