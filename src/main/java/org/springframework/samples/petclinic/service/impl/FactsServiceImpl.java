package org.springframework.samples.petclinic.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.samples.petclinic.feign.client.FactsClient;
import org.springframework.samples.petclinic.service.FactsService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FactsServiceImpl implements FactsService {

	private final FactsClient factsClient;

	public List<Map<String, Object>> getFacts() {
		return factsClient.geFacts().getBody();
	}

}
