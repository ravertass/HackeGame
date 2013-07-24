package model;

import org.lwjgl.Sys;

public class Timer {
	// Ska se till att uträkningarna i Model sker enligt bestämd tid
	
	private long lastFrame = getTime();
	
	private long getTime() {
		return Sys.getTime() * 1000 / Sys.getTimerResolution();
	}
	
	public int getDelta() {
		long currentTime = getTime();
		int delta = (int) (currentTime - lastFrame);
		lastFrame = getTime();
		return delta;
	}
}
