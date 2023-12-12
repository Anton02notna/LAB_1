import java.awt.*;

public class Volvo extends Cars {
    protected Volvo(){
        direction = Directions.NORTH;
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();

    }

    protected final static double trimFactor = 1.25;

    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}

