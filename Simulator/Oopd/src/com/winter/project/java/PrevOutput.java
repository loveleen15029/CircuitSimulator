package com.winter.project.java;

import java.util.ArrayList;

import com.winter.project.StoredCircuitEvaluator;

public class PrevOutput extends StoredCircuitEvaluator {
	public ArrayList<String> prevInputCircuit()
	{
		return inputArray;	
	}
	public ArrayList<Boolean> prevOutputCircuit()
	{
		return prevOutputProg;	
	}
}
