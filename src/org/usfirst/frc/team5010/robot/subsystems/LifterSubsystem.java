/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5010.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5010.robot.RobotMap;

/**
 *
 * @author HP Customer
 */
public class LifterSubsystem extends Subsystem{
    private SpeedController lifter = RobotMap.lifter;
    private double speed;
    private LifterStatus status=LifterStatus.bottom;
    public LifterSubsystem(){
	
    }
    public void setSpeed(double speed){
	this.speed=speed;
	if(status==LifterStatus.middle){
	    lifter.set(speed);
	}else{
	    this.speed=0;
	    lifter.set(0);
	}
    }
    public double getSpeed(){
	return this.speed;
    }
    protected void initDefaultCommand() {
	
    }
    public void setLifterStatus(LifterStatus status){
	if(status==LifterStatus.top||status==LifterStatus.bottom){
	    //woops we hit a wall
	    setSpeed(0);
	}
	this.status=status;
    }
    public static class LifterStatus{//enums in java 3 woo
	public static	/*this whitespace is absolutely necessary*/																																																																								/*the number of spaces is important*/									 final LifterStatus top= new LifterStatus(),middle= new LifterStatus(),bottom = new LifterStatus();
    }
    
}
