//OOP First Semester Project

//Object class
class PhysicsObject {
    public double mass;

    //Getting the mass of object from user with constructor
    PhysicsObject(double mass) {
        this.mass = mass;
    }
    //Get method for mass attribute
    double getMass() {
        return mass;
    }
}

//Solid object class inherited from object class
class SolidObject extends PhysicsObject {
    private double volume;
    private double height;

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
    
    public double calculateDensity() {
        return mass / volume;
    }
}

//Liquid object class inherited from object class
class LiquidObject extends PhysicsObject {
    private double volume;
    private double height;

    LiquidObject(double mass, double volume) {
        super(mass);
        this.volume = volume;
    }
    //Get method for volume attribute
    public double getVolume() {
        return volume;
    }

    public double getHeight() {
        return height;
    }
}

//Gas object class inherited from object class
class GasObject extends PhysicsObject {
    private double volume;
    private double atmosphericPressure;

    GasObject(double mass, double volume, double atmosphericPressure) {
        super(mass);
        this.volume = volume;
        this.atmosphericPressure = atmosphericPressure;
    }

    public double getVolume() {
        return volume;
    }

    public double getAtmPressure () {
        return atmosphericPressure;
    }

}

//Abstract class for motion
abstract class Motion {
    abstract double calculateDistance(double initialVelocity, double time);
}

//Motion calculator inherited from abstract motion class
class MotionCalculator extends Motion {
    //Distance calculator for two different instances with overloading
    @Override
    double calculateDistance(double initialVelocity, double time) {
        return initialVelocity * time;
    }

    double calculateDistance(double initialVelocity, double acceleration, double time) {
        return initialVelocity * time + 0.5 * acceleration * time * time;
    }
}

// Yöntem (Methods)
class PhysicsLibrary {
    static final double GRAVITY = 9.8;

    // Fazladan Yükleme (Overloading)
    static double calculateKineticEnergy(double mass, double velocity) {
        return 0.5 * mass * velocity * velocity;
    }

    //
    static double calculateKineticEnergy(SolidObject object, double velocity) {
        return 0.5 * object.getMass() * velocity * velocity;
    }

    static double calculateKineticEnergy(LiquidObject object, double velocity) {
        return 0.5 * object.getMass() * velocity * velocity;
    }

    // Exception (İstisna)
    static double calculatePotentialEnergy(SolidObject object) throws IllegalArgumentException {
        if (object.getMass() < 0 || object.getHeight() < 0) {
            throw new IllegalArgumentException("Invalid mass or height");
        }
         // Yerçekimi sabiti (m/s^2)
        return object.getMass() * GRAVITY * object.getHeight();
    }

    // Erişim Belirleme
    public static class PublicClass {
        // Kamuya açık iç içe sınıf
    }
}

// Test
public class PhysicsMain {
    public static void main(String[] args) {
        // Kullanım örneği
        PhysicsObject object = new PhysicsObject(5.0);
        SolidObject solidObject = new SolidObject(10.0, 2.0, 12.0);
        LiquidObject liquidObject = new LiquidObject(8.0, 3.0);

        MotionCalculator calculator = new MotionCalculator();
        double distance = calculator.calculateDistance(10.0, 2.0);
        System.out.println("Distance: " + distance);

        try {
            double kineticEnergy = PhysicsLibrary.calculateKineticEnergy(2.0, 3.0);
            System.out.println("Kinetic Energy: " + kineticEnergy);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
