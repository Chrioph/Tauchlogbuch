package control;

import model.Program;

public class ProgramController {

	private EntryController entryController;
	private StatisticController statisticController;
	private Program program;


	public ProgramController() {
		program = new Program();
		entryController=new EntryController(this);
		statisticController = new StatisticController(this);
	}

	public ProgramController(Program program) {
		this.program = program;
		entryController=new EntryController(this);
		statisticController = new StatisticController(this);
	}


	//Getter and Setter


	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public EntryController getEntryController() {
		return entryController;
	}

	public void setEntryController(EntryController entryController) {
		this.entryController = entryController;
	}

	public StatisticController getStatisticController() {
		return statisticController;
	}

	public void setStatisticController(StatisticController statisticController) {
		this.statisticController = statisticController;
	}
}
