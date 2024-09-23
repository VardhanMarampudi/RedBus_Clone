package com.digitbus.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitbus.entity.Passenger;
import com.digitbus.service.PassengerService;

@RestController
@RequestMapping("/redbus/api")
public class redBusRestController {

	@Autowired
	PassengerService passengerService;

	@PostMapping("/passenger")
	public ResponseEntity<Passenger> savePassenger(@RequestBody Passenger passenger) {
		return ResponseEntity.ok(passengerService.createPassenger(passenger));
	}

	@GetMapping("/passengers")
	public ResponseEntity<List<Passenger>> showPassengers() {
		return ResponseEntity.ok(passengerService.showAllPassengers());

	}

	@PutMapping("/passenger/{id}")
	public ResponseEntity<?> updatePassenger(@PathVariable int id, @RequestBody Passenger newpassenger) {
		return ResponseEntity.ok(passengerService.updatePassenger(id, newpassenger));
	}

	@GetMapping("/passenger/{id}")
	public ResponseEntity<Passenger> showpassengerById(@PathVariable int id) {
		return ResponseEntity.ok(passengerService.passengerById(id));
	}

	@DeleteMapping("/passenger/{id}")
	public ResponseEntity<Passenger> deletePAssenger(@PathVariable int id) {
		return ResponseEntity.ok(passengerService.deletePassenger(id));
	}

}
