package Api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.RequestWrapper;

import com.sun.research.ws.wadl.Response;

import Controller.ServiceController;
import Model.Ulke;

@Path("/data")
public class DataService {

	@GET
	@Path("/getTopYuzOlcumu")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getTopNufusInJSON() {
		List<String> ulkeler = new ArrayList<String>();
		ulkeler.add("Turkiye");
		ulkeler.add("Almanya");
		ulkeler.add("Fransa");
		
		return ulkeler;
	}
	
	@GET
	@Path("{adi}")
	public String getUserById(@PathParam("adi") String adi) {
		
		return "Merhaba "+ adi;
	}
	
	@POST
	@Path("/add")
	public String addUser(
		@FormParam("name") String name,
		@FormParam("age") int age) {

		return "name:"+name+"age:"+age;

	}
	
//	@POST
//	@Path("/post")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response createTrackInJSON(Track track) {
//
//		String result = "Track saved : " + track;
//		return Response.status(201).entity(result).build();
//
//	}

}