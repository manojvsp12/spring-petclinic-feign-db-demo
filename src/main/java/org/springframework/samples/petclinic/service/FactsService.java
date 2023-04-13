package org.springframework.samples.petclinic.service;

import java.util.List;
import java.util.Map;

public interface FactsService {

	public List<Map<String, Object>> getFacts();

}
