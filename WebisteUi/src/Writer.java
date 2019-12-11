import java.io.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class Writer {
	private ArrayList<Movie> movies;
	/**
	 * @param fileName
	 * @param movies
	 * @author Luke Freeman
	 * Writes to a text file using an ArrayList, has to be implemented using the buttons
	 * taken from last assignment pretty much, extremely similar, has to be adapted for this one
	 */
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
	/**
	 * 
	 * @param fileName
	 * @param movies
	 * @author Luke Freeman
	 * Writes to a JSON file using an ArrayList, has to use the other button on the south panel, 
	 * can be done using the last assignment, very similar
	 */
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
