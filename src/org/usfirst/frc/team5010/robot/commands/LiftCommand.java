/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5010.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author HP Customer
 */
public class LiftCommand extends JoystickBasedCommand {
    private Joystick joystick;
    private int axis=5;
    protected void initialize() {
	joystick = new Joystick(1);
    }

    protected void execute() {
	double speed = filterInput(joystick.getRawAxis(axis));
	lifterSubsystem.setSpeed(speed);
    }

    protected boolean isFinished() {
	return false;
    }

    protected void end() {
	 
    }

    protected void interrupted() {
	
    }
    
}
