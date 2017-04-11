package com.winter.project.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Circuit extends ParserHandler {
	Set<String> hs = new HashSet<String>();	
	public int inputLength()
	{	hs.clear();
		hs.addAll(inputNames);
		inputNames.clear();
		inputNames.addAll(hs);
		return inputNames.size();		
	}
	public ArrayList<String> inputArray()
	{
		return inputNames;		
	}
	public int outputLength()
	{	
		return outputNames.size();		
	}
	public ArrayList<String> outputArray()
	{
		return outputNames;		
	}

}
