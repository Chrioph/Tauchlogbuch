package control;

import model.Entry;
import view.EntryAUI;

public class EntryController {

	private EntryAUI entryAUI;

	private ProgramController programController;



	public EntryController(ProgramController programController){
		this.programController = programController;
	}


	public void addEntry(Entry entry) {
		//Der Uebergebene Entry wird bereits in der View-Klasse erstellt
		programController.getProgram().getEntries().add(entry);
	}


	/*
	Es gitb alle veränderbaren Attribute der Entries jeweils als Attribute , demenstsprechend wird
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
