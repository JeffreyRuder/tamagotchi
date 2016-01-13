import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Tamagotchi {

  private String mName;
  private int mFoodLevel = 10;
  private int mSleepLevel = 10;
  private int mFunLevel = 10;
  private Timer mTimer;
  private TimerTask mTimerTask;
  private static final int MAX_FOOD = 10;
  private static final int MAX_SLEEP = 10;
  private static final int MAX_FUN = 10;
  private static final int LIFESPAN_CONSTANT = 600;

  public Tamagotchi(String name) {
    mName = name;
    mTimer = new Timer();
    mTimerTask = new ReduceStats();
    mTimer.schedule(mTimerTask, 0, LIFESPAN_CONSTANT);
  }

  public String getName() {
    return mName;
  }

  public int getFoodLevel() {
    return mFoodLevel;
  }

  public int getSleepLevel() {
    return mSleepLevel;
  }

  public int getFunLevel() {
    return mFunLevel;
  }

  public void decFood() {
    mFoodLevel--;
  }

  public void decSleep() {
    mSleepLevel--;
  }

  public void decFun() {
    mFunLevel--;
  }

  public void addFood() {
    mFoodLevel++;
  }

  public void addFood(int food) {
    mFoodLevel += food;
    if (mFoodLevel > MAX_FOOD) {
      mFoodLevel = MAX_FOOD;
    }
  }

  public void addSleep() {
    mSleepLevel++;
  }

  public void addSleep(int sleep) {
    mSleepLevel += sleep;
    if (mSleepLevel > MAX_SLEEP) {
      mSleepLevel = MAX_SLEEP;
    }
  }

  public void addFun() {
    mFunLevel++;
  }

  public void addFun(int fun) {
    mFunLevel += fun;
    if (mFunLevel > MAX_FUN) {
      mFunLevel = MAX_FUN;
    }
  }

  public void setFood(int food) {
    mFoodLevel = food;
    if (mFoodLevel > MAX_FOOD) {
      mFoodLevel = MAX_FOOD;
    }
  }

  public void setSleep(int sleep) {
    mSleepLevel = sleep;
    if (mSleepLevel > MAX_SLEEP) {
      mSleepLevel = MAX_SLEEP;
    }
  }

  public void setFun(int fun) {
    mFunLevel = fun;
    if (mFunLevel > MAX_FUN) {
      mFunLevel = MAX_FUN;
    }
  }

  public ArrayList<Integer> getStatus() {
    ArrayList<Integer> status = new ArrayList<Integer>();
    status.add(mFoodLevel);
    status.add(mSleepLevel);
    status.add(mFunLevel);
    return status;
  }

  public boolean isDead() {
    ArrayList<Integer> status = this.getStatus();
    for (Integer i : status) {
      if (i <= 0) {
        return true;
      }
    }
    return false;
  }

  public Timer getTimer() {
    mTimer = new Timer();
    return mTimer;
  }

  public void cancelTimer() {
    mTimer.cancel();
  }

  public class ReduceStats extends TimerTask {
    @Override
    public void run() {
      decFood();
      decSleep();
      decFun();
    }
  }
}
