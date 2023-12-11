import java.awt.*;

public class Volvo extends Cars {
    protected Volvo(int x, int y){
        direction = Directions.NORTH;
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
        this.y_coordinate = y;
        this.x_coordinate = x;
    }

    public final static double trimFactor = 1.25;

    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}

