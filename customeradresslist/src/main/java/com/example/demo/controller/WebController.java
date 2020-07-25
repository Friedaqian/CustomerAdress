package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustomerAdress;
import com.example.demo.repository.AdressRepository;

@RestController
@RequestMapping("/")
class WebController {

	@Autowired
	AdressRepository adressrepo;

	@GetMapping("customeradress")
	public ResponseEntity<Iterable<CustomerAdress>> getAllAdress() {
		return new ResponseEntity<>(adressrepo.findAll(), HttpStatus.OK);

	}

	@PostMapping("customeradress")
	public ResponseEntity<CustomerAdress> create(@Validated @RequestBody CustomerAdress customeradress) {
		return new ResponseEntity<>(adressrepo.save(customeradress), HttpStatus.CREATED);
	}

	@GetMapping("customeradress/{id}")
	public ResponseEntity<CustomerAdress> getAdress(@PathVariable Integer id) {
		if (adressrepo.existsById(id)) {
			adressrepo.findById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("customeradress/{id}")
	public ResponseEntity<CustomerAdress> delete(@PathVariable Integer id) {
		if (adressrepo.existsById(id)) {
			adressrepo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
