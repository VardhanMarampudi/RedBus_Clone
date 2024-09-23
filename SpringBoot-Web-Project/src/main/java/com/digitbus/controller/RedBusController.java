package com.digitbus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.digitbus.entity.Passenger;
import com.digitbus.service.PassengerService;

@Controller
public class RedBusController {

	@Autowired
	private PassengerService passengerService;

	@GetMapping("/")
	public String landingPageHandler() {
		return "index";
	}

	@GetMapping("/home")
	public String homePageHandler() {
		return "index";
	}

	@GetMapping("/passengerSignup")
	public String PassengerHandler() {
		return "passengerSignup";
	}

	@PostMapping("/registrationsuccess")
	public ModelAndView RegisterHandler(@ModelAttribute("PassengerReg") Passenger Passenger) {
		passengerService.createPassenger(Passenger);
		ModelAndView mav = new ModelAndView("registrationsuccess", "key", Passenger);
		return mav;
	}

	@GetMapping("/passengerlogin")
	public String LoginHandler() {
		return "passengerLogin";
	}

	@PostMapping("/loginsuccess")
	public ModelAndView loginSuccessHandler(@ModelAttribute("PassengerLogin") Passenger passenger) {
		String password = passenger.getPassword();
		long phone = passenger.getPhone();
		passengerService.showPassengerByPhoneAndPassword(phone, password);
		ModelAndView mav = new ModelAndView("loginsuccess", "key", passenger);
		return mav;
	}
	
	@GetMapping("/showPassengers")
	public ModelAndView allPassengersHandler(@ModelAttribute("allPassengers") Passenger passenger) {
		List<Passenger> showAllPassengers = passengerService.showAllPassengers();
		ModelAndView mav = new ModelAndView("showPassengers", "passengers", showAllPassengers);
		return mav;
	}
	
	
	 
}
