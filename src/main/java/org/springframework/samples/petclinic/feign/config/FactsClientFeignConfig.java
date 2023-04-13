package org.springframework.samples.petclinic.feign.config;

import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.Bean;

import feign.FeignException;
import feign.Logger;
import feign.RetryableException;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import feign.slf4j.Slf4jLogger;

public class FactsClientFeignConfig {

	@Bean
	Retryer retryer() {
		return new feign.Retryer.Default();
	}

	@Bean
	Logger logger() {
		return new Slf4jLogger();
	}

	/**
	 * If the authentication fails, evict the cache and retry the authentication
	 * @return A RetryableException is being returned.
	 */
	@Bean
	ErrorDecoder errorDecoder() {
		return (methodKey, response) -> {
			FeignException feignException = feign.FeignException.errorStatus(methodKey, response);
			return new RetryableException(response.status(),
					StandardCharsets.UTF_8.decode(feignException.responseBody().get()).toString(),
					response.request().httpMethod(), feignException, null, response.request());
		};
	}

}
