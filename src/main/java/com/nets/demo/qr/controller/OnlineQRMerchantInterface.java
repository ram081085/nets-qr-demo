package com.nets.demo.qr.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nets.demo.qr.entity.JsonCommunicationData;
import com.nets.demo.qr.entity.JsonNpxData;
import com.nets.demo.qr.entity.JsonRequest;
import com.nets.demo.qr.util.HTTPUtil;
import com.nets.demo.qr.util.SignatureUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/demo/")
public class OnlineQRMerchantInterface {

	private static final Logger logger = LoggerFactory.getLogger(OnlineQRMerchantInterface.class);

	private static final String TRANSACTION_AMOUNT_FORMAT_12D = "%012d";
	private static final String TRANSACTION_AMOUNT_FORMAT_8D = "%08d";
	private static final DateTimeFormatter DATE_TIME_FORMATTER_MMDD = DateTimeFormatter.ofPattern("MMdd");
	private static final DateTimeFormatter DATE_TIME_FORMATTER_HHMMSS = DateTimeFormatter.ofPattern("HHmmss");

	@Value("${order.url}")
	private String orderUrl;

	@Value("${inquiry.url}")
	private String inquiryUrl;

	@Value("${reversal.url}")
	private String reversalUrl;

//	@Value("${api.keyId}")
//	private String apiKeyId;
//
//	@Value("${api.secret}")
//	private String apiSecret;

	@Value("${communication.type}")
	private String communicationType;

	@Autowired
	private HTTPUtil httpUtil;

	@RequestMapping(path = "/order/request", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "<h3>Fill in the below fields to simulate getQR order request API call</h3>",
		notes = "Fill in the below parameters to experince the order request API."
			+ " During response both the request and response are printed for the ease of understanding."
			+ " Please go thru this API code to understand the actual request generation and API interface.")
	public ResponseEntity<String> getQROrderRequest(
			@ApiParam(value = "Transaction amount", defaultValue = "1.23") @RequestParam("Amount") String amount,
			@ApiParam(value = "Institution code for ordering system, assigned by NETS", defaultValue = "20000000001") @RequestParam("InstitutionCode") String institutionCode,
			@ApiParam(value = "Merchant Id assigned by NETS", defaultValue = "12345678912") @RequestParam("Mid") String mid,
			@ApiParam(value = "Terminal Id assigned by NETS", defaultValue = "99998888") @RequestParam("Tid") String tid,
			@ApiParam(value = "Condition code assigned by NETS", defaultValue = "85") @RequestParam("ConditionCode") String conditionCode,
			@ApiParam(value = "Transaction currency", defaultValue = "SGD") @RequestParam("TransactionCurrency") String sourceCurrency,
			@ApiParam(value = "6 digit sequential trace number") @RequestParam("Stan") String stan,
			@ApiParam(value = "API Key assigned by NETS", defaultValue = "b027dacd-1c13-4916-8b93-38fae6be2f80") @RequestParam("apikey") String apiKeyId,
			@ApiParam(value = "API Secret assigned by NETS", defaultValue = "21296dd3-5bf6-4dfc-b8a2-03fbcc213b7b") @RequestParam("apiSecret") String apiSecret,
			@ApiParam(value = "URL to be called when the transaction is completed", defaultValue="https://your-domain-name:8801/demo/order/notification") @RequestParam("ResponseNotificationUrl") String callBackUrl)
			throws Exception {

		System.out.println("Request entered");
		JsonRequest request = new JsonRequest();

		request.setMti("0200");
		request.setProcessCode("990000");

		long transactionAmountCents = new BigDecimal(amount).multiply(new BigDecimal(100)).longValue();
		request.setTargetAmount(String.format(TRANSACTION_AMOUNT_FORMAT_12D, transactionAmountCents));
		request.setStan(stan);

		request.setTransactionTime(DATE_TIME_FORMATTER_HHMMSS.format(LocalDateTime.now()));
		request.setTransactionDate(DATE_TIME_FORMATTER_MMDD.format(LocalDateTime.now()));
		request.setEntryMode("000");
		request.setConditionCode(conditionCode);
		request.setInstitutionCode(institutionCode);
		request.setMid(mid);
		request.setTid(tid);
		request.setGetQRCode("Y");

		JsonNpxData npxData = new JsonNpxData();
		npxData.setPosId(tid);
		npxData.setSourceAmount(String.format(TRANSACTION_AMOUNT_FORMAT_8D, transactionAmountCents));
		npxData.setSourceCurrency(sourceCurrency);
		request.setNpxData(npxData);

		ArrayList<JsonCommunicationData> communicationDatas = new ArrayList<>();
		JsonCommunicationData communicationData = new JsonCommunicationData();
		communicationData.setCommunicationCategory("URL");
		communicationData.setCommunicationDestination(callBackUrl);
		communicationData.setCommunicationType(communicationType);
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
		String responseString = httpUtil.postRequest(orderUrl, requestJson, httpUtil.generateJsonHeaders(sign,apiKeyId));
//		JsonRequest response = objectMapper.readValue(responseString.getBytes(), JsonRequest.class);
//		String qrImageLink = "http://qrickit.com/api/qr.php?qrsize=300&d="+URLEncoder.encode(response.getSearchId());
//		return new ResponseEntity<String>("[{\"request\":"+requestJson+"},{\"response\":"+responseString+"},{\"qr_image_link\":\""+qrImageLink+"\"}]", HttpStatus.OK);
		return new ResponseEntity<String>(responseString, HttpStatus.OK);

	}

