package com.robotrade.mocktrader.AWS_SQS;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AWSSQSConfiguration {

	@Autowired
	private AWSCredentialsProviderImpl awsCredentialsProvider;

	@Bean
	public AWSCredentialsRetriever retriever() {
		return new AWSCredentialsRetriever();
	}

	@Bean
	public AmazonSQS buildSQS() {
		/*
		 * Create a new instance of the builder with all defaults (credentials
		 * and region) set automatically. For more information, see
		 * Creating Service Clients in the AWS SDK for Java Developer Guide.
		 */

		return AmazonSQSClientBuilder.standard()
						.withCredentials(this.awsCredentialsProvider)
						.withRegion("eu-west-1")
						.build();
	}

	@Bean
	public SQSFIFOJavaClient client() {
		return new SQSFIFOJavaClient();
	}
}
