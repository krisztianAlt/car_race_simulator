import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {

    private static List<String> namesFromWeb = new ArrayList<>(Arrays.asList("Bullet",
                                                                            "Vertex",
                                                                            "Scorpion",
                                                                            "Blizzard",
                                                                            "Catalyst",
                                                                            "Phenomenom",
                                                                            "Quicksilver",
                                                                            "Jazz",
                                                                            "Guerilla",
                                                                            "Vindicator",
                                                                            "Enigma",
                                                                            "Passion",
                                                                            "Majesty",
                                                                            "Supremacy",
                                                                            "Stardust",
                                                                            "Adventure",
                                                                            "Union",
                                                                            "Mystery",
                                                                            "Escape",
                                                                            "Prospect"));

    private static List<String> existingNames = new ArrayList<>();


    private int normalSpeed;
    private String name;
    private int distanceTraveled;

    public int getNormalSpeed() {

        return this.normalSpeed;

    }

    public void setNormalSpeed(int normalSpeed) {

        this.normalSpeed = normalSpeed;

    }

    public static void setSpeedLimit(Car car, int limit){

        car.setNormalSpeed(limit);

    }

    public String createNewName(){
        String newName = "";
        int firstNameIndex;
        int secondNameIndex;
        boolean firstAndSecondNameIsTheSame;
        boolean nameIsWrong = true;
        while (nameIsWrong){
            firstAndSecondNameIsTheSame = true;
            while (firstAndSecondNameIsTheSame) {
                firstNameIndex = Main.randomNumberGenerator(0, namesFromWeb.size() - 1);
                secondNameIndex = Main.randomNumberGenerator(0, namesFromWeb.size() - 1);
                if (firstNameIndex != secondNameIndex) {
                    newName = namesFromWeb.get(firstNameIndex) + " " + namesFromWeb.get(secondNameIndex);
                    firstAndSecondNameIsTheSame = false;
                }
            }
            if (!existingNames.contains(newName)){
                existingNames.add(newName);
                nameIsWrong = false;
            }
        }
        return newName;
    }

    public String getName() {

        return this.name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public int getDistanceTraveled() {

        return distanceTraveled;

    }

    public void setDistanceTraveled(int distanceTraveled) {

        this.distanceTraveled = distanceTraveled;

    }

    public Car() {
        setNormalSpeed(Main.randomNumberGenerator(80, 110));
        setName(createNewName());
        setDistanceTraveled(0);
    }

    public void moveForAnHour(){

        setDistanceTraveled(getDistanceTraveled() + getNormalSpeed());

    }

}
