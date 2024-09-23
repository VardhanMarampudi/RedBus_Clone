package com.digitbus.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.digitbus.entity.Passenger;

public interface PassengerService {

	Passenger createPassenger(Passenger Passenger);

	Passenger updatePassenger(int id, Passenger newPassenger);

	List<Passenger> retrievePasenger();

	Passenger deletePassenger(int id);

	Passenger passengerById(int id);

	List<Passenger> showPassengersByName(String name);

	Passenger showPassengerByPhone(long phone);

	List<Passenger> showPassengersByGenger(String gender);

	List<Passenger> showPassengersByAge(int age);

	Passenger showPassengersByEmail(String email);

	List<Passenger> showPassengersByCity(String city);

	List<Passenger> showPassengersByPincode(int pincode);

	Passenger showPassengerByPhoneAndPassword(long phone, String password);

	List<Passenger> showAllPassengers();

	// sorting
	List<Passenger> sortByName();

	// paging
	Page<Passenger> paging();

}
