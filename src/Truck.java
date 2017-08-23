import java.util.ArrayList;
import java.util.List;

public class Truck {

    private static List<String> existingTruckNames = new ArrayList<>();

    private int speed;
    private String name;
    private int breakdownTurnsLeft;
    private int distanceTraveled;

    public void setSpeed(int speed) {

        this.speed = speed;

    }

    public int getSpeed() {

        return speed;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    private String createNewTruckName(){
        String newName = "";

        boolean newNameIsNeeded = true;

        while (newNameIsNeeded){

            newName = Main.randomNumberGenerator(0, 1000).toString();

            if (!existingTruckNames.contains(newName)){
                existingTruckNames.add(newName);
                newNameIsNeeded = false;
            }
        }

        return newName;

    }

    public int getBreakdownTurnsLeft() {

        return breakdownTurnsLeft;

    }

    public void setBreakdownTurnsLeft(int breakdownTurnsLeft) {

        this.breakdownTurnsLeft = breakdownTurnsLeft;

    }

    public int getDistanceTraveled() {

        return distanceTraveled;

    }

    public void setDistanceTraveled(int distanceTraveled) {

        this.distanceTraveled = distanceTraveled;

    }

    public Truck(){

        setSpeed(100);
        setName(createNewTruckName());
        setBreakdownTurnsLeft(0);
        setDistanceTraveled(0);

    }

    public void moveForAnHour(){

        if (this.getBreakdownTurnsLeft() == 0){
            int chanceForBreakDown = Main.randomNumberGenerator(1, 100);
            if (chanceForBreakDown < 6){
                this.setBreakdownTurnsLeft(1);
            } else {
                this.setDistanceTraveled(this.getDistanceTraveled() + this.getSpeed());
            }
        } else {
            this.setBreakdownTurnsLeft(this.getBreakdownTurnsLeft() - 1);
        }

    }
}