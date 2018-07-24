package time;

public class Time {
	
	public static int fps = 60;
	public static double timePerTick = 1000000000 / fps;
	public static double delta = 0;
	public static long now = 0;
	public static long lastTime = System.nanoTime();
	public static long timer = 0;
	public static int ticks = 0;
	
}