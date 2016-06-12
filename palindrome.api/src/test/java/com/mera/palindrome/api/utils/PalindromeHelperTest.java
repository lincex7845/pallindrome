/**
 * 
 */
package com.mera.palindrome.api.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.mera.palindrome.api.dto.PalindromeDTO;

/**
 * @author DavidCamilo
 *
 */
public class PalindromeHelperTest {
	
	private static final Logger LOGGER = Logger
			.getLogger(PalindromeHelperTest.class);
	
	/**
	 * Test method for {@link com.mera.palindrome.api.utils.PalindromeHelper#getPalindromeResponse(java.math.BigInteger, java.math.BigInteger)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testGetPalindromeResponse() {
		StopWatch a = new StopWatch();
		a.start();
		BigInteger minValue = BigInteger.ONE;
		BigInteger maxValue = BigInteger.valueOf(10_000_000L);
		PalindromeDTO response = PalindromeHelper.getPalindromeResponse(minValue, maxValue); 
//		assertTrue(response.getPalindromeStrings().size() == 19);
		assertNotNull(response.getPalindromeStrings().get(new BigInteger("585")));
		assertNull(response.getPalindromeStrings().get(new BigInteger("100")));
		LOGGER.info("Itertions: " + response.getIterations());
		assertTrue(response.getIterations().intValue() > 0);
		LOGGER.info("Complexity: " + response.getBigOComplexity());
		a.stop();
		LOGGER.info("Elapsed time: " + a.toString());
	}
	
	@Test
	public void testGetPalindromeResponseParallel(){
		StopWatch a = new StopWatch();
		a.start();
		BigInteger minValue = BigInteger.ONE;
		BigInteger maxValue = BigInteger.valueOf(10_000_000L);
		PalindromeDTO response = PalindromeHelper.getPalindromeNumberInParallel(minValue, maxValue);
		LOGGER.info("Palindrome Numbers: " + response.getPalindromeStrings().size());
//		assertTrue(response.getPalindromeStrings().size() == 19);
		assertNotNull(response.getPalindromeStrings().get(new BigInteger("585")));
		assertNull(response.getPalindromeStrings().get(new BigInteger("100")));
		LOGGER.info("Itertions: " + response.getIterations());
		assertTrue(response.getIterations().intValue() > 0);
		LOGGER.info("Complexity: " + response.getBigOComplexity());
		a.stop();
		LOGGER.info("Elapsed time: " + a.toString());
	}

}
