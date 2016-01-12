import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class TamagotchiTest {

  @Test
  public void tamagotchiInstantiatesCorrectly_true() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    assertEquals(true, sparky instanceof Tamagotchi);
  }

  @Test
  public void tamagotchiInstatiatesWithName_expectedName() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    String expectedName = "Sparky";
    assertEquals(expectedName, sparky.getName());
  }

  @Test
  public void tamagotchiInstantiatesWithFoodLevel_true() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    assertEquals(10, sparky.getFoodLevel());
  }

  @Test
  public void tamagotchiInstantiatesWithSleepLevel_true() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    assertEquals(10, sparky.getSleepLevel());
  }

  @Test
  public void tamagotchiInstantiatesWithFunLevel_true() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    assertEquals(10, sparky.getFunLevel());
  }

  @Test
  public void decFood_9() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.decFood();
    assertEquals(9, sparky.getFoodLevel());
  }

  @Test
  public void decSleep_9() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.decSleep();
    assertEquals(9, sparky.getSleepLevel());
  }

  @Test
  public void decFun_9() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.decFun();
    assertEquals(9, sparky.getFunLevel());
  }

  @Test
  public void addFood_11() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.addFood();
    assertEquals(11, sparky.getFoodLevel());
  }

  @Test
  public void addSleep_11() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.addSleep();
    assertEquals(11, sparky.getSleepLevel());
  }

  @Test
  public void addFun_11() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.addFun();
    assertEquals(11, sparky.getFunLevel());
  }

  @Test
  public void addFood_10() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.decFood();
    sparky.decFood();
    sparky.addFood(2);
    assertEquals(10, sparky.getFoodLevel());
  }

  @Test
  public void maxFoodIs10_10() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.decFood();
    sparky.decFood();
    sparky.addFood(20);
    assertEquals(10, sparky.getFoodLevel());
  }

  @Test
  public void addSleep_10() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.decSleep();
    sparky.decSleep();
    sparky.addSleep(2);
    assertEquals(10, sparky.getSleepLevel());
  }

  @Test
  public void maxSleepIs10_10() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.decSleep();
    sparky.decSleep();
    sparky.addSleep(20);
    assertEquals(10, sparky.getSleepLevel());
  }

  @Test
  public void addFun_10() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.decFun();
    sparky.decFun();
    sparky.addFun(2);
    assertEquals(10, sparky.getSleepLevel());
  }

  @Test
  public void maxFunIs10_10() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.decFun();
    sparky.decFun();
    sparky.addFun(20);
    assertEquals(10, sparky.getFunLevel());
  }

  @Test
  public void getStatus_returnsStatus() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.decFood();
    ArrayList<Integer> sparkyStatus = sparky.getStatus();
    assertEquals((Integer)9, (Integer)sparkyStatus.get(0));
  }

  @Test
  public void setFood_SetsFoodLevelCorrectly_5() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.setFood(5);
    assertEquals(5, sparky.getFoodLevel());
  }

  @Test
  public void setSleep_SetsSleepLevelCorrectly_5() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.setSleep(5);
    assertEquals(5, sparky.getSleepLevel());
  }

  @Test
  public void setFun_SetsFunLevelCorrectly_5() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.setFun(20);
    assertEquals(10, sparky.getFunLevel());
  }

  @Test
  public void isDead_ChecksIfDead_true() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    sparky.setSleep(0);
    assertEquals(true, sparky.isDead());
  }

  @Test
  public void isDead_ChecksIfDead_false() {
    Tamagotchi sparky = new Tamagotchi("Sparky");
    assertEquals(false, sparky.isDead());
  }
}
