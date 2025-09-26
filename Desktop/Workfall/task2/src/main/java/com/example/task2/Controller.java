package com.example.task2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller
{
	    @GetMapping("/greet")
	    public String greet(@RequestParam String name) 
	    {
	        return "Hey Hi " + name;
	    }
	    @GetMapping("/palindrome")
	    public String checkPalindrome(@RequestParam String text)
	    {
	        String reversed = new StringBuilder(text).reverse().toString();
	        if (text.equalsIgnoreCase(reversed)) {
	            return "yes";
	        } else {
	            return "no";
	        }
	    }
	}
