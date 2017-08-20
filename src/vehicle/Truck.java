package vehicle;

import java.util.Random;

public class Truck {
    private int speed, breakdownTurnsLeft, distanceTraveled, counter;
    private String name;

    public Truck() {
        this.name = "" + getRandomNumber();
        this.speed = 100;
        this.distanceTraveled = 0;
        this.breakdownTurnsLeft = 0;
        this.counter = 0;
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
        if (counter == 0) {
            counter++;
        }
    }

    public void moveForAnHour() {
        if (counter == 1) {
            counter++;
            breakdownTurnsLeft += 1;
            speed = 0;
        }
        else if (counter == 2) {
            breakdownTurnsLeft += 1;
            speed = 0;
            counter = 0;
        } else {
            speed = 100;
        }
        distanceTraveled += speed;
    }

    public int getBreakdownTurnsLeft() {
        return breakdownTurnsLeft;
    }

}
