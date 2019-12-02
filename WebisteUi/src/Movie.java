//https://www.amctheatres.com/showtimes/all/2019-12-02/amc-woodridge-18/all?gclid=EAIaIQobChMI_qu-pNuX5gIVRhitBh0HDgTdEAAYASAAEgICYvD_BwE&gclsrc=aw.ds&utm_campaign=online-ticketing&utm_content=marketing&utm_launch=2019-10-05&utm_medium=paidsearch&utm_source=google&utm_term=keyword
public class Movie {
	private String title, rating, language;
	private double time;
	public Movie(String title, double time, String rating, String language) {
		setTitle(title);
		setTime(time);
		setRating(rating);
		setLanguage(language);
	}
	public String getTitle() {
		return title;
	}
	public String getRating() {
		return rating;
	}
	public String getLanguage() {
		return language;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return String.format("%s, at %d, with a rating of %s, in %s",title, time, rating, language);
	}
}
