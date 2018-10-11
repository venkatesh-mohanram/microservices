package com.microservices.demo.swagger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;

@Api(
		value = "Calculator Resource", 
		description = "Resource to perform mathematical operations" 
	)
@Path("calculator")
public class Calculator {

	@GET
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	public CalculatorResponse addOperation(
			@QueryParam("param1") int param1,
			@QueryParam("param2") int param2) {
		CalculatorResponse res = new CalculatorResponse();
		res.setResult(param1 + param2);
		res.setMessage("Have a nice day!");
		return res;
	}
}
