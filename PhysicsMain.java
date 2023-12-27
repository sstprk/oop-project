//OOP First Semester Project

//Object class
class PhysicsObject {
    public double mass;

    //Getting the mass of object from user with constructor
    PhysicsObject(double mass) {
        this.mass = mass;
    }

    //Get method for mass attribute
    public double getMass() {
        return mass;
    }
}

//Solid object class inherited from object class
class SolidObject extends PhysicsObject {
    private double volume;
    private double height;
    private double density = mass / volume;

    SolidObject(double mass, double volume, double height) {
        super(mass);
        this.volume = volume;
        this.height = height;
    }

    public double getVolume() {
        return volume;
    }
    
    public double getHeight() {
        return height;
    }

    public double getDensity() {
        return density;
    }
}

//Liquid object class inherited from object class
class LiquidObject extends PhysicsObject {
    private double volume;
    private double height;
    private double density = mass / volume;

    LiquidObject(double mass, double volume) {
        super(mass);
        this.volume = volume;
    }

    //Get methods for each attribute
    public double getVolume() {
        return volume;
    }

    public double getHeight() {
        return height;
    }

    public double getDensity() {
        return density;
    }
}   

//Gas object class inherited from object class
class GasObject extends PhysicsObject {
    private double volume;
    private double atmosphericPressure;
    private double density = mass / volume;

    GasObject(double mass, double volume, double atmosphericPressure) {
        super(mass);
        this.volume = volume;
        this.atmosphericPressure = atmosphericPressure;
    }

    //Get methods for each attribute
    public double getVolume() {
        return volume;
    }

    public double getAtmPressure () {
        return atmosphericPressure;
    }

    public double getDensity() {
        return density;
    }

}

//Abstract class for motion
abstract class Motion {
    abstract double calculateDistance(double initialVelocity, double time);
}

//A class to use the formulas
class PhysicsLibrary {
    public final double GRAVITY = 9.8;

    PhysicsLibrary () {
        
    }
    
    //Method to calculate liquid pressure
    public double calculateLiqPressure(double height, double density) {
        return height * density * GRAVITY;
    }
    
    public double calculateLiqPressure(LiquidObject object) {
        return object.getHeight() * object.getDensity() * GRAVITY;
    }

    //Method to calculate kinetic energy
    public double calculateKineticEnergy(double mass, double velocity) throws IllegalArgumentException {
        if (mass < 0) {
            throw new IllegalArgumentException("Invalid mass");
        }
        return 0.5 * mass * velocity * velocity;
    }

    public double calculateKineticEnergy(SolidObject object, double velocity) throws IllegalArgumentException {
        if (object.getMass() < 0) {
            throw new IllegalArgumentException("Invalid mass");
        }
        return 0.5 * object.getMass() * velocity * velocity;
    }

    //Method to calculate potential energy
    public double calculatePotentialEnergy(SolidObject object) throws IllegalArgumentException {
        if (object.getMass() < 0 || object.getHeight() < 0) {
            throw new IllegalArgumentException("Invalid mass or height");
        }
        return object.getMass() * GRAVITY * object.getHeight();
    }

    //An inner class inherited from the abstract class
    class MotionCalculator extends Motion {
        //Method to calculate distance
        @Override
        public double calculateDistance(double initialVelocity, double time) {
            return initialVelocity * time;
        }

        public double calculateDistance(double initialVelocity, double acceleration, double time) {
            return initialVelocity * time + 0.5 * acceleration * time * time;
        }
    }
}

// Test
public class PhysicsMain {
    public static void main(String[] args) {
        // Kullanım örneği
        PhysicsObject object = new PhysicsObject(5.0);
        SolidObject solidObject = new SolidObject(10.0, 2.0, 12.0);
        LiquidObject liquidObject = new LiquidObject(8.0, 3.0);
        PhysicsLibrary physics = new PhysicsLibrary();

        PhysicsLibrary.MotionCalculator calculator = physics.new MotionCalculator();
        double distance = calculator.calculateDistance(10.0, 2.0);
        System.out.println("Distance: " + distance);

        try {
            double kineticEnergy = physics.calculateKineticEnergy(2.0, 3.0);
            System.out.println("Kinetic Energy: " + kineticEnergy);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}
