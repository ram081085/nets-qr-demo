package com.nets.demo.qr.util;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HTTPUtil {

	@Autowired
	public RestTemplate restTemplate;

//	@Value("${api.keyId}")
//	private String apiKeyId;

	private static final String API_KEY_ID = "KeyId";
	private static final String SIGNATURE = "sign";

	public String postRequest(String url, String message, HttpHeaders headers) {
		
		HttpEntity<String> entity = new HttpEntity<String>(message, headers);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		response.getBody();
		return response.getBody();
	}
	
	public HttpHeaders generateJsonHeaders(String sign,String apiKeyId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add(API_KEY_ID, apiKeyId);
		headers.add(SIGNATURE, sign);
		return headers;
	}
}
