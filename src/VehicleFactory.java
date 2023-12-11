public class VehicleFactory {

    public Volvo createVolvo(Volvo name, int x, int y){
        return name = new Volvo(x,y);
    }
    public Saab createSaab(Saab name, int x, int y){
        return name = new Saab(x,y);
    }
    public Scania createScania(Scania name, int x, int y){
        return name = new Scania(x,y);
    }

}
