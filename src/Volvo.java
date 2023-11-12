import java.awt.*;

class Volvo extends Cars {
    protected Volvo(){
        Directions direction = Directions.NORTH;
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }
    public final static double trimFactor = 1.25;
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}

