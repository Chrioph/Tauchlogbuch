package model;

import java.io.Serializable;

public class Entry implements Serializable {

	private int number;

	private String date;

	private String time;

	private String location;

	private int duration;

	private float maxDepth;

	private int temperature;

	private String[] buddies;

	private String comment;

	public Entry(int number, String date, String time, String location, int duration, float maxDepth, int temperature, String[] buddies, String comment){
		this.number=number;
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

	public int getNumber() {
		return number;
	}

	public void setEntryID(int number) {
		this.number = number;
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

	public String getComment(){
		return comment;
	}

}
