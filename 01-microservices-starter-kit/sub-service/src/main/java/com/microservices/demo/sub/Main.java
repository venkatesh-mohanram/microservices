package com.microservices.demo.sub;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://0.0.0.0:80/subservice/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.microservices.demo.sub package
        final ResourceConfig rc = new ResourceConfig().packages("com.microservices.demo.sub");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try {
        	final HttpServer server = startServer();
        	
        	// Add shutdown hook to stop the server
        	Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        		
        		@Override
        		public void run() {
        			server.shutdown();
        			
        		}
        		
        	}));
        	server.start();        	
    
        	System.out.println(String.format("Jersey app started with WADL available at "
        			+ "%sapplication.wadl\nPress Ctrl + C to stop the server...", BASE_URI));
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

