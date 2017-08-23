
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    static Integer numberOfCarsInRace = 10;
    static List<Car> cars = new ArrayList<>();

    static Integer numberOfMotorcyclesInRace = 10;
    static List<Motorcycle> motorcycles = new ArrayList<>();

    static Integer numberOfTrucksInRace = 10; // MAXIMUM: 1000 - listen to createNewTruckName() method in Truck class
    static List<Truck> trucks = new ArrayList<>();

    public static Integer randomNumberGenerator(int minimum, int maximum) {

        if (minimum > maximum) {
            throw new IllegalArgumentException("Maximum value must be greater than minimum value.");
        }

        Random randomNumber = new Random();
        return randomNumber.nextInt(maximum - minimum + 1) + minimum;

    }

    static boolean isRaining(){
        int randomNumber = randomNumberGenerator(1, 100);
        if (randomNumber < 31) {
            return true;
        } else {
            return false;
        }
    }

    private static void createVehicles(){

        int chanceForSpeedLimit;
        for (int carNum = 1; carNum <= numberOfCarsInRace; carNum++){
            Car newCar = new Car();
            cars.add(newCar);
            chanceForSpeedLimit = randomNumberGenerator(1, 100);
            if (chanceForSpeedLimit < 31){
                Car.setSpeedLimit(newCar, 70);
            }
        }

        for (int motorcycleNum = 1; motorcycleNum <= numberOfMotorcyclesInRace; motorcycleNum++){
            Motorcycle newMotorcycle = new Motorcycle();
            motorcycles.add(newMotorcycle);
        }

        for (int truckNum = 1; truckNum <= numberOfTrucksInRace; truckNum++){
            trucks.add(new Truck());
        }
    }

    private static void simulateRace(){

        for (int hour = 1; hour < 51; hour++){
            boolean isRaining = isRaining();

            for (Car car: cars){
                car.moveForAnHour();
            }

            for (Motorcycle motorcycle: motorcycles){
                motorcycle.moveForAnHour(isRaining);
            }

            for (Truck truck: trucks){
                truck.moveForAnHour();
            }
        }

        for (Car car: cars){
            System.out.println(car.getName() + ", norm speed: " + car.getNormalSpeed() + " km/h, traveled: " + car.getDistanceTraveled() + " km");
        }

        for (Motorcycle motorcycle: motorcycles){
            System.out.println(motorcycle.getName() + ", norm speed: " + motorcycle.getSpeed() + " km/h, traveled: " + motorcycle.getDistanceTraveled() + " km");
        }

        for (Truck truck: trucks){
            System.out.println(truck.getName() + ", speed: " + truck.getSpeed() + " km/h, traveled: " + truck.getDistanceTraveled() + " km.");
        }
    }

    public static void main(String[] args) {
        createVehicles();
        simulateRace();
    }

}
