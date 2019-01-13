package com.robotrade.mocktrader.AWS_SQS;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class AWSCredentialsProviderImpl implements AWSCredentialsProvider {

	@Autowired
	private AWSCredentialsRetriever awsCredentialsRetriever;

	@Override
	public AWSCredentials getCredentials() {
		return this.awsCredentialsRetriever;
	}

	@Override
	public void refresh() {

	}
}
