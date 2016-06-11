package com.mera.palindrome.api;

import com.mera.palindrome.api.resources.PalindromeResource;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * 
 * @author DavidCamilo
 *
 * <p>The entry point to start RESTFul Palindrome API</p>
 */
public class ApiEntryPoint extends Application<Configuration>{
	
	/**
	 * Main method to start the application
	 * 
	 * @param args
	 * @throws Exception
	 */
    public static void main( String[] args ) throws Exception
    {
        new ApiEntryPoint().run(args);
    }

    /*
     * (non-Javadoc)
     * @see io.dropwizard.Application#initialize(io.dropwizard.setup.Bootstrap)
     */
	@Override
	public void initialize(Bootstrap<Configuration> bootstrap) {
		// empty		
	}

	/*
	 * (non-Javadoc)
	 * @see io.dropwizard.Application#run(io.dropwizard.Configuration, io.dropwizard.setup.Environment)
	 */
	@Override
	public void run(Configuration configuration, Environment environment)
			throws Exception {
		final PalindromeResource palindromeService = new PalindromeResource();
		environment.jersey().register(palindromeService);
	}
}
