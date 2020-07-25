package com.example.demo.service;

import java.util.ArrayList;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerAdress;
import com.example.demo.repository.AdressRepository;

@Service
public class CustomerAdressService {

	@Autowired
	AdressRepository adressrepo;

	public List<CustomerAdress> getAllAdress() {
		List<CustomerAdress> customeradresses = new ArrayList<CustomerAdress>();
		adressrepo.findAll().forEach(customeradress -> customeradresses.add(customeradress));
		return customeradresses;
	}

	public CustomerAdress getAdressById(int id) throws NoSuchElementException {
		Optional<CustomerAdress> customeradress = adressrepo.findById(id);
		if (customeradress.isPresent()) {
			return customeradress.get();
		} else {
			throw new NoSuchElementException("This customeradress is't exitenz.");
		}

	}

	public CustomerAdress create(CustomerAdress element) {
		Optional<CustomerAdress> customeradress = adressrepo.findById(element.getID());
		if (customeradress.isPresent()) {
			return customeradress.get();
		} else {
			return adressrepo.save(element);
		}
	}

	public void delete(int id) throws NoSuchElementException {
		Optional<CustomerAdress> customeradress = adressrepo.findById(id);
		if (customeradress.isPresent()) {
			adressrepo.deleteById(id);
		} else {
			throw new NoSuchElementException("This id is't exitenz.");
		}
	}
}
