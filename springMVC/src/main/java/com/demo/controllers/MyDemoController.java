package com.demo.controllers;

import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Account;

@Controller
@SessionAttributes("newAccount")
public class MyDemoController {

	private String[] quotes = { "To be or not to be-Shakespeare", "Spring in nature's way of saying 'Let's Party'",
			"The time is always right to do what is right" };

	@ModelAttribute
	public void addAccountToModel(Model model) {
		System.out.println("@addAccountToModel(): making sure newAccount is in the model");
		if (!model.containsAttribute("newAccount")) {
			model.addAttribute("newAccount", new Account());
		}

	}

	// http://localhost:8080/springMVC/getQuote
	@RequestMapping(value = "/getQuote")
	public String getRandomQuote(Model model) {
		System.out.println("URL mapped correctly");

		model.addAttribute("randomQuote", quotes[new Random().nextInt(quotes.length)]);
		System.out.println("Random quote has been added to the model");

		return "quote"; // returns a view's name
	}

	// http://localhost:8080/springMVC/getQuoteWithParam
	@RequestMapping(value = "/getQuoteWithParam", params = "from" /*"from=Stefan"*/)
	public String getRandomQuoteWithParam(@RequestParam("from") String from, Model model) {
		System.out.println("URL mapped correctly");
		model.addAttribute("randomQuote", quotes[new Random().nextInt(quotes.length)]);
		System.out.println("Random quote has been added to the model");

		model.addAttribute("userName", from);
		
		return "quote"; // returns a view's name
	}

	// http://localhost:8080/springMVC/getQuoteWithParam
	@RequestMapping(value = "/getQuoteWithParam", headers = "X-API-KEY" /*"X-API-KEY=12345"*/)
	public String getRandomQuoteWithHeaders(Model model) {
		System.out.println("URL mapped correctly");
		model.addAttribute("randomQuote", quotes[new Random().nextInt(quotes.length)]);
		System.out.println("Random quote has been added to the model");

		return "quote"; // returns a view's name
	}

//	@ModelAttribute
//	public void setUserDetails(@RequestParam("userName") String userName, Model model) {
//		model.addAttribute("userName", userName);
//		
//		String userRole = "undefined";
//		
//		switch(userName) {
//		case "Andy":
//			userRole = "student";
//			break;
//		case "John":
//			userRole = "teacher";
//			break;
//		case "Allana":
//			userRole = "dean";
//			break;
//		}
//		
//		model.addAttribute("userRole", userRole);
//		System.out.println("User data has been added to the model");
//		
//	}
//	
	// http://localhost:8080/springMVC/createAccount
	@RequestMapping(value = "/createAccount")
	public String createAccount(@ModelAttribute("newAccount") Account account) {

		System.out.println("@createAccount(): returning \"createAccount\"");
		return "createAccount";
	}

	// http://localhost:8080/springMVC/accountCreated
	@RequestMapping(value = "/accountCreated", method = RequestMethod.POST)
	public String performCreated(@Valid @ModelAttribute("newAccount") Account account,
			BindingResult result /* for handling validation results */) {

		if (result.hasErrors()) {
			System.out.println("@accountCreated(): returning \"createAccount\"");
			return "createAccount";
		}
		System.out.println(account.getFirstName() + " " + account.getLastName() + " " + account.getAddress() + " "
				+ account.getEmail());

		System.out.println("@accountCreated(): returning \"accountCreated\"");
		return "redirect:accountCreatedConfirm";
	}

	@RequestMapping(value = "/accountCreatedConfirm")
	public String performCreated(@ModelAttribute("newAccount") Account account) {

		System.out.println("@performCreated(): ");
		System.out.println(account.getFirstName() + " " + account.getLastName() + " " + account.getAddress() + " "
				+ account.getEmail());
		return "accountCreated";
	}

	// http://localhost:8080/springMVC/myForm
	@RequestMapping(value = "/myForm")
	public String myForm() {

		return "myForm";
	}

	// http://localhost:8080/springMVC/handleForm
	@RequestMapping(value = "/handleForm", method = RequestMethod.POST)
	public String handleForm(@RequestParam("file") MultipartFile file) {
		try {
			if (!file.isEmpty()) {
				System.out.write(file.getBytes());
			}
		} catch (Exception e) {
			System.out.println("An exception has occured");
		}
		return "operationComplete";
	}

	// http://localhost:8080/springMVC/addCookie
	@RequestMapping(value = "/addCookie")
	public String addCookie(HttpServletResponse response) {
		response.addCookie(new Cookie("randomCookie", "aCookieIAdded"));
		System.out.println("@addCookie: a cookie has been added");
		return "cookieAdded";
	}

	// http://localhost:8080/springMVC/getCookie
	@RequestMapping(value = "/getCookie")
	public String getCookie(@CookieValue("randomCookie") String cookie) {
		System.out.println("@getCookie: A cookie retrieved: " + cookie);
		return "cookieAdded";
	}
}
