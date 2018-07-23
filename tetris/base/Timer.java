package base;

public class Timer implements Runnable{
  private boolean triggered = false;
  private int deltaT;
  
  public Timer(int deltaT) {
    this.deltaT = deltaT;
  }
  
  @Override
  public void run() {
    try{
      while (true) {
        Thread.sleep(this.deltaT);
        this.triggered = true;
      }
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  public boolean isTriggered() {
    return this.triggered;
  }
  
  public void reset() {
    this.triggered = false;
  }
}
