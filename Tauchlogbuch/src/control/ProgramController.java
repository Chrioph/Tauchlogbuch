package control;

import model.Program;

public class ProgramController {

	private ProgramController programController;

	private Program program;

	private StatisticController statisticController;

	private EntryController entryController;



	//Getter and Setter


	public ProgramController getProgramController() {
		return programController;
	}

	public void setProgramController(ProgramController programController) {
		this.programController = programController;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public StatisticController getStatisticController() {
		return statisticController;
	}

	public void setStatisticController(StatisticController statisticController) {
		this.statisticController = statisticController;
	}

	public EntryController getEntryController() {
		return entryController;
	}

	public void setEntryController(EntryController entryController) {
		this.entryController = entryController;
	}
}
