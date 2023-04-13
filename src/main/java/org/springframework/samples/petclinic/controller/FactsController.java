package org.springframework.samples.petclinic.controller;

import java.util.List;
import java.util.Map;

import org.springframework.samples.petclinic.service.FactsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FactsController {

	private final FactsService factsService;

	@GetMapping(value = "/facts", produces = "application/json")
	public List<Map<String, Object>> getFacts() {
		return factsService.getFacts();
	}

}
