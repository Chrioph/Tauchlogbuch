package control;


import model.*;
import view.StatisticAUI;

import java.util.ArrayList;
import java.util.ListIterator;


public class StatisticController {

	private StatisticController statisticController;

	private StatisticAUI statisticAUI;

	private ProgramController programController;

	public StatisticController(ProgramController programController){
		this.programController=programController;
	}

	public Statistic CalculateStatistic() {
		Statistic statistic= new Statistic();
		ArrayList<Entry> entryList = programController.getProgram().getEntries();
		//Setze alle Statistik-Werte mit ausgelagerten Hilfsmethoden
		statistic.setAvgPartners(calculateAvgPartners(entryList));
		statistic.setAvgTime(calculateAvgTime(entryList));
		statistic.setColdestTemp(calculateColdestTemp(entryList));
		statistic.setMaxDepth(calculateMaxDepth(entryList));
		statistic.setMaxTime(calculateMaxTime(entryList));
		statistic.setWarmestTemp(calculateWarmestTemp(entryList));
		statistic.setTimeSum(calculateTimeSum(entryList));
		statistic.setAvgTemp(calculateAvgTemp(entryList));

		return statistic;
	}

	//Ausgelagerte Hilfsmethoden zum berechnen der Statistik-Werte


	private int calculateTimeSum(ArrayList<Entry> entryList) {
		int timeSum=0;
		for(int i = 0; i<entryList.size(); i++){
			timeSum += entryList.get(i).getDuration();
		}
		return timeSum;
	}

	private float calculateAvgTemp(ArrayList<Entry> entryList){
		float tempSum=0;
		for(int i = 0; i<entryList.size(); i++){
			tempSum += entryList.get(i).getTemperature();
		}
		return tempSum/entryList.size();

	}

	private int calculateWarmestTemp(ArrayList<Entry> entryList) {
		int warmestTemp=entryList.get(0).getTemperature();
		for(int i = 1; i<entryList.size(); i++){
			if(warmestTemp < entryList.get(i).getTemperature())
				warmestTemp = entryList.get(i).getTemperature();
		}
		return warmestTemp;
	}


	private int calculateMaxTime(ArrayList<Entry> entryList) {
		int maxTime=entryList.get(0).getDuration();
		for(int i = 1; i<entryList.size(); i++){
			if(maxTime < entryList.get(i).getDuration())
				maxTime = entryList.get(i).getDuration();
		}
		return maxTime;
	}

	private float calculateMaxDepth(ArrayList<Entry> entryList) {
		float maxDepth=entryList.get(0).getDuration();
		for(int i = 1; i<entryList.size(); i++){
			if(maxDepth < entryList.get(i).getMaxDepth())
				maxDepth = entryList.get(i).getMaxDepth();
		}
		return maxDepth;
	}

	private int calculateColdestTemp(ArrayList<Entry> entryList) {
		int coldestTemp=entryList.get(0).getTemperature();
		for(int i = 1; i<entryList.size(); i++){
			if(coldestTemp > entryList.get(i).getTemperature())
				coldestTemp = entryList.get(i).getTemperature();
		}
		return coldestTemp;
	}

	private int calculateAvgTime(ArrayList<Entry> entryList) {
		return calculateTimeSum(entryList)/entryList.size();
	}


	//Berechnet die Durchschnitlliche Anzahl an Tauchpartnern für einen bestimmten Ort
	private float calculateAvgPartners(ArrayList<Entry> entryList) {
		int partnerSum=0;
		for(int i = 0; i<entryList.size(); i++){
			partnerSum += entryList.get(i).getBuddies().length;
		}
		return partnerSum/entryList.size();

	}


	//Gibt eine ArrayList mit allen Entries für einen bestimmten Ort aus
	private ArrayList<Entry> getEntriesFrom(String location){
		//Wenn als Ort "Alle ausgewählt wird, sollen Alle Einträge berücksichtigt werden"
		if(location=="Alle"){
			return programController.getProgram().getEntries();
		}
		//Sonst nur solche Tauchgänge die an dem ausgewählten Ort stattfanden
		ArrayList<Entry> locationEntries= new ArrayList<Entry>();
		ListIterator<Entry> it = programController.getProgram().getEntries().listIterator();
		while(it.hasNext()){
			Entry e = it.next();
			if(e.getLocation()==location)
				locationEntries.add(e);
		}
		return locationEntries;

	}

}

