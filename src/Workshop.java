import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Vehicle> {
    //private List<T> acarsInWorkshop;
    private final int maxCapacity;

    protected Container carsInWorkshop;

    public Workshop(int maxCapacity) {
        this.carsInWorkshop = new Container(maxCapacity);
        this.maxCapacity = maxCapacity;
    }

    protected boolean isSpaceAvailable() {
        return carsInWorkshop.size() < maxCapacity;
    }

    public void receiveCar(T car) {
        if (isSpaceAvailable()) {
            carsInWorkshop.containerList.add(car);
            System.out.println(car.getModelName() + " received in the workshop.");
        } else {
            System.out.println("Workshop is full.");
        }
    }

    public Vehicle returnCar() {
        if (!carsInWorkshop.containerList.isEmpty()) {
            Vehicle returnedCar = carsInWorkshop.containerList.remove(carsInWorkshop.containerList.size() - 1);
            System.out.println(returnedCar.getModelName() + " returned from the workshop.");
            return returnedCar;
        } else {
            System.out.println("Workshop is empty.");
            return null;
        }
    }

    public static void main(String[] args) {
        Workshop<Volvo> volvoWorkshop = new Workshop<>(5);
        Workshop<Saab> saabWorkshop = new Workshop<>(5);

        volvoWorkshop.receiveCar(new Volvo(0,0));
        saabWorkshop.receiveCar(new Saab(0,0));

        volvoWorkshop.returnCar();
        saabWorkshop.returnCar();
    }
}