package model;

import java.io.Serializable;

public class Statistic implements Serializable {

	private int avgTime;

	private float maxDepth;

	private  float avgPartners;

	private int maxTime;

	private int coldestTemp;

	private int warmestTemp;

	private int timeSum;

	private float avgTemp;


	public Statistic(){
		avgTime=0;
		maxDepth=0;
		avgPartners=0;
		maxTime=0;
		coldestTemp=0;
		warmestTemp=0;
		timeSum=0;
	}

	//Getter and Setter


	public int getTimeSum() {
		return timeSum;
	}

	public void setTimeSum(int timeSum) {
		this.timeSum = timeSum;
	}

	public int getAvgTime() {
		return avgTime;
	}

	public void setAvgTime(int avgTime) {
		this.avgTime = avgTime;
	}

	public float getMaxDepth() {
		return maxDepth;
	}

	public void setMaxDepth(float maxDepth) {
		this.maxDepth = maxDepth;
	}

	public float getAvgPartners() {
		return avgPartners;
	}

	public void setAvgPartners(float avgPartners) {
		this.avgPartners = avgPartners;
	}


	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}

	public int getColdestTemp() {
		return coldestTemp;
	}

	public void setColdestTemp(int coldestTemp) {
		this.coldestTemp = coldestTemp;
	}

	public int getWarmestTemp() {
		return warmestTemp;
	}

	public void setWarmestTemp(int warmestTemp) {
		this.warmestTemp = warmestTemp;
	}

    public float getAvgTemp() { return avgTemp;
    }

    public void setAvgTemp(float avgTemp){ this.avgTemp = avgTemp;}
}
