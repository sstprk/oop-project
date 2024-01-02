//OOP First Semester Project
// Test Class
public class PhysicsMain {
    public static void main(String[] args) {
        SolidObject solidObject = new SolidObject(10.0, 2.0, 12.0);
        LiquidObject liquidObject = new LiquidObject(8.0, 3.0, 10.0);
        GasObject gasObject = new GasObject(2.0, 3.0, 5.0);
        PhysicsLibrary physics = new PhysicsLibrary(gasObject);
        PhysicsLibrary.MotionCalculator calculator = physics.new MotionCalculator();

        //Object info
        System.out.println(physics.ObjectInfo());

        //Calculating distance
        try {
            double distance = calculator.calculateDistance(10.0, 2.0);
            System.out.println("Distance: " + distance);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception: " + ex.getMessage());
        } 

        //Calculating kinetic energy
        try {
            double kineticEnergy = physics.calculateKineticEnergy(2.0, 3.0);
            System.out.println("Kinetic Energy: " + kineticEnergy);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        //Calculating liquid pressure energy
        try {
            double liquidPressure = physics.calculateLiqPressure(liquidObject);
            System.out.println("Liquid Pressure: " + liquidPressure);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        //Calculating potential energy
        try {
            double potentialEnergy = physics.calculatePotentialEnergy(solidObject);
            System.out.println("Potential Energy: " + potentialEnergy);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception: "+ ex.getMessage());
        }
    }
}
