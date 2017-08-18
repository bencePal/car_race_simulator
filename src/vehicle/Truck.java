package vehicle;

import java.util.Random;

public class Truck {
    private int speed, breakdownTurnsLeft, distanceTraveled;
    private String name;

    public Truck() {
        this.name = "" + getRandomNumber();
        this.speed = 100;
        this.distanceTraveled = 0;
        this.breakdownTurnsLeft = 0;
    }

    public void moveForAnHour() {
        distanceTraveled += speed;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return "Truck";
    }
    public int getDistanceTraveled() {
        return distanceTraveled;
    }
    public int getRandomNumber() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(1001);
    }

    public void breakdownTurnsLeft() {
        this.breakdownTurnsLeft += 200;
        this.distanceTraveled -= 200;
    }

    public int getBreakdownTurnsLeft() {
        return breakdownTurnsLeft;
    }
}
