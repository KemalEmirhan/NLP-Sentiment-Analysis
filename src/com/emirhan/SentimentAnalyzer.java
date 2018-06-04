package com.emirhan;

import java.util.Properties;

import org.ejml.simple.SimpleMatrix;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class SentimentAnalyzer {

	public static SentimentResult getSentimentResult(String text) {

		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, sentiment");
		StanfordCoreNLP pipeLine = new StanfordCoreNLP(props);

		SentimentResult sentimentResult = new SentimentResult();
		SentimentClassification sentimentClass = new SentimentClassification();

		if (text != null && text.length() > 0) {
			Annotation annotation = pipeLine.process(text);

			for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
				Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
				SimpleMatrix simpleMatrix = RNNCoreAnnotations.getPredictions(tree);
				String sentimentType = sentence.get(SentimentCoreAnnotations.SentimentClass.class);

				sentimentClass.setVeryPositive((double) Math.round(simpleMatrix.get(4) * 100d));
				sentimentClass.setPositive((double) Math.round(simpleMatrix.get(3) * 100d));
				sentimentClass.setNeutral((double) Math.round(simpleMatrix.get(2) * 100d));
				sentimentClass.setNegative((double) Math.round(simpleMatrix.get(1) * 100d));
				sentimentClass.setVeryNegative((double) Math.round(simpleMatrix.get(0) * 100d));

				sentimentResult.setSentimentScore(RNNCoreAnnotations.getPredictedClass(tree));
				sentimentResult.setSentimentType(sentimentType);
				sentimentResult.setSentimentClass(sentimentClass);
			}
		}
		return sentimentResult;
	}

}
