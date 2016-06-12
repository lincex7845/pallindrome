/**
 * 
 */
package com.mera.palindrome.api.dto;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

/**
 * @author DavidCamilo
 * <p>
 * This DTO wraps the answers required
 * for every task in the palindrome challenge
 * </p>
 */
public class PalindromeDTO {
	
	/**
	 * This map holds the integer number which binary representation is a palindrome 
	 */
	private volatile Map<BigInteger, String> palindromeStrings;
	
	/**
	 * The required iterations to find the answer
	 */
	private volatile BigInteger iterations;
	
	/**
	 * A brief explanation about the complexity of the algorithm in Big O notation
	 */
	private String bigOComplexity;
	
	public PalindromeDTO(){
		this.palindromeStrings = new TreeMap<>();
		this.bigOComplexity = StringUtils.EMPTY;
		this.iterations = BigInteger.ZERO;
	}
	
	/**
	 * This method add a new entry into palidrome strings collections
	 * @param number
	 * @param palindromeString
	 */
	public synchronized void addPalindromeString(BigInteger number, String palindromeString){
		this.palindromeStrings.put(number, palindromeString);
	}
	
	/**
	 * This method add a new iteration
	 */
	public synchronized void addIteration(){
		this.iterations = iterations.add(BigInteger.ONE);
	}
	
	/**
	 * @return the palindromeStrings
	 */
	public Map<BigInteger, String> getPalindromeStrings() {
		return palindromeStrings;
	}

	/**
	 * @return the iterations
	 */
	public BigInteger getIterations() {
		return iterations;
	}

	/**
	 * @return the bigOComplexity
	 */
	public String getBigOComplexity() {
		return bigOComplexity;
	}

	/**
	 * @param palindromeStrings the palindromeStrings to set
	 */
	public void setPalindromeStrings(Map<BigInteger, String> palindromeStrings) {
		this.palindromeStrings = palindromeStrings;
	}

	/**
	 * @param itterations the iterations to set
	 */
	public void setItterations(BigInteger iterations) {
		this.iterations = iterations;
	}

	/**
	 * @param bigOComplexity the bigOComplexity to set
	 */
	public void setBigOComplexity(String bigOComplexity) {
		this.bigOComplexity = bigOComplexity;
	}
	
}