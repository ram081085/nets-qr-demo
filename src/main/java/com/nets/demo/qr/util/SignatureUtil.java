package com.nets.demo.qr.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignatureUtil {

	private static final Logger logger = LoggerFactory.getLogger(SignatureUtil.class);
	private static final String ALGORITHM_SHA_256 = "SHA-256";

	public static String calculateSignature(String input) {
		String signature = null;

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(ALGORITHM_SHA_256);
		} catch (NoSuchAlgorithmException e) {
			logger.error("HeaderEnricherService-No Provider supports this Algorithm: ", e);
		}

		byte[] hashcode = null;
		if (md != null) {
			md.update(input.getBytes());
			hashcode = md.digest();
		}

		if (hashcode != null) {
			signature = DatatypeConverter.printBase64Binary(hashcode);
		}

		return signature;
	}

}
