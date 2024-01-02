//Class for main methods to use formulas
public class PhysicsLibrary {
    public final double GRAVITY = 9.8;
    private PhysicsObject object;

    PhysicsLibrary (PhysicsObject object) {
        this.object = object;
    }

    //Method for displaying the information about object
    public String ObjectInfo() {
        return "Object Info ---> Mass : " + object.getMass() + " Volume : " + object.getVolume() + " Density : " + object.getDensity();
    }
    
    //Method to calculate liquid pressure
    public double calculateLiqPressure(double height, double density) throws IllegalArgumentException {
        if (density <= 0) {
            throw new IllegalArgumentException("Invalid density");
        }
        return height * density * GRAVITY;
    }
    
    public double calculateLiqPressure(LiquidObject object) throws IllegalArgumentException {
        if (object.getDensity() <= 0) {
            throw new IllegalArgumentException("Invalid density");
        }
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
    public class MotionCalculator extends Motion {
        //Method to calculate distance
        public double calculateDistance(double initialVelocity, double time) throws IllegalArgumentException {
            if (time <= 0) {
                throw new IllegalArgumentException("Invalid time value");
            }
            return initialVelocity * time;
        }

        public double calculateDistance(double initialVelocity, double acceleration, double time) throws IllegalArgumentException {
            if (time <= 0) {
                throw new IllegalArgumentException("Invalid time value");
            }
            return initialVelocity * time + 0.5 * acceleration * time * time;
        }
    }
}
