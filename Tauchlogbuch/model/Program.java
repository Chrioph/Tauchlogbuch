public class Program {

	private MenuState menuState;

	private ArrayList<Entry> entries;

	private EntryStatistic[] entryStatistic;


	//Getter and Setter

	public Entry getEntry(int entryID){
		Iterator<Entry> it = new Iterator<Entry>();
		for(int i = 0; i < entryID; i++){
			it.next();
		}
		return it;
	}

	public void setEntry(int entryID, Entry entry){
		Iterator<Entry> it = new Iterator<Entry>();
		for(int i = 0; i < entryID; i++){
			it.next();
		}
		it = entry;
	}

	public ArrayList<Entry> getEntries() {
		return entries;
	}
}
