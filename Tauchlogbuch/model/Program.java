package model;

import java.util.ArrayList;

public class Program {

	private ArrayList<Entry> entries;

	private ArrayList<Statistic> entryStatistic;

	public Program(){
		entries = new ArrayList<Entry>();
		entryStatistic = new ArrayList<Statistic>();
	}
	//Getter and Setter

	public Entry getEntry(int entryID){
		return entries.get(entryID);
	}

	public void setEntry(int entryID, Entry entry){
		entries.set(entryID, entry);
	}

	public ArrayList<Entry> getEntries() {
		return entries;
	}
}
