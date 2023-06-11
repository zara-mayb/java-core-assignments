package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
	public Physician(Integer id) {
		super(id);
	}
    // TO DO: Implement HIPAACompliantUser!
	public boolean assignPin(int pin) {
		if (Integer.toString(pin).length() == 4){
            this.pin = pin;
            return true;
        } else {
        	return false;
        }
	}
	public boolean accessAuthorized(Integer authID) {
		if(id == authID) {
			return true;
		} else {
			return false;
		}
	}
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format("Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters
    public void setPatientNotes( ArrayList<String> patientNotes) {
    	this.patientNotes = patientNotes;
    }
    public ArrayList<String> getPatientNotes(){
    	return patientNotes;
    }
}
