package com.nytimes.pojo;

import java.util.ArrayList;

public class Byline {
	private String organization;
	private String original;
	private ArrayList<Person> persons;

	public Byline() {
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

}