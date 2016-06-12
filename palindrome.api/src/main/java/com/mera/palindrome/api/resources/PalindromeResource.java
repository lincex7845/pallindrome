/**
 * 
 */
package com.mera.palindrome.api.resources;

import java.math.BigInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;

import com.codahale.metrics.annotation.Timed;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mera.palindrome.api.utils.StringsUtil;
import com.mera.palindrome.api.utils.PalindromeHelper;

/**
 * @author DavidCamilo
 *
 */
@Path("/palindrome")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PalindromeResource {

	/**
	 * The logger instance
	 */
	private static final Logger LOGGER = Logger
			.getLogger(PalindromeResource.class);

	/**
	 * Used to serialize data to json format
	 */
	private static final Gson GSON = new GsonBuilder().create();

	/**
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@GET
	@Timed
	@Path("/v1/range")
	public Response getBinaryPalindromesBetweenRange(
			@QueryParam("min") @NotEmpty String min,
			@QueryParam("max") @NotEmpty String max) {
		Response response;
		int status = 0;
		String entity = StringUtils.EMPTY;
		try {
			if (StringsUtil.isAnIntegerNumber(min)
					&& StringsUtil.isAnIntegerNumber(max)) {
				BigInteger minValue = new BigInteger(min);
				BigInteger maxValue = new BigInteger(max);
				if (minValue.compareTo(maxValue) < 0) {
					status = Response.Status.OK.getStatusCode();
					entity = GSON.toJson(PalindromeHelper.getPalindromeResponse(minValue, maxValue));
					
				} else {
					status = Response.Status.BAD_REQUEST.getStatusCode();
					entity = "BAD REQUEST. Verify if the 'min' parameter is less or equals than 'max' parameter";
				}
			} else {
				status = Response.Status.BAD_REQUEST.getStatusCode();
				entity = "BAD REQUEST. Verify if the given parameters are integer numbers";
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
			entity = e.getMessage();
		}
		response = Response.status(status).entity(entity).build();
		return response;
	}
	
	/**
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	@GET
	@Timed
	@Path("/v2/range")
	public Response getBinaryPalindromesBetweenRangeInParallel(
			@QueryParam("min") @NotEmpty String min,
			@QueryParam("max") @NotEmpty String max) {
		Response response;
		int status = 0;
		String entity = StringUtils.EMPTY;
		try {
			if (StringsUtil.isAnIntegerNumber(min)
					&& StringsUtil.isAnIntegerNumber(max)) {
				BigInteger minValue = new BigInteger(min);
				BigInteger maxValue = new BigInteger(max);
				if (minValue.compareTo(maxValue) < 0) {
					status = Response.Status.OK.getStatusCode();
					entity = GSON.toJson(PalindromeHelper.getPalindromeNumberInParallel(minValue, maxValue));
					
				} else {
					status = Response.Status.BAD_REQUEST.getStatusCode();
					entity = "BAD REQUEST. Verify if the 'min' parameter is less or equals than 'max' parameter";
				}
			} else {
				status = Response.Status.BAD_REQUEST.getStatusCode();
				entity = "BAD REQUEST. Verify if the given parameters are integer numbers";
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			status = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
			entity = e.getMessage();
		}
		response = Response.status(status).entity(entity).build();
		return response;
	}
}