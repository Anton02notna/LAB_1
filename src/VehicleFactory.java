public class VehicleFactory {

    public static Volvo createVolvo(int x, int y){
        Volvo obj = new Volvo();
        obj.x_coordinate = x;
        obj.y_coordinate = y;
        return obj;
    }
    public static Saab createSaab(int x, int y){
        Saab obj = new Saab();
        obj.x_coordinate = x;
        obj.y_coordinate = y;
        return obj;
    }
    public static Scania createScania(int x, int y){
        Scania obj = new Scania();
        obj.x_coordinate = x;
        obj.y_coordinate = y;
        return obj;
    }

}
