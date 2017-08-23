public class Motorcycle {

    private static Integer nameNumber = 1;

    private int speed;
    private String name;
    private int distanceTraveled;

    public int getSpeed() {

        return speed;

    }

    public void setSpeed(int speed) {

        this.speed = speed;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getName() {

        return name;

    }

    public static int getNameNumber() {

        return nameNumber;

    }

    public static void setNameNumber(int nameNumber) {

        Motorcycle.nameNumber = nameNumber;

    }

    public void setDistanceTraveled(int distanceTraveled) {

        this.distanceTraveled = distanceTraveled;

    }

    public int getDistanceTraveled() {

        return distanceTraveled;

    }

    public Motorcycle(){

        setSpeed(100);
        setName("Motorcycle " + nameNumber.toString());
        setNameNumber(getNameNumber() + 1);
        setDistanceTraveled(0);

    }

    private int speedModifier;
    public void moveForAnHour(boolean isRaining){

        speedModifier = 0;

        if (isRaining){
            speedModifier = Main.randomNumberGenerator(5, 50);
        }

        this.setDistanceTraveled(this.getDistanceTraveled() + this.getSpeed() - speedModifier);

    }
}
