//Solid object class inherited from object class
public class SolidObject extends PhysicsObject {
    private double mass;
    private double volume;
    private double height;

    SolidObject(double mass, double volume, double height) {
        this.mass = mass;
        this.volume = volume;
        this.height = height;
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
    
    //Get method for height
    public double getHeight() {
        return height;
    }
}