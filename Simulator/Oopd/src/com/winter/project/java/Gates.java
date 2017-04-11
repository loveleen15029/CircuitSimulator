package com.winter.project.java;
public class Gates {

	public boolean orGate(boolean a, boolean b){
		return (a||b) ;
	}	
	public boolean andGate(boolean a, boolean b){
		return (a&&b) ;
	}	
	public boolean notGate(boolean a){
		return (!a) ;
	}	
	public boolean exorGate(boolean a, boolean b){
		return ((a&&(!b) || ((!a)&&b))) ;
	}	
	public boolean exnorGate(boolean a, boolean b){
		return (!((a&&(!b) || ((!a)&&b)))) ;
	}	
	public boolean norGate(boolean a, boolean b){
		return (!(a||b)) ;
	}	
	public boolean nandGate(boolean a, boolean b){
		return (!(a&&b));
	}	
}
