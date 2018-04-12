package com.nets.demo.qr.entity;


import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class JsonRequest implements  Serializable {

	private static final long serialVersionUID = 4415872387735856251L;

	@JsonProperty("retrieval_ref")
	private String retrievalRef;

	@JsonProperty("mti")
	private String mti;

	@JsonProperty("txn_identifier")
	private String searchId;

	@JsonProperty("process_code")
	private String processCode;

	@JsonProperty("amount")
	private String targetAmount;

	@JsonProperty("stan")
	private String stan;

	@JsonProperty("transaction_time")
	private String transactionTime;

	@JsonProperty("transaction_date")
	private String transactionDate;

	@JsonProperty("entry_mode")
	private String entryMode;

	@JsonProperty("condition_code")
	private String conditionCode;

	@JsonProperty("institution_code")
	private String institutionCode;

	@JsonProperty("card_seq_number")
	private String cardSequenceNumber;

	@JsonProperty("track2_data")
	private String track2Data;

	@JsonProperty("icc_data")
	private String iccData;

	@JsonProperty("pin")
	private String pin;

	@JsonProperty("response_code")
	private String responseCode;

	@JsonProperty("approval_code")
	private String approvalCode;

	@JsonProperty("host_tid")
	private String tid;

	@JsonProperty("host_mid")
	private String mid;

	@JsonProperty("pay_details")
	private String payDetails;

	@JsonProperty("SOF_uri")
	private String sofUri;

	@JsonProperty("user_data")
	private String userData;

	@JsonProperty("sig")
	private String sig;

	@JsonProperty("transmission_time")
	private String transmissionTime;

	@JsonProperty("settlement_date")
	private String settlementDate;

	@JsonProperty("capture_date")
	private String captureDate;

	@JsonProperty("nii")
	private String nii;

	@JsonProperty("acceptor_name")
	private String acceptorName;

	@JsonProperty("loyalty_data")
	private String loyaltyData;

	@JsonProperty("invoice_ref")
	private String invoiceRef;

	@JsonProperty("npx_data")
	private JsonNpxData npxData;

	@JsonProperty("callback_url")
	private String callbackUrl;

	@JsonProperty("cvv")
	private String cvv;

	@JsonProperty("search_count")
	private Integer searchCount;

	@JsonProperty("communication_data")
	private ArrayList<JsonCommunicationData> communicationData;

	@JsonProperty("transactions")
	private ArrayList<TransactionDetail> transactions;

	@JsonProperty("getQRCode")
	private String getQRCode;

	@JsonProperty("qr_code")
	private String qRCode;

	public JsonRequest() {
	}
	
	public JsonRequest(String retrievalRef, String mti, String searchId, String processCode, String targetAmount, String stan, String transactionTime,
			String transactionDate, String entryMode, String conditionCode, String institutionCode, String cardSequenceNumber, String track2Data,
			String iccData, String pin, String responseCode, String approvalCode, String tid, String mid, String payDetails, String sofUri,
			String userData, String sig, String transmissionTime, String settlementDate, String captureDate, String nii, String acceptorName,
			String loyaltyData, String invoiceRef, JsonNpxData npxData, String callbackUrl, String cvv, Integer searchCount,
			ArrayList<JsonCommunicationData> communicationData, ArrayList<TransactionDetail> transactions, String getQRCode, String qRCode) {
		super();
		this.retrievalRef = retrievalRef;
		this.mti = mti;
		this.searchId = searchId;
		this.processCode = processCode;
		this.targetAmount = targetAmount;
		this.stan = stan;
		this.transactionTime = transactionTime;
		this.transactionDate = transactionDate;
		this.entryMode = entryMode;
		this.conditionCode = conditionCode;
		this.institutionCode = institutionCode;
		this.cardSequenceNumber = cardSequenceNumber;
		this.track2Data = track2Data;
		this.iccData = iccData;
		this.pin = pin;
		this.responseCode = responseCode;
		this.approvalCode = approvalCode;
		this.tid = tid;
		this.mid = mid;
		this.payDetails = payDetails;
		this.sofUri = sofUri;
		this.userData = userData;
		this.sig = sig;
		this.transmissionTime = transmissionTime;
		this.settlementDate = settlementDate;
		this.captureDate = captureDate;
		this.nii = nii;
		this.acceptorName = acceptorName;
		this.loyaltyData = loyaltyData;
		this.invoiceRef = invoiceRef;
		this.npxData = npxData;
		this.callbackUrl = callbackUrl;
		this.cvv = cvv;
		this.searchCount = searchCount;
		this.communicationData = communicationData;
		this.transactions = transactions;
		this.getQRCode = getQRCode;
		this.qRCode = qRCode;
	}



	public String getRetrievalRef() {
		return retrievalRef;
	}

	public void setRetrievalRef(String retrievalRef) {
		this.retrievalRef = retrievalRef;
	}

	public String getMti() {
		return mti;
	}

	public void setMti(String mti) {
		this.mti = mti;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(String targetAmount) {
		this.targetAmount = targetAmount;
	}

	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getEntryMode() {
		return entryMode;
	}

	public void setEntryMode(String entryMode) {
		this.entryMode = entryMode;
	}

	public String getConditionCode() {
		return conditionCode;
	}

	public void setConditionCode(String conditionCode) {
		this.conditionCode = conditionCode;
	}

	public String getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPayDetails() {
		return payDetails;
	}

	public void setPayDetails(String payDetails) {
		this.payDetails = payDetails;
	}

	public String getSofUri() {
		return sofUri;
	}

	public void setSofUri(String sofUri) {
		this.sofUri = sofUri;
	}

	public String getUserData() {
		return userData;
	}

	public void setUserData(String userData) {
		this.userData = userData;
	}

	public String getSig() {
		return sig;
	}

	public void setSig(String sig) {
		this.sig = sig;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransmissionTime() {
		return transmissionTime;
	}

	public void setTransmissionTime(String transmissionTime) {
		this.transmissionTime = transmissionTime;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getCaptureDate() {
		return captureDate;
	}

	public void setCaptureDate(String captureDate) {
		this.captureDate = captureDate;
	}

	public String getNii() {
		return nii;
	}

	public void setNii(String nii) {
		this.nii = nii;
	}

	public String getAcceptorName() {
		return acceptorName;
	}

	public void setAcceptorName(String acceptorName) {
		this.acceptorName = acceptorName;
	}

	public String getLoyaltyData() {
		return loyaltyData;
	}

	public void setLoyaltyData(String loyaltyData) {
		this.loyaltyData = loyaltyData;
	}

	public String getInvoiceRef() {
		return invoiceRef;
	}

	public void setInvoiceRef(String invoiceRef) {
		this.invoiceRef = invoiceRef;
	}

	public JsonNpxData getNpxData() {
		return npxData;
	}

	public void setNpxData(JsonNpxData npxData) {
		this.npxData = npxData;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getCardSequenceNumber() {
		return cardSequenceNumber;
	}

	public void setCardSequenceNumber(String cardSequenceNumber) {
		this.cardSequenceNumber = cardSequenceNumber;
	}

	public String getTrack2Data() {
		return track2Data;
	}

	public void setTrack2Data(String track2Data) {
		this.track2Data = track2Data;
	}

	public String getIccData() {
		return iccData;
	}

	public void setIccData(String iccData) {
		this.iccData = iccData;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getCVV() {
		return pin;
	}

	public void setCVV(String cvv) {
		this.cvv = cvv;
	}

	public ArrayList<JsonCommunicationData> getCommunicationData() {
		return communicationData;
	}

	public void setCommunicationData(ArrayList<JsonCommunicationData> communicationData) {
		this.communicationData = communicationData;
	}

	public ArrayList<TransactionDetail> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<TransactionDetail> transactions) {
		this.transactions = transactions;
	}

	public Integer getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(Integer searchCount) {
		this.searchCount = searchCount;
	}

	public String getGetQRCode() {
		return getQRCode;
	}

	public void setGetQRCode(String getQRCode) {
		this.getQRCode = getQRCode;
	}

	public String getqRCode() {
		return qRCode;
	}

	public void setqRCode(String qRCode) {
		this.qRCode = qRCode;
	}

}
