package com.softwarelma.ers.main;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/message")
public class ErsMainRS {

    @Context
    private HttpServletRequest request;

    @GET
    @Path("/{param}")
    public Response printMessage(@PathParam("param") String msg) {
        // request.getRemoteAddr()
        String result = "Restful example : " + msg;
        return Response.status(200).entity(result).build();
    }

}
