package org.springframework.samples.petclinic.feign.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.feign.config.FactsClientFeignConfig;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "FactsClient", url = "https://cat-fact.herokuapp.com/",
		configuration = FactsClientFeignConfig.class)
public interface FactsClient {

	@GetMapping(value = "/facts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map<String, Object>>> geFacts();

}
