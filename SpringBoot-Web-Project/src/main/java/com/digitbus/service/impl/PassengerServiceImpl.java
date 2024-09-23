package com.digitbus.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.digitbus.Repo.PassengerRepo;
import com.digitbus.entity.Passenger;
import com.digitbus.service.PassengerService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepo passengerRepo;

	@Override
	public Passenger createPassenger(Passenger Passenger) {
		long phone = Passenger.getPhone();
		String email = Passenger.getEmail();
		if (passengerRepo.findByPhone(phone) != null || passengerRepo.findByEmail(email) != null) {
			throw new RuntimeException("PhoneNumber OR Email already exists");
		} else {
			Passenger save = passengerRepo.save(Passenger);
			return save;
		}
	}

	@Override
	public Passenger updatePassenger(int passengerId, Passenger newPassenger) {
		Passenger passenger = passengerRepo.findById(passengerId).get();
		passenger.setName(newPassenger.getName());
		passenger.setPhone(newPassenger.getPhone());
		passenger.setGender(newPassenger.getGender());
		passenger.setAge(newPassenger.getAge());
		passenger.setEmail(newPassenger.getEmail());
		passenger.setCity(newPassenger.getCity());
		passenger.setPincode(newPassenger.getPincode());
		Passenger updatedPassenger = passengerRepo.save(passenger);
		return updatedPassenger;
	}

	@Override
	public List<Passenger> retrievePasenger() {
		List<Passenger> passnegers = passengerRepo.findAll();
		if (passnegers.size() == 0) {
			throw new RuntimeException("Passenger List is empty");
		} else
			return passnegers;
	}

	@Override
	public Passenger passengerById(int id) {
		Optional<Passenger> byId = passengerRepo.findById(id);
		if (byId.isPresent()) {
			return byId.get();
		} else
			throw new RuntimeException("Id not exits");

	}

	@Override
	public Passenger deletePassenger(int id) {
		Passenger passenger = passengerRepo.findById(id).get();

		if (passenger != null) {
			passengerRepo.delete(passenger);
			return passenger;
		} else {
			throw new RuntimeException("Id not exits");
		}
		
	}

	@Override
	public List<Passenger> showPassengersByName(String name) {
		List<Passenger> byName = passengerRepo.findByName(name);
		if (byName.isEmpty()) {
			throw new RuntimeException("name not exits");
		} else {
			return byName;
		}
	}

	@Override
	public Passenger showPassengerByPhone(long phone) {
		Passenger byPhone = passengerRepo.findByPhone(phone);
		if (byPhone == null) {
			throw new RuntimeException("phoneNumber not exits");
		} else {
			return byPhone;
		}
	}

	@Override
	public List<Passenger> showPassengersByGenger(String gender) {
		List<Passenger> byGenger = passengerRepo.findByGender(gender);
		if (byGenger.isEmpty()) {
			throw new RuntimeException("No passenger with that " + gender);
		} else {
			return byGenger;
		}
	}

	@Override
	public List<Passenger> showPassengersByAge(int age) {
		List<Passenger> byAge = passengerRepo.findByAge(age);
		if (byAge.isEmpty()) {
			throw new RuntimeException("No Passenger with that age" + age);
		} else {
			return byAge;
		}
	}

	@Override
	public Passenger showPassengersByEmail(String email) {
		Passenger byEmail = passengerRepo.findByEmail(email);
		if (byEmail == null) {
			throw new RuntimeException("No Passenger with that email" + email);
		} else {
			return byEmail;
		}
	}

	@Override
	public List<Passenger> showPassengersByCity(String city) {
		List<Passenger> byCity = passengerRepo.findByCity(city);
		if (byCity.isEmpty()) {
			throw new RuntimeException("No Passenger with that city" + city);
		} else {
			return byCity;
		}

	}

	@Override
	public List<Passenger> showPassengersByPincode(int pincode) {
		List<Passenger> byPincode = passengerRepo.findByPincode(pincode);
		if (byPincode.isEmpty()) {
			throw new RuntimeException("No Passenger with that pincode" + pincode);
		} else {
			return byPincode;
		}
	}

	@Override
	public Passenger showPassengerByPhoneAndPassword(long phone, String password) {
		Passenger byPhoneAndPassword = passengerRepo.findByPhoneAndPassword(phone, password);
		if (byPhoneAndPassword != null) {
			return byPhoneAndPassword;
		} else
			throw new RuntimeException("phoneNumber or Password does not match");
	}

	@Override
	public List<Passenger> sortByName() {
		List<Passenger> sortName = passengerRepo.findAll(Sort.by("name"));
		return sortName;
	}

	@Override
	public Page<Passenger> paging() {
		Page<Passenger> page = passengerRepo.findAll(PageRequest.of(0, 3));
		return page;
	}

	@Override
	public List<Passenger> showAllPassengers() {
		List<Passenger> passengers = passengerRepo.findAll();
		return passengers;
	}

}
