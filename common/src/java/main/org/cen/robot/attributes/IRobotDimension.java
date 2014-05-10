package org.cen.robot.attributes;



/**
 * Corresponds to the dimension of the robot, the distance between the wheels
 * ...
 * 
 * @author svanacker
 * @version 23/02/2007
 */
public interface IRobotDimension extends IRobotAttribute {

    /**
     * Returns the robot's depth.
     */
    double getDepth();

    /**
     * Returns the robot's width.
     */
    double getWidth();

    IMotorProperties getLeftMotor();

    IMotorProperties getRightMotor();

    double getWeight();

    void setWeight(double weight);

    /**
     * Return the distance for a wheel distance for each wheel so that the robot
     * can make a rotation
     */
    double getWheelDistance();
}
