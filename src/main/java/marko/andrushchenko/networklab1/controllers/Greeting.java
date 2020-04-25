package marko.andrushchenko.networklab1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/greet")
public class Greeting {

	@GetMapping("/")
	String mainPage(Model model){
		return "greeting";
	}
	@GetMapping("/{name}")
	String greeting(@PathVariable String name, Model model){
		model.addAttribute(name);
		return "greetingpage";
	}
}
