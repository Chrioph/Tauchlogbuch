public class EntryController {

	private EntryAUI entryAUI;

	private ProgramController programController;



	public EntryController(ProgramController programController){
		this.programController = programController;
	}


	public Entry addEntry(Entry entry) {
		//Der übergebene Entry wird bereits in der View-Klasse erstellt
		programController.getProgram().getEntries().add(entry);
	}


	/*
	Es gitb alle veränderbaren Attribute der Entries jeweils als Attribute , demenstsprechend wird
	dann die jeweilige Methode aufgerufen, welche den Attribut in Entry dann ändert, die entryID
	wird benötigt, damit man weiß, wo sich der Eintrag im Entry-Array im Programm befindet.
	 */

	public void editEntry(int entryID, String date) {
		programController.getProgram().getEntry(entryID).setDate(date);
	}
	public void editEntry(int entryID, String time) {
		programController.getProgram().getEntry(entryID).setTime(time);
	}
	public void editEntry(int entryID, String location) {
		programController.getProgram().getEntry(entryID).setLocation(location);
	}
	public void editEntry(int entryID, int duration) {
		programController.getProgram().getEntry(entryID).setDuration(duration);
	}
	public void editEntry(int entryID, float maxDepth) {
		programController.getProgram().getEntry(entryID).setMaxDepth(maxDepth);
	}
	public void editEntry(int entryID, String tauchpartner, int tauchpartnerNr) {
		programController.getProgram().getEntry(entryID).setTauchpartner(tauchpartnerNr, tauchpartner);
	}


}