	@RequestMapping(path = "/transaction/query", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "<h3>Please fill in the below fields to simulate order enquiry request API call</h3>", 
		notes = "Fill in the below parameters to experince the order Enquiry API."
			+ " During response both actual JSON request sent and Json response received are printed for the ease of understanding."
			+ " Please go thru this API code to understand the actual request generation and API interface.")
	public ResponseEntity<String> orderEnquiryRequest(
			@ApiParam(value = "Institution code for ordering system, assigned by NETS", defaultValue = "20000000001") @RequestParam("InstitutionCode") String institutionCode,
			@ApiParam(value = "Merchant Id assigned by NETS", defaultValue = "12345678912") @RequestParam("Mid") String mid,
			@ApiParam(value = "Terminal Id assigned by NETS", defaultValue = "99998888") @RequestParam("Tid") String tid,
			@ApiParam(value = "Condition code assigned by NETS", defaultValue = "85") @RequestParam("ConditionCode") String conditionCode,
			@ApiParam(value = "6 digit sequential trace number") @RequestParam("Stan") String stan,
			@ApiParam(value = "API Key assigned by NETS", defaultValue = "b027dacd-1c13-4916-8b93-38fae6be2f80") @RequestParam("apikey") String apiKeyId,
			@ApiParam(value = "API Secret assigned by NETS", defaultValue = "21296dd3-5bf6-4dfc-b8a2-03fbcc213b7b") @RequestParam("apiSecret") String apiSecret,
			@ApiParam(value = "QR code used in order request") @RequestParam("qrCode") String qrCode) throws Exception {

		JsonRequest request = new JsonRequest();

		request.setMti("0100");
		request.setProcessCode("330000");

		request.setStan(stan);
		request.setEntryMode("000");
		request.setConditionCode(conditionCode);
		request.setInstitutionCode(institutionCode);
		request.setMid(mid);
		request.setTid(tid);
		request.setSearchId(qrCode);

		JsonNpxData npxData = new JsonNpxData();
		npxData.setPosId(tid);
		request.setNpxData(npxData);

		ObjectMapper objectMapper = new ObjectMapper();
		String requestJson = objectMapper.writeValueAsString(request);
		System.out.println(requestJson);
		String sign = SignatureUtil.calculateSignature(requestJson + apiSecret);
		System.out.println(sign);

		String response = httpUtil.postRequest(inquiryUrl, requestJson, httpUtil.generateJsonHeaders(sign,apiKeyId));
//		return new ResponseEntity<String>("[{\"request\":"+requestJson+"},{\"response\":"+response+"}]", HttpStatus.OK);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@RequestMapping(path = "/transaction/reversal", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "<h3>Please fill in the below fields to simulate the order reversal API request</h3>", 
		notes = "Fill in the below parameters to experince the order reversal API."
			+ " During response both actual JSON request sent and Json response received are printed for the ease of understanding."
			+ " Please go thru this API code to understand the actual request generation and API interface.")
	public ResponseEntity<String> orderReversalRequest(
			@ApiParam(value = "Transaction amount", defaultValue = "1.23") @RequestParam("Amount") String amount,
			@ApiParam(value = "Institution code for ordering system, assigned by NETS", defaultValue = "20000000001") @RequestParam("InstitutionCode") String institutionCode,
			@ApiParam(value = "Merchant Id assigned by NETS", defaultValue = "12345678912") @RequestParam("Mid") String mid,
			@ApiParam(value = "Terminal Id assigned by NETS", defaultValue = "99998888") @RequestParam("Tid") String tid,
			@ApiParam(value = "Condition code assigned by NETS", defaultValue = "85") @RequestParam("ConditionCode") String conditionCode,
			@ApiParam(value = "Transaction currency", defaultValue = "SGD") @RequestParam("TransactionCurrency") String sourceCurrency,
			@ApiParam(value = "6 digit sequential trace number") @RequestParam("Stan") String stan,
			@ApiParam(value = "API Key assigned by NETS", defaultValue = "b027dacd-1c13-4916-8b93-38fae6be2f80") @RequestParam("apikey") String apiKeyId,
			@ApiParam(value = "API Secret assigned by NETS", defaultValue = "21296dd3-5bf6-4dfc-b8a2-03fbcc213b7b") @RequestParam("apiSecret") String apiSecret,
			@ApiParam(value = "QR code used in order request") @RequestParam("qrCode") String qrCode) throws Exception {

		JsonRequest request = new JsonRequest();

		request.setMti("0400");
		request.setProcessCode("990000");

		long transactionAmountCents = new BigDecimal(amount).multiply(new BigDecimal(100)).longValue();
		request.setTargetAmount(String.format(TRANSACTION_AMOUNT_FORMAT_12D, transactionAmountCents));
		request.setStan(stan);

		request.setTransactionTime(DATE_TIME_FORMATTER_HHMMSS.format(LocalDateTime.now()));
		request.setTransactionDate(DATE_TIME_FORMATTER_MMDD.format(LocalDateTime.now()));
		request.setEntryMode("000");
		request.setConditionCode(conditionCode);
		request.setInstitutionCode(institutionCode);
		request.setMid(mid);
		request.setTid(tid);
		request.setSearchId(qrCode);

		JsonNpxData npxData = new JsonNpxData();
		npxData.setPosId(tid);
		npxData.setSourceAmount(String.format(TRANSACTION_AMOUNT_FORMAT_8D, transactionAmountCents));
		npxData.setSourceCurrency(sourceCurrency);
		request.setNpxData(npxData);

		ObjectMapper objectMapper = new ObjectMapper();
		String requestJson = objectMapper.writeValueAsString(request);
		System.out.println(requestJson);
		String sign = SignatureUtil.calculateSignature(requestJson + apiSecret);
		System.out.println(sign);
		String response = httpUtil.postRequest(reversalUrl, requestJson, httpUtil.generateJsonHeaders(sign,apiKeyId));
		return new ResponseEntity<String>("[{\"request\":"+requestJson+"},{\"response\":"+response+"}]", HttpStatus.OK);
	}
	
