package control;

import model.Entry;
import view.EntryAUI;

import java.util.ArrayList;

public class EntryController {

	private EntryAUI entryAUI;

	private ProgramController programController;


	//TODO Search-Funktionen implementieren
	public EntryController(ProgramController programController){
		this.programController = programController;
	}

	public ArrayList<Entry> searchEntryByNumber(int number){
		return null;
	}

	public ArrayList<Entry> searchEntryByDay(String day){
		return null;
	}

	public ArrayList<Entry> searchEntryByLocation(String location){
		return null;
	}

	public ArrayList<Entry> searchEntryByBuddy(String buddy){
		return null;
	}


	//Es muss sichergestellt werden(in der view), dass, wenn wenger als 4 Suchkriterien angegeben werden, entryLists
	//mit allen Eintraegen uebergeben werden.
	public ArrayList<Entry> mergeSearchCriteria(ArrayList<Entry> entryList1, ArrayList<Entry> entryList2,
												ArrayList<Entry> entryList3, ArrayList<Entry> entryList4){
		ArrayList<Entry> resultList = intersect(entryList1,entryList2);
		resultList = intersect(resultList,entryList3);
		resultList = intersect(resultList,entryList4);

		return resultList;
	}


	//TODO Schnittfunktion implementieren
	private ArrayList<Entry> intersect(ArrayList<Entry> entryList1, ArrayList<Entry> entryList2) {

	    return null;
	}


	public void addEntry(Entry entry) {
		//Der Uebergebene Entry wird bereits in der View-Klasse erstellt
		programController.getProgram().getEntries().add(entry);
	}



	/*
	Es gitb alle veraenderbaren Attribute der Entries jeweils als Attribute , demenstsprechend wird
	dann die jeweilige Methode aufgerufen, welche den Attribut in Entry dann aendert, die entryID
	wird benoetigt, damit man weiss, wo sich der Eintrag im Entry-Array im Programm befindet.
	 */

	public void editEntryDate(int entryID, String date) {
		programController.getProgram().getEntry(entryID).setDate(date);
	}
	public void editEntryTime(int entryID, String time) {

		programController.getProgram().getEntry(entryID).setTime(time);
	}
	public void editEntryLocation(int entryID, String location) {
		programController.getProgram().getEntry(entryID).setLocation(location);
	}
	public void editEntryDuration(int entryID, int duration) {
		programController.getProgram().getEntry(entryID).setDuration(duration);
	}
	public void editEntryMaxDepth(int entryID, float maxDepth) {
		programController.getProgram().getEntry(entryID).setMaxDepth(maxDepth);
	}
	public void editEntryTauchpartner(int entryID, String tauchpartner, int tauchpartnerNr) {
		programController.getProgram().getEntry(entryID).setTauchpartner(tauchpartnerNr, tauchpartner);
	}


}
