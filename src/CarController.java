import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class CarController {
    private final int delay = 50;
    private boolean engineStatus = false;
    private Timer timer = new Timer(delay, new TimerListener());

    CarView frame;
    ArrayList<Vehicle> cars = new ArrayList<>();

    ArrayList<Saab> saab95s = new ArrayList<>();
    ArrayList<Scania> scanias = new ArrayList<>();

    public static void main(String[] args) {
        CarController cc = new CarController();

        Volvo volvo240 = VehicleFactory.createVolvo(0,0);
        Saab saab95 = VehicleFactory.createSaab(0,100);
        Scania scania = VehicleFactory.createScania(0,200);


        cc.cars.add(volvo240);
        cc.cars.add(saab95);
        cc.cars.add(scania);

        cc.saab95s.add(saab95);
        cc.scanias.add(scania);

        cc.frame = new CarView("CarSim 1.0", cc);

        cc.timer.start();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                collisionWithWalls(car);
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(car, x, y);
                frame.drawPanel.repaint();
            }
        }
    }


    private void collisionWithWalls(Vehicle car) {
        if (car.getX() > 700) {
            car.x_coordinate = 700;
            car.turnLeft();
            car.turnLeft();
        }
        if (car.getY() > 560) {
            car.y_coordinate = 560;
            car.turnLeft();
            car.turnLeft();
        }
        if (car.getX() < 0) {
            car.x_coordinate = 0;
            car.turnLeft();
            car.turnLeft();
        }
        if (car.getY() < 0) {
            car.y_coordinate = 0;
            car.turnLeft();
            car.turnLeft();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            if (engineStatus){
            car.gas(gas);}
        }
    }
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.brake(brake);
        }
    }
    void startAllVehicle () {
        for (Vehicle car : cars) {
            car.startEngine();
            engineStatus = true;
        }
    }

    void  stopAllVehicle() {
        for (Vehicle car : cars) {
            car.stopEngine();
            engineStatus = false;
        }
    }

    void setTurboOn () {
        for (Saab saab95: saab95s) {
            saab95.turboOn = true;
        }
    }

    void setTurboOff () {
        for (Saab saab95: saab95s) {
            saab95.turboOn = false;
        }
    }

    void raiseAngle(){
        for(Scania scania: scanias){
            scania.raiseAngle(45);
        }
    }


    void lowerAngle() {
        for(Scania scania: scanias) {
            scania.lowerAngle(45);
            }
        }



    }



