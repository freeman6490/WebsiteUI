import java.io.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class Writer {
	private ArrayList<Movie> movies;
	public static boolean writeToTextFle(String fileName, ArrayList<Movie> movies) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
				for (Movie movie : movies) {
					pw.println(movies);
				}
				pw.close();
				return true;
		} catch (Exception ex) {
			return false;
		}
	}
	public static boolean writeToJSON(String fileName, ArrayList<Movie> movies) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter (fileName)));
			JSONArray array = new JSONArray();
			for (Movie movie : movies) {
				JSONObject object = new JSONObject();
				//only pulling html at this point
				array.add(object);
				return true;
			}
		} catch (Exception ex) {
		}
		return false;
	}
}
