/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5010.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team5010.robot.RobotMap;
import org.usfirst.frc.team5010.robot.subsystems.LifterSubsystem;

/**
 *
 * @author HP Customer
 */
public class LifterSafety extends CommandBase{
    private DigitalInput top,bottom;
    protected void initialize() {
	top=RobotMap.top;
	bottom=RobotMap.bottom;
    }

    protected void execute() {
	if(!top.get()){
	    lifterSubsystem.setLifterStatus(LifterSubsystem.LifterStatus.top);
	}else if(!bottom.get()){
	    lifterSubsystem.setLifterStatus(LifterSubsystem.LifterStatus.bottom);
	}else{
	    lifterSubsystem.setLifterStatus(LifterSubsystem.LifterStatus.middle);
	}
    }

    protected boolean isFinished() {
	return false;
    }

    protected void end() {
	
    }

    protected void interrupted() {
	
    }
    
}
