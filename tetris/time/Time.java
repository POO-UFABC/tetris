package time;

public class Time {
	
	private static int fps;
	private static double timePerTick;
	private static double delta;
	private static long now;
	private static long lastTime;
	private static long timer;
	private static int ticks;

	private static Time instance = new Time();


	private Time(){
		Time.fps = 60;
		Time.timePerTick = 1000000000 / fps;
		Time.delta = 0;
		Time.now = 0;
		Time.lastTime = System.nanoTime();
		Time.timer = 0;
		Time.ticks = 0;
	}

	public static void update(){
		Time.now = System.nanoTime();
		Time.delta += (Time.now - Time.lastTime) / Time.timePerTick;
		Time.timer += Time.now - Time.lastTime;
		Time.lastTime = Time.now;
	}

	public static void updateTimer(){
		if(Time.timer >= 1000000000) {
			Time.ticks = 0;
			Time.timer = 0;
		}
	}

	public static void updateTicksDelta(){
		Time.ticks++;
		Time.delta--;
	}

	public static Time getTime(){
		return Time.instance;
	}

	public static double getDelta(){
		return Time.delta;
	}

	public static long getNow(){
		return Time.now;
	}

	public static double getTimePerTick(){
		return Time.timePerTick;
	}
	
}