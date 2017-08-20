/**
 * https://github.com/DaniVSainz
 * @Author danivsainz@gmail.com
 */
package jsonCreator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import github.GithubUser;

/**
 * @author daniel
 *
 */
public class JsonCreator {
	List gsonList;
	JsonArray myArray;
		
	public  void oneString(String user,ArrayList dates,ArrayList commits) throws IOException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		for(int i=0;i<dates.size();i++) {
			GithubUser day = new GithubUser();
			day.date=dates.get(i).toString();
			day.commit=commits.get(i).toString();
			gson.toJsonTree(day);
			System.out.println(gson.toString());
		}

	    try (Writer writer = new FileWriter("Output.json")) {
	    gson.toJson(myArray, writer);
	    }	
	}
}
