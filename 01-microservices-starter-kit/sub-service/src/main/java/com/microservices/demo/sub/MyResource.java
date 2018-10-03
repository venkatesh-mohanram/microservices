package com.microservices.demo.sub;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("execute")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response execute(
    		@QueryParam("param1") int param1,
    		@QueryParam("param2") int param2
    		) {
    	int result = param1 - param2;
    	JSONObject r = new JSONObject("{result:"+result+ "}");
        return Response.ok().entity(r.toString()).build();
    }
}
