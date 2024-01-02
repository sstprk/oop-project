//Gas object class inherited from object class
public class GasObject extends PhysicsObject {
    private double mass;
    private double volume;
    private double atmosphericPressure;

    GasObject(double mass, double atmosphericPressure, double volume) {
        this.mass = mass;
        this.volume = volume;
        this.atmosphericPressure = atmosphericPressure;
    }
    //Get method for density from the abstract object class
    public double getDensity() {
        return mass / volume;
    }

    //Get method for mass
    public double getMass() {
        return mass;
    }

    //Get method for volume
    public double getVolume() {
        return volume;
    }
    
    //Get method for atmospheric pressure
    public double getAtmPressure () {
        return atmosphericPressure;
    }
}
