package vehicle;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static int speedLimit = Car.setSpeedLimit(70);
    private static double isRaining = 0.3;
    private static ArrayList<Car> cars = new ArrayList<>();
    private static ArrayList<Motorcycle> motorcycles = new ArrayList<>();
    private static ArrayList<Truck> trucks = new ArrayList<>();
    private static ArrayList<String> names = new ArrayList<>();
    private static ArrayList<String> types = new ArrayList<>();
    private static ArrayList<Integer> distanceLengths = new ArrayList<>();

    public static void main(String[] args) {

        createVehicles();
        simulateRace();
        printRaceResults();

    }

    private static void createVehicles() {
        for (int i = 0; i < 10; i++) {
            cars.add(new Car());
            motorcycles.add(new Motorcycle());
            trucks.add(new Truck());
        }
    }

    private static void simulateRace() {
        Random random = new Random();
        int listLength = motorcycles.size();

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < listLength; j++) {
                cars.get(j).setNormalSpeed();
                if (random.nextFloat() < 0.3) {
                    cars.get(j).setLimitedSpeed(speedLimit);
                }
                cars.get(j).moveForAnHour();

                motorcycles.get(j).setNormalSpeed();
                if (random.nextFloat() < isRaining) {
                    motorcycles.get(j).setRainySpeed();
                }
                motorcycles.get(j).moveForAnHour();

                if (random.nextFloat() < 0.05) {
                    trucks.get(j).breakdownTurnsLeft();
                }
                trucks.get(j).moveForAnHour();
            }
        }
    }

    private static void printRaceResults() {
        int maxNumber = 0;
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).getName() + ", " + cars.get(i).getDistanceTraveled() +
                    "km, " + cars.get(i).getType());

            names.add(cars.get(i).getName());
            distanceLengths.add(cars.get(i).getDistanceTraveled());
            types.add(cars.get(i).getType());

            System.out.println(motorcycles.get(i).getName() + ", " + motorcycles.get(i).getDistanceTraveled() +
                    "km, " + motorcycles.get(i).getType());

            names.add(motorcycles.get(i).getName());
            distanceLengths.add(motorcycles.get(i).getDistanceTraveled());
            types.add(motorcycles.get(i).getType());

            System.out.println(trucks.get(i).getName() + ", " + trucks.get(i).getDistanceTraveled() +
                    "km, " + trucks.get(i).getType() + ", break down: " +
                    trucks.get(i).getBreakdownTurnsLeft() + "h");

            names.add(trucks.get(i).getName());
            distanceLengths.add(trucks.get(i).getDistanceTraveled());
            types.add(trucks.get(i).getType());

            if (distanceLengths.get(i) > maxNumber) {
                maxNumber = distanceLengths.get(i);
            }
        }

        for (int i = 0; i < distanceLengths.size(); i++) {
            if (maxNumber == distanceLengths.get(i)) {
                System.out.println("\nThe winner is: " + names.get(i) + ", "+
                        distanceLengths.get(i) + ", " + types.get(i) );
            }
        }
    }
}
