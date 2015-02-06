package org.usfirst.frc.team5010.robot;


import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    /*2015 map
    public static final SpeedController leftMotor = new SpeedControllerGroup(new Victor(1),new Victor(2),true);
    public static final SpeedController rightMotor = new SpeedControllerGroup(new Victor(3),new Victor(4),false);
    * 
     public static final SpeedController lifter = new SpeedControllerGroup(new Victor(5),new Victor(6),false);
    /*/
    public static final SpeedController rightMotor = new SpeedControllerGroup(new SpeedControllerGroup(new Victor(3),new Victor(2),false),new Victor(1),true);
    public static final SpeedController leftMotor = new SpeedControllerGroup(new SpeedControllerGroup(new Victor(4),new Victor(5),false),new Victor(6),false);
     
     public static final SpeedController lifter=null;
      //*/
    public static final Gyro gyro = new Gyro(new AnalogInput(1));
    public static final DigitalInput top = new DigitalInput(1);
    //the order is important
    final public static DigitalInput bottom = new DigitalInput(2);
   
}
