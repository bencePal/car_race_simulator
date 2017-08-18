package vehicle;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static int speedLimit = Car.setSpeedLimit(70);
    private static double isRaining = 0.3;
    private static ArrayList<Car> cars = new ArrayList<>();
    private static ArrayList<Motorcycle> motorcycles = new ArrayList<>();
    private static ArrayList<Truck> trucks = new ArrayList<>();
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
//        for (int i = 0; i < 50; i++) {
//            for (Car raceCar : cars) {
//                raceCar.setNormalSpeed();
//                if (random.nextFloat() < 0.3) {
//                    raceCar.setLimitedSpeed(speedLimit);
//                }
//                raceCar.moveForAnHour();
//            }
//            for (Motorcycle raceMotor : motorcycles) {
//                raceMotor.setNormalSpeed();
//                if (random.nextFloat() < isRaining) {
//                    raceMotor.setRainySpeed();
//                }
//                raceMotor.moveForAnHour();
//            }
//
//            for (Truck raceTruck : trucks) {
//                if (random.nextFloat() < 0.05) {
//                    raceTruck.breakdownTurnsLeft();
//                }
//                raceTruck.moveForAnHour();
//            }
//        }
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
        for (Car raceCar : cars) {
            System.out.println(raceCar.getName() + ", " + raceCar.getDistanceTraveled() +
                    "km, " + raceCar.getType());
            distanceLengths.add(raceCar.getDistanceTraveled());
        }
        for (Motorcycle raceMotor : motorcycles) {
            System.out.println(raceMotor.getName() + ", " + raceMotor.getDistanceTraveled() +
                    "km, " + raceMotor.getType());
            distanceLengths.add(raceMotor.getDistanceTraveled());
        }
        for (Truck raceTruck : trucks) {
            System.out.println(raceTruck.getName() + ", " + raceTruck.getDistanceTraveled() +
                    "km, " + raceTruck.getType() + ", break down: " +
                    raceTruck.getBreakdownTurnsLeft() + " min");
            distanceLengths.add(raceTruck.getDistanceTraveled());
        }
//        int maxNumber = distanceLengths.get(0);
//        for (int i = 0; i < distanceLengths.size(); i++) {
//            if (distanceLengths.get(i) > maxNumber) {
//                maxNumber = distanceLengths.get(i);
//            }
//        }
//        System.out.println(maxNumber);
    }

}
