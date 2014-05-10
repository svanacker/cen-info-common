package org.cen.robot.attributes.impl;

import java.util.Properties;

import org.cen.robot.attributes.IMotorProperties;
import org.cen.robot.attributes.IRobotDimension;
import org.cen.utils.PropertiesUtils;

/**
 * Corresponds to the dimension of the robot, the distance between the wheels
 * ...
 * 
 * @author svanacker
 * @version 23/02/2007
 */
public class RobotDimension implements IRobotDimension {

    private static final String PROPERTY_DEPTH = "depth";

    private static final String PROPERTY_WEIGHT = "weight";

    private static final String PROPERTY_WHEELS_DISTANCE = "wheelsDistance";

    private static final String PROPERTY_WIDTH = "width";

    private static final String PREFIX_MOTOR_LEFT = "motors.left";

    private static final String PREFIX_MOTOR_RIGHT = "motors.right";

    /**
     * Depth of the robot in mm.
     */
    private double depth;

    /**
     * Left motor properties.
     */
    private final IMotorProperties leftMotor;

    /**
     * Right motor properties.
     */
    private final IMotorProperties rightMotor;

    /**
     * The weight of the robot in kg.
     */
    private double weight;

    /**
     * Distance between the wheels in mm.
     */
    private double wheelsDistance;

    /**
     * Width of the robot in mm.
     */
    private double width;

    public RobotDimension(double width, double depth, double weight, IMotorProperties leftMotor,
            IMotorProperties rightMotor, double wheelsDistance) {
        super();
        this.depth = depth;
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
        this.weight = weight;
        this.wheelsDistance = wheelsDistance;
        this.width = width;
    }

    public RobotDimension(Properties properties, String prefix) {
        super();
        leftMotor = new MotorProperties(properties, prefix + PREFIX_MOTOR_LEFT + ".");
        rightMotor = new MotorProperties(properties, prefix + PREFIX_MOTOR_RIGHT + ".");
        setFromProperties(properties, prefix);
    }

    /**
     * Returns the robot's depth.
     */
    @Override
    public double getDepth() {
        return depth;
    }

    @Override
    public IMotorProperties getLeftMotor() {
        return leftMotor;
    }

    @Override
    public IMotorProperties getRightMotor() {
        return rightMotor;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    /**
     * Return the distance for a wheel distance for each wheel so that the robot
     * can make a rotation
     */
    @Override
    public double getWheelDistance() {
        return wheelsDistance;
    }

    /**
     * Returns the robot's width.
     */
    @Override
    public double getWidth() {
        return width;
    }

    public void setFromProperties(Properties properties, String prefix) {
        width = PropertiesUtils.getDouble(properties, prefix + PROPERTY_WIDTH);
        depth = PropertiesUtils.getDouble(properties, prefix + PROPERTY_DEPTH);
        wheelsDistance = PropertiesUtils.getDouble(properties, prefix + PROPERTY_WHEELS_DISTANCE);
        weight = PropertiesUtils.getDouble(properties, prefix + PROPERTY_WEIGHT);
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[width=" + width + ", depth=" + depth + ", wheelsDistance="
                + wheelsDistance + ", weight=" + weight + " kg, leftMotor: " + leftMotor + ", rightMotor: "
                + rightMotor + "]";
    }
}
