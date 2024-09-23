package com.digitbus.Repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitbus.entity.Passenger;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Serializable> {

	List<Passenger> findByName(String name);

	Passenger findByPhone(long phone);

	List<Passenger> findByGender(String gender);

	List<Passenger> findByAge(int age);

	Passenger findByEmail(String email);

	List<Passenger> findByCity(String city);

	List<Passenger> findByPincode(int pincode);
	
	Passenger findByPhoneAndPassword(long phone,String password);

}
