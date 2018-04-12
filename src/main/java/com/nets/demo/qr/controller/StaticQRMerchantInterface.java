package com.nets.demo.qr.controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nets.demo.qr.entity.JsonCommunicationData;
import com.nets.demo.qr.entity.JsonNpxData;
import com.nets.demo.qr.entity.JsonRequest;
import com.nets.demo.qr.util.HTTPUtil;
import com.nets.demo.qr.util.SignatureUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/demo/")
public class StaticQRMerchantInterface {

	private static final Logger logger = LoggerFactory.getLogger(StaticQRMerchantInterface.class);

	private static final String TRANSACTION_AMOUNT_FORMAT_12D = "%012d";
	private static final String TRANSACTION_AMOUNT_FORMAT_8D = "%08d";
	private static final DateTimeFormatter DATE_TIME_FORMATTER_MMDD = DateTimeFormatter.ofPattern("MMdd");
	private static final DateTimeFormatter DATE_TIME_FORMATTER_HHMMSS = DateTimeFormatter.ofPattern("HHmmss");

	@Value("${logon.url}")
	private String logonUrl;

	@Value("${search.url}")
	private String searchUrl;

//	@Value("${api.keyId}")
//	private String apiKeyId;
//
//	@Value("${api.secret}")
//	private String apiSecret;

	@Autowired
	private HTTPUtil httpUtil;

	@RequestMapping(path = "/device/logon", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "<h3>Fill in the below fields to simulate logon request API call</h3>",
		notes = "Fill in the below parameters to experince the logon request API."
			+ " During response both the request and response are printed for the ease of understanding."
			+ " Please go thru this API code to understand the actual request generation and API interface.")
	public ResponseEntity<String> getQROrderRequest(
			@ApiParam(value = "Merchant Id assigned by NETS", defaultValue = "12345678912") @RequestParam("Mid") String mid,
			@ApiParam(value = "Terminal Id assigned by NETS", defaultValue = "99998888") @RequestParam("Tid") String tid,
			@ApiParam(value = "6 digit sequential trace number") @RequestParam("Stan") String stan,
			@ApiParam(value = "API Key assigned by NETS", defaultValue = "b027dacd-1c13-4916-8b93-38fae6be2f80") @RequestParam("apikey") String apiKeyId,
			@ApiParam(value = "API Secret assigned by NETS", defaultValue = "21296dd3-5bf6-4dfc-b8a2-03fbcc213b7b") @RequestParam("apiSecret") String apiSecret,
			@ApiParam(value = "URL to be called when the transaction is completed") @RequestParam("ResponseNotificationUrl") String callBackUrl)
			throws Exception {

		System.out.println("Request entered");
		JsonRequest request = new JsonRequest();

		request.setMti("0800");
		request.setProcessCode("930000");

		request.setStan(stan);

		request.setTransactionTime(DATE_TIME_FORMATTER_HHMMSS.format(LocalDateTime.now()));
		request.setTransactionDate(DATE_TIME_FORMATTER_MMDD.format(LocalDateTime.now()));
		request.setMid(mid);
		request.setTid(tid);

		JsonNpxData npxData = new JsonNpxData();
		npxData.setPosId(tid);
		request.setNpxData(npxData);

		ArrayList<JsonCommunicationData> communicationDatas = new ArrayList<>();
		JsonCommunicationData communicationData = new JsonCommunicationData();
		communicationData.setCommunicationCategory("URL");
		communicationData.setCommunicationDestination(callBackUrl);
		communicationData.setCommunicationType("https_proxy");
		Map<String, String> addon = new HashMap<>();
		addon.put("external_API_keyID", apiKeyId);
		communicationData.setAddon(addon);
		communicationDatas.add(communicationData);

		request.setCommunicationData(communicationDatas);

		ObjectMapper objectMapper = new ObjectMapper();
		String requestJson = objectMapper.writeValueAsString(request);
		System.out.println(requestJson);
		String sign = SignatureUtil.calculateSignature(requestJson + apiSecret);
		System.out.println(sign);
		String response = httpUtil.postRequest(logonUrl, requestJson, httpUtil.generateJsonHeaders(sign,apiKeyId));
		return new ResponseEntity<String>("[{\"request\":"+requestJson+"},{\"response\":"+response+"}]", HttpStatus.OK);

	}

	@RequestMapping(path = "/transaction/search", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "<h3>Please fill in the below fields to simulate transaction search request API call</h3>", 
		notes = "Fill in the below parameters to experince the transaction search API."
			+ " During response both actual JSON request sent and Json response received are printed for the ease of understanding."
			+ " Please go thru this API code to understand the actual request generation and API interface.")
	public ResponseEntity<String> orderEnquiryRequest(
			@ApiParam(value = "Merchant Id assigned by NETS", defaultValue = "12345678912") @RequestParam("Mid") String mid,
			@ApiParam(value = "Terminal Id assigned by NETS", defaultValue = "99998888") @RequestParam("Tid") String tid,
			@ApiParam(value = "6 digit sequential trace number") @RequestParam("Stan") String stan,
			@ApiParam(value = "API Key assigned by NETS", defaultValue = "b027dacd-1c13-4916-8b93-38fae6be2f80") @RequestParam("apikey") String apiKeyId,
			@ApiParam(value = "API Secret assigned by NETS", defaultValue = "21296dd3-5bf6-4dfc-b8a2-03fbcc213b7b") @RequestParam("apiSecret") String apiSecret,
			@ApiParam(value = "Max Number of transactions to search", defaultValue="1") @RequestParam("qrCode") Integer searchCount) throws Exception {

		JsonRequest request = new JsonRequest();

		request.setMti("0100");
		request.setProcessCode("500000");

		request.setStan(stan);
		request.setMid(mid);
		request.setTid(tid);
		request.setSearchCount(searchCount);


		ObjectMapper objectMapper = new ObjectMapper();
		String requestJson = objectMapper.writeValueAsString(request);
		System.out.println(requestJson);
		String sign = SignatureUtil.calculateSignature(requestJson + apiSecret);
		System.out.println(sign);

		String response = httpUtil.postRequest(searchUrl, requestJson, httpUtil.generateJsonHeaders(sign,apiKeyId));
		return new ResponseEntity<String>("[{\"request\":"+requestJson+"},{\"response\":"+response+"}]", HttpStatus.OK);

	}


}