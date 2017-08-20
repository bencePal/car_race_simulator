package vehicle;

import java.util.Random;

public class Motorcycle {
    private int normalSpeed, distanceTraveled;
    private static int nameNumber = 1;
    private String name;


    public Motorcycle() {
        this.name = "Motorcycle " + nameNumber;
        this.normalSpeed = 100;
        this.distanceTraveled = 0;
        nameNumber++;
    }

    public void moveForAnHour() {
        distanceTraveled += normalSpeed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public String getType() {
        return "Motor";
    }

    public String getName() {
        return name;
    }

    public void setRainySpeed() {
        Random randomNumber = new Random();
        int randomSpeed = randomNumber.nextInt(50 - 5 + 1) + 5;
        normalSpeed -= randomSpeed;
    }
    public void setNormalSpeed() {
        normalSpeed = 100;
    }

}
