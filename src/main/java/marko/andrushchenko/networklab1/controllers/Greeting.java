package marko.andrushchenko.networklab1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/greet")
public class Greeting {

	@GetMapping("/{name}")
	String greetingPage(@PathVariable String name, Model model){
		return "greeting";
	}
}
