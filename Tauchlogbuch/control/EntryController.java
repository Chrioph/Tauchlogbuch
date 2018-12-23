package control;

import java.util.ArrayList;

import control.ProgramController;
import model.Entry;
import view.EntryAUI;

public class EntryController {

	private EntryAUI entryAUI;

	private ProgramController programController;

	public EntryController(ProgramController programController){
		this.programController = programController;
	}

	public Entry searchEntryByNumber(int number){
		return programController.getProgram().getEntry(number);
	}

	public ArrayList<Entry> searchEntryByDate(String date){
		ArrayList<Entry> entryList = programController.getProgram().getEntries();
		ArrayList<Entry> results = new ArrayList<Entry>();
		for(int i = 0; i< entryList.size(); i++){
			if(entryList.get(i).getDate()==date){
				results.add(entryList.get(i));
			}
		}

		return results;
		}

	public ArrayList<Entry> searchEntryByLocation(String location){


		ArrayList<Entry> entryList = programController.getProgram().getEntries();
		if (location=="Alle")
			return entryList;
		ArrayList<Entry> results = new ArrayList<Entry>();
		for(int i = 0; i< entryList.size(); i++){
			if(entryList.get(i).getLocation()==location){
				results.add(entryList.get(i));
			}
		}

		return results;
	}

	public ArrayList<Entry> searchEntryByBuddy(String buddy){
		ArrayList<Entry> entryList = programController.getProgram().getEntries();
		ArrayList<Entry> results = new ArrayList<Entry>();
		for(int i = 0; i< entryList.size(); i++){
			for(int j = 0; j < programController.getProgram().getEntry(i).getBuddies().length; j++){
				if(programController.getProgram().getEntry(i).getBuddies()[j] == buddy){
					results.add(entryList.get(i));
				}
			}
		}
		return results;
	}





	//Es muss sichergestellt werden(in der view), dass, wenn wenger als 4 Suchkriterien angegeben werden, entryLists
	//mit allen Eintraegen uebergeben werden.
	public ArrayList<Entry> mergeSearchCriteria(String day, String location, String buddy){
		ArrayList<Entry> resultList = intersect(searchEntryByDate(day), searchEntryByLocation(location));
		resultList = intersect(resultList, searchEntryByBuddy(buddy));

		return resultList;
	}



	public ArrayList<Entry> intersect(ArrayList<Entry> entryList1, ArrayList<Entry> entryList2) {
        ArrayList<Entry> resultList= new ArrayList<Entry>();
        for (int i = 0; i < entryList1.size(); i++){
            for(int j = 0; j < entryList2.size(); j++){
                if (entryList1.get(i) == entryList2.get(j)){
                    resultList.add(entryList1.get(i));
                }
            }
        }


	    return resultList;
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
	public void editEntryTauchpartner(int entryID, int buddyNr, String buddy) {
		programController.getProgram().getEntry(entryID).setBuddy(buddyNr, buddy);
	}


}
