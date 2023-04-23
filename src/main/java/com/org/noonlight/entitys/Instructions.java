package com.org.noonlight.entitys;

public class Instructions {
 private String entry;

public Instructions() {
	super();
	// TODO Auto-generated constructor stub
}

public Instructions(String entry) {
	super();
	this.entry = entry;
}

@Override
public String toString() {
	return "Instructions [entry=" + entry + "]";
}

public String getEntry() {
	return entry;
}

public void setEntry(String entry) {
	this.entry = entry;
}

}