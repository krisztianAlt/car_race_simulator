import java.util.*;

public class Main {

    static Integer numberOfCarsInRace = 10;
    static List<Car> cars = new ArrayList<>();

    static Integer numberOfMotorcyclesInRace = 10;
    static List<Motorcycle> motorcycles = new ArrayList<>();

    static Integer numberOfTrucksInRace = 10; // MAXIMUM: 1000 - listen to createNewTruckName() method in Truck class
    static List<Truck> trucks = new ArrayList<>();

    static ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

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
            motorcycles.add(new Motorcycle());
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

            ArrayList<String> nextCarData = new ArrayList<>();
            nextCarData.add(car.getName());
            nextCarData.add(car.getDistanceTraveled().toString());
            String type = new String("car");
            nextCarData.add(type);
            result.add(nextCarData);

        }

        for (Motorcycle motorcycle: motorcycles){
            ArrayList<String> nextMotorcycleData = new ArrayList<>();
            nextMotorcycleData.add(motorcycle.getName());
            nextMotorcycleData.add(motorcycle.getDistanceTraveled().toString());
            String type = new String("motorcycle");
            nextMotorcycleData.add(type);
            result.add(nextMotorcycleData);

        }

        for (Truck truck: trucks){
            ArrayList<String> nextTruckData = new ArrayList<>();
            nextTruckData.add(truck.getName());
            nextTruckData.add(truck.getDistanceTraveled().toString());
            String type = new String("truck");
            nextTruckData.add(type);
            result.add(nextTruckData);

        }

        result = sortedResult(result);
    }

    private static ArrayList<ArrayList<String>> sortedResult(ArrayList<ArrayList<String>> resultList){

        for (int i = 0; i < resultList.size()-1; i++) {
            for (int j = 0; j < resultList.size()-1; j++) {
                if (Integer.parseInt(resultList.get(j).get(1)) < Integer.parseInt(resultList.get(j + 1).get(1))) {
                    ArrayList temp = resultList.get(j);
                    resultList.set(j, resultList.get(j+1));
                    resultList.set(j+1, temp);
                }
            }
        }

        return resultList;
    }

    private static void printRaceResults(){
        System.out.print("\033[2J\033[1;1H");
        System.out.println(String.join("", Collections.nCopies(46, "=")));
        System.out.format("%21s%12s%13s%n", "Name", "Distance", "Type");
        System.out.println(String.join("", Collections.nCopies(46, "=")));

        for (ArrayList nextVehicle: result){
            System.out.format("%21s%12s%13s%n", nextVehicle.get(0), nextVehicle.get(1) + " km", nextVehicle.get(2));
        }

        System.out.println(String.join("", Collections.nCopies(46, "=")));
    }

    public static void main(String[] args) {
        createVehicles();
        simulateRace();
        printRaceResults();
    }

}