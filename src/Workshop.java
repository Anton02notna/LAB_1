import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends Vehicle> {
    private List<T> carsInWorkshop;
    private final int maxCapacity;

    protected Container container;

    public Workshop(int maxCapacity) {
        this.carsInWorkshop = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    protected boolean isSpaceAvailable() {
        return carsInWorkshop.size() < maxCapacity;
    }

    public void receiveCar(T car) {
        if (isSpaceAvailable()) {
            carsInWorkshop.add(car);
            System.out.println(car.getModelName() + " received in the workshop.");
        } else {
            System.out.println("Workshop is full.");
        }
    }

    public T returnCar() {
        if (!carsInWorkshop.isEmpty()) {
            T returnedCar = carsInWorkshop.remove(carsInWorkshop.size() - 1);
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