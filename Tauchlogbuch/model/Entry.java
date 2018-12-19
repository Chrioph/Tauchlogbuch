package model;

public class Entry {

	private int entryID;

	private String date;

	private String time;

	private String location;

	private int duration;

	private float maxDepth;

	private int temperature;

	private String[] buddies;

	private String comment;

	public Entry(int entryID, String date, String time, String location, int duration, float maxDepth, int temperature, String[] buddies, String comment){
		this.entryID=entryID;
		this.date=date;
		this.time=time;
		this.location=location;
		this.duration=duration;
		this.maxDepth=maxDepth;
		this.temperature=temperature;
		this.buddies=buddies;
		this.comment=comment;
	}

	//Getter und Setter

	public void setBuddy(int buddyNr, String tp){
		buddies[buddyNr] = tp;
	}

	public String getBuddy(int buddyNr){
		return buddies[buddyNr];
	}

	public int getTemperature() { return temperature; }

	public void setTemperature(int temperature) { this.temperature = temperature; }

	public int getEntryID() {
		return entryID;
	}

	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getMaxDepth() {
		return maxDepth;
	}

	public void setMaxDepth(float maxDepth) {
		this.maxDepth = maxDepth;
	}

	public String[] getBuddies() {
		return buddies;
	}

	public void setBuddies(String[] buddies) {
		this.buddies = buddies;
	}

}
