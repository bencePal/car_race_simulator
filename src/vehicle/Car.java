package vehicle;

import java.util.Random;
import java.util.ArrayList;

public class Car {

    private String name;
    private int normalSpeed, distanceTraveled;

    public Car() {
        this.name = getRandomName();
        this.normalSpeed = getRandomNumber(80, 110);
        this.distanceTraveled = 0;
    }

    public static int setSpeedLimit(int limit) {
        return limit;
    }

    public void setLimitedSpeed(int limit) {
        normalSpeed = limit;
    }

    public void setNormalSpeed() {
        normalSpeed = getRandomNumber(80, 110);
    }

    public void moveForAnHour() {
        distanceTraveled += normalSpeed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public String getRandomName() {
        ArrayList<String> carNames = new ArrayList<>();
        carNames.add("Millenium");
        carNames.add("Twister");
        carNames.add("Whim");
        carNames.add("Moonlight");
        carNames.add("Thunder");
        carNames.add("Eminance");
        carNames.add("Celestial");
        carNames.add("Blend");

        String randomCarName1 = carNames.get(getRandomNumber(0, carNames.size() - 1));
        String randomCarName2 = carNames.get(getRandomNumber(0, carNames.size() - 1));

        return randomCarName1 + " " + randomCarName2;
    }

    public int getRandomNumber(int from, int to) {
        Random randomNumber = new Random();
        return randomNumber.nextInt(to - from + 1) + from;
    }

    public String getType() {
        return "Car";
    }

    public String getName() {
        return name;
    }

}
