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
		
	public  void oneString(String[][] arrays) throws IOException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
	    try (Writer writer = new FileWriter("Output.json")) {
	    gson.toJson(arrays, writer);
	    }	
	}
	
	public void doubleArray(ArrayList dates,ArrayList commits) throws IOException {
		String[][] arrays = new String[372][2];

		for(int i=0;i<dates.size();i++) {
			arrays[i][0]= dates.get(i).toString();
			arrays[i][1]= commits.get(i).toString();
		}
		oneString(arrays);
	}
}
