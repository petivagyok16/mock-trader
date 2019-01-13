package com.robotrade.mocktrader.AWS_SQS;

import com.amazonaws.auth.AWSCredentials;
import org.springframework.beans.factory.annotation.Value;

public class AWSCredentialsRetriever implements AWSCredentials {

	@Value("${aws_access_key_id}")
	private String awsAccessKeyId;

	@Value("${aws_secret_access_key}")
	private String awsSecretKey;

	@Override
	public String getAWSAccessKeyId() {
		return this.awsAccessKeyId;
	}

	@Override
	public String getAWSSecretKey() {
		return this.awsSecretKey;
	}
}
