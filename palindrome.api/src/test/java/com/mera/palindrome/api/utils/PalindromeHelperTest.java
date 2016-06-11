/**
 * 
 */
package com.mera.palindrome.api.utils;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import com.mera.palindrome.api.dto.PalindromeDTO;
import com.mera.palindrome.api.utils.PalindromeHelper;

/**
 * @author DavidCamilo
 *
 */
public class PalindromeHelperTest {

	/**
	 * Test method for {@link com.mera.palindrome.api.utils.PalindromeHelper#getPalindromeResponse(java.math.BigInteger, java.math.BigInteger)}.
	 */
	@Test
	public void testGetPalindromeResponse() {
		BigInteger minValue = new BigInteger("1");
		BigInteger maxValue = new BigInteger("1000000");		
		PalindromeDTO response = PalindromeHelper.getPalindromeResponse(minValue, maxValue); 
		assertTrue(response.getPalindromeStrings().size() > 0);
		assertNotNull(response.getPalindromeStrings().get(new BigInteger("585")));
		assertNull(response.getPalindromeStrings().get(new BigInteger("100")));
		System.out.println("Itertions: " + response.getIterations());
		assertTrue(response.getIterations().intValue() > 0);
		System.out.println(response.getBigOComplexity());
	}

}
