package com.mera.palindrome.api.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import io.dropwizard.Configuration;
import io.dropwizard.testing.junit.DropwizardAppRule;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mera.palindrome.api.ApiEntryPoint;
import com.mera.palindrome.api.dto.PalindromeDTO;
import com.mera.palindrome.api.utils.StringsUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class PalindromeIntegrationTest {

	@ClassRule
	public static final DropwizardAppRule<Configuration> RULE = new DropwizardAppRule<Configuration>(
			ApiEntryPoint.class, "../palindrome-configuration.yml");

	private static String PALINDROME_URL_V1;
	
	private static String PALINDROME_URL_V2;
	
	private static Client CLIENT;
	
	private static Gson GSON;
	
	@BeforeClass
	public static void setUp(){
		PALINDROME_URL_V1 = String.format(
				"http://localhost:%d/palindrome/v1/range", RULE.getLocalPort());
		PALINDROME_URL_V2 = String.format(
				"http://localhost:%d/palindrome/v2/range", RULE.getLocalPort());
		CLIENT = new Client();;
		GSON = new GsonBuilder().create(); 
	}

	@Test
	public void testGetBinaryPalindromesBetweenRange() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("min", "1");
		params.add("max", "1000000");
		WebResource resource = CLIENT.resource(PALINDROME_URL_V1).queryParams(params);		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
		int status = response.getStatus();
		assertEquals(200, status);
		String entity = response.getEntity(String.class);
		assertFalse(StringsUtil.isBlankString(entity));
		System.out.println(entity);
		PalindromeDTO palindromeResponse = GSON.fromJson(entity, PalindromeDTO.class);
		assertNotNull(palindromeResponse);
	}
	
	@Test
	public void testGetBinaryPalindromesBetweenRangeInParallel() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		params.add("min", "1");
		params.add("max", "1000000");
		WebResource resource = CLIENT.resource(PALINDROME_URL_V2).queryParams(params);		
		ClientResponse response = resource
				.type(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
		int status = response.getStatus();
		assertEquals(200, status);
		String entity = response.getEntity(String.class);
		assertFalse(StringsUtil.isBlankString(entity));
		System.out.println(entity);
		PalindromeDTO palindromeResponse = GSON.fromJson(entity, PalindromeDTO.class);
		assertNotNull(palindromeResponse);
	}
}
