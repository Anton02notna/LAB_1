import java.awt.*;
import java.util.ArrayList;
import java.lang.Math;

public class CarTransport extends Truck {
    private final Ramp ramp;

    protected Container container;




    protected CarTransport() {
        direction = Directions.NORTH;
        nrDoors = 2;
        color = Color.green;
        enginePower = 300;
        modelName = "TransportCar";
        this.ramp = new Ramp();
        this.container = new Container(10);
        stopEngine();
    }
    public boolean getRamp() {
        return this.ramp.isRaised();
    }
    public void lowerRamp() {
        if (this.currentSpeed == 0) {
            this.enginePower = 0;
            this.ramp.rampDown();
        }
    }
    public void raiseRamp() {
        if (this.currentSpeed == 0) {
            this.enginePower = 300;
            this.ramp.rampUp();
        }
    }
    @Override
    public void startEngine() {
        if (this.getRamp()) {
            this.currentSpeed = 0.1;
        }
    }


    protected double speedFactor() {
        return 0;
    }

    public boolean checkProximity(Vehicle car) {
        return Math.abs(car.getX() - this.getX()) <= 5 && Math.abs(car.getY() - this.getY()) <= 5;
    }
    public void load(Vehicle car) {
        if (!(car instanceof CarTransport) && !this.getRamp() && this.checkProximity(car)) {
            container.containerList.add(car);
        }
    }
    public void unload(Vehicle car) {
        if (this.container.containerList != null && !this.container.containerList.isEmpty()) {
            this.container.containerList.remove(this.container.containerList.size()-1);
            car.y_coordinate = this.y_coordinate - 5;
        }
    }
    public ArrayList<Vehicle> getLoadedVehicle() {
        return new ArrayList<>(container.containerList);
    }
    @Override
    public void move() {
        super.move();
        for (Vehicle car : this.container.containerList) {
            car.x_coordinate = this.x_coordinate;
            car.y_coordinate = this.y_coordinate;
        }
    }

}