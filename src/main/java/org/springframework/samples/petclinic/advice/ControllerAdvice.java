package org.springframework.samples.petclinic.advice;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is used to handle the exceptions thrown in User Access Service
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ControllerAdvice {

	/**
	 * This function is used to handle the FeignException.Unauthorized and return the
	 * appropriate response
	 * @param feignClientException This is the exception that is thrown by the Feign
	 * client.
	 * @return ResponseEntity<CommonResponse<UserIdentityInfoResponse>>
	 */
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<Map<String, String>> feignClientUnauthorizedException(
			FeignException.Unauthorized feignClientException) {
		log.error("feignClientException : ", feignClientException);
		return new ResponseEntity<>(Map.of("401", "Unauthorized"), HttpStatus.OK);
	}

}