	private Map<String, String> notifications = new HashMap<>();
	
	@RequestMapping(path = "/order/notification", method = RequestMethod.POST)
	@ResponseBody
	@ApiIgnore
	public ResponseEntity<String> getData(HttpServletRequest request, @RequestBody String wrapper) throws JsonParseException, JsonMappingException, IOException    
	{
	    System.out.println(request.toString());
	    System.out.println(wrapper);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonRequest notification = objectMapper.readValue(wrapper, JsonRequest.class);
		notifications.put(notification.getSearchId(), wrapper);
		
	    return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@RequestMapping(path = "/order/getnotification", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "<h3>Please fill in the below fields to fetch the order notification</h3>", 
		notes = "You can use this API only if the order ResponseNotificationUrl is pointing to this demo application uri https://domain-name:8801/demo/order/notification."
				+ "Precondition are port is defaulted to 8801, URI should be publicly accessible and SSL certificate should be shared with NETS."
			+ " Please go thru /order/notification API code to understand the actual notification reception interface.")
	public ResponseEntity<String> orderNotification(
			@ApiParam(value = "QR code used in order request") @RequestParam("qrCode") String qrCode) throws Exception {
		ResponseEntity<String> response = new ResponseEntity<String>(notifications.get(qrCode), HttpStatus.OK);
		notifications.remove(qrCode);
		return response;

	}

}