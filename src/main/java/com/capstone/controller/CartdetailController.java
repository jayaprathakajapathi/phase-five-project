package com.capstone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.Cartdetail;
import com.capstone.service.CartdetailService;

@RestController
public class CartdetailController {

	@Autowired
	CartdetailService cartdetailService;

	@GetMapping("/details")
	private List getAllCartdetail() {
		return cartdetailService.getAlldetails();
	}

	@GetMapping("/details/{id}")
	private Cartdetail getitem(@PathVariable("id") int id) {
		return cartdetailService.getCartdetailById(id);
	}
	@DeleteMapping("/details/{id}")
	private void deletedetail(@PathVariable("id") int id) {
		cartdetailService.delete(id);
	}

	@PostMapping("/details")
	private int saveCartdetail(@RequestBody Cartdetail cartdetail) {
		cartdetailService.saveOrUpdate(cartdetail);
		return cartdetail.getId();
	}
}