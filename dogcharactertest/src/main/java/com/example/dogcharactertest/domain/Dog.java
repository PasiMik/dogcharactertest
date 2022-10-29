package com.example.dogcharactertest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dog {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String testDate;
	private String breed;
	private String dogName;
	private String regNumber;
	private String capability;
	private String aggBehaviour;
	private String defence;
	private String fight;
	private String nerves;
	private String temperament;
	private String hardness;
	private String accessibility;
	private String shotTolerance;
	private int endResult;
	
	public Dog() {}

	public Dog(String testDate, String breed, String dogName, String regNumber, String capability, String aggBehaviour,
			String defence, String fight, String nerves, String temperament, String hardness, String accessibility,
			String shotTolerance, int endResult) {
		this.testDate = testDate;
		this.breed = breed;
		this.dogName = dogName;
		this.regNumber = regNumber;
		this.capability = capability;
		this.aggBehaviour = aggBehaviour;
		this.defence = defence;
		this.fight = fight;
		this.nerves = nerves;
		this.temperament = temperament;
		this.hardness = hardness;
		this.accessibility = accessibility;
		this.shotTolerance = shotTolerance;
		this.endResult = endResult;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getCapability() {
		return capability;
	}

	public void setCapability(String capability) {
		this.capability = capability;
	}

	public String getAggBehaviour() {
		return aggBehaviour;
	}

	public void setAggBehaviour(String aggBehaviour) {
		this.aggBehaviour = aggBehaviour;
	}

	public String getDefence() {
		return defence;
	}

	public void setDefence(String defence) {
		this.defence = defence;
	}

	public String getFight() {
		return fight;
	}

	public void setFight(String fight) {
		this.fight = fight;
	}

	public String getNerves() {
		return nerves;
	}

	public void setNerves(String nerves) {
		this.nerves = nerves;
	}

	public String getTemperament() {
		return temperament;
	}

	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}

	public String getHardness() {
		return hardness;
	}

	public void setHardness(String hardness) {
		this.hardness = hardness;
	}

	public String getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(String accessibility) {
		this.accessibility = accessibility;
	}

	public String getShotTolerance() {
		return shotTolerance;
	}

	public void setShotTolerance(String shotTolerance) {
		this.shotTolerance = shotTolerance;
	}

	public int getEndResult() {
		return endResult;
	}

	public void setEndResult(int endResult) {
		this.endResult = endResult;
	}
	
	
	
	
	
	
	
	

}
