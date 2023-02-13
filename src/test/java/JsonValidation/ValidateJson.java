package JsonValidation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Utility.Payload;
import io.restassured.path.json.JsonPath;

public class ValidateJson {
	Object obj1;
	int num=0,num1=0;
	@Test(priority=1)
	public void valodateCountry() throws FileNotFoundException, IOException, ParseException {



		JsonPath js=new JsonPath(Payload.PlayerList());//Defining the json payload in the Reusable class
		List list = new ArrayList();//creating an Arraylist to store the country value
		int count=js.getInt("player.size()");
		System.out.println("No of player is::"+count);
		for(int i=0; i <count; i++) {//Iterating over the country and increment the counter if Country is not India

			String country=js.getString("player["+i+"].country");
			list.add(country);
			System.out.println("&&&&&&:"+list.get(i));
			if(list.get(i).toString().equalsIgnoreCase("India"))
				System.out.println("Country is India");
			else {
				num=num+1;




			}

		}
		System.out.println("Number of foreign country:"+num); 
		//              

	}

	
	@Test(priority=2)
	public void countNoOfWicketkeeper() {
		JsonPath js=new JsonPath(Payload.PlayerList());//Defining the json payload in the Reusable class
		List list = new ArrayList();//creating an Arraylist to store the country value
		int count=js.getInt("player.size()");
		System.out.println("No of player is::"+count);
		for(int i=0; i <count; i++) {//Iterating over the country and increment the counter if Country is not India

			String role=js.getString("player["+i+"].role");
			list.add(role);
			System.out.println("&&&&&&:"+list.get(i));
			if(list.get(i).toString().equalsIgnoreCase("Wicket-keeper")) {
				 
				num1=num1+1;
			break;

	}
			else
				System.out.println("No wicket keeper is there");
		
	}
		System.out.println("No of Wicket-keeper in the team is: "+num1);
}
}

//          
