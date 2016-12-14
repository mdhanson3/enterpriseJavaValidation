package controller;

import jdk.nashorn.internal.parser.JSONParser;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.StringReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by student on 12/14/16.
 */
@WebServlet(name = "webservice", urlPatterns = {"/webserviceservlet"})
public class webservice extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://httpbin.org/get");
        String stringResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);
        JSONObject obj ;
        String origin = "Couldn't get IP Address";
        try{
             obj = new JSONObject(stringResponse);
            //JSONArray data = obj.getJSONArray("origin");
            //JSONObject
            origin = obj.getString("origin");

        } catch(org.json.JSONException e) {

        }


        System.out.println(stringResponse);

        request.setAttribute("origin", origin);

        getServletContext().getRequestDispatcher("/webservice.jsp").forward(
                request, response);

    }
}
