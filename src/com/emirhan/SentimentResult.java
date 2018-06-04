package com.emirhan;

public class SentimentResult {

	private double sentimentScore;
	private String sentimentType;
	private SentimentClassification sentimentClass;

	public double getSentimentScore() {
		return sentimentScore;
	}

	public void setSentimentScore(double sentimentScore) {
		this.sentimentScore = sentimentScore;
	}

	public String getSentimentType() {
		return sentimentType;
	}

	public void setSentimentType(String sentimentType) {
		this.sentimentType = sentimentType;
	}

	public SentimentClassification getSentimentClass() {
		return sentimentClass;
	}

	public void setSentimentClass(SentimentClassification sentimentClass) {
		this.sentimentClass = sentimentClass;
	}

}
