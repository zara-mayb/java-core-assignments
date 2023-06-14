package com.zmb.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/omikuji")
public class HomeController {
	@GetMapping("")
	public String home() {
		return "index.jsp";
	}
	@PostMapping("/submit")
	public String submit(
			@RequestParam(value="num") String num,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="livingThing") String livingThing,
			@RequestParam(value="comment") String comment,
			HttpSession session
			) {
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("comment", comment);
			
		return "redirect:/omikuji/show";
	}
	@GetMapping("/show")
	public String show() {
		return "show.jsp";
	}
}
