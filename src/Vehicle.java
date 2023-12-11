import java.awt.*;

public abstract class Vehicle implements Movable{

    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double x_coordinate = 0;
    protected double y_coordinate = 0;
    protected Vehicle.Directions direction;

    public enum Directions {
        EAST,
        WEST,
        NORTH,
        SOUTH
    }

    public Directions getDirection() {
        return direction;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public String getModelName() {
        return modelName;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public double getX() {
        return this.x_coordinate;
    }

    public double getY() {
        return this.y_coordinate;
    }

    public void setColor(Color clr) {
        color = clr;
    }
    public void startEngine() {
        currentSpeed = 0.1;
    }
    public void stopEngine() {
        currentSpeed = 0;
    }
    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min((getCurrentSpeed() + (speedFactor() * amount)), enginePower);
    }
    protected abstract double speedFactor();
    public void gas(double amount) {
        if (0.0D <= amount && amount <= 1.0D) {
            incrementSpeed(amount);
        }
    }
    public void brake(double amount) {
        if (0.0D <= amount && amount <= 1.0D) {
            decrementSpeed(amount);
        }
    }

    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max((getCurrentSpeed() - (speedFactor() * amount)), 0);
    }




    public void move() {
        if (this.direction == Vehicle.Directions.NORTH) {
            this.x_coordinate += this.currentSpeed;
        }

        if (this.direction == Vehicle.Directions.WEST) {
            this.y_coordinate -= this.currentSpeed;
        }

        if (this.direction == Vehicle.Directions.SOUTH) {
            this.x_coordinate -= this.currentSpeed;
        }

        if (this.direction == Vehicle.Directions.EAST) {
            this.y_coordinate += this.currentSpeed;
        }
    }

    public void turnLeft() {
        if (direction == Vehicle.Directions.NORTH) {
            this.direction = Vehicle.Directions.WEST;
        } else if (direction == Vehicle.Directions.WEST) {
            this.direction = Vehicle.Directions.SOUTH;
        } else if (direction == Vehicle.Directions.SOUTH) {
            this.direction = Vehicle.Directions.EAST;
        } else  {
            this.direction = Vehicle.Directions.NORTH;
        }
    }

    public void turnRight() {
        if (direction == Vehicle.Directions.NORTH) {
            this.direction = Vehicle.Directions.EAST;
        } else if (direction == Vehicle.Directions.WEST) {
            this.direction = Vehicle.Directions.NORTH;
        } else if (direction == Vehicle.Directions.SOUTH) {
            this.direction = Vehicle.Directions.WEST;
        } else  {
            this.direction = Vehicle.Directions.SOUTH;
        }
    }
}