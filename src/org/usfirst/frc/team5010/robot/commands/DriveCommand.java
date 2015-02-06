/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5010.robot.commands;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author HP Customer
 */
public class DriveCommand extends JoystickBasedCommand{
    private Joystick joystick;
    private int forwardAxis=2;
    private int rightAxis=4;
    protected void initialize(){ 
	this.joystick = new Joystick(1);
    }

    protected void execute() {
	double forward = -filterInput(joystick.getRawAxis(forwardAxis));
	double right = filterInput(joystick.getRawAxis(rightAxis));
	driveTrainSubsystem.setForward(forward);
	driveTrainSubsystem.setRight(right);
    }

    protected boolean isFinished() {
	return false;
    }

    protected void end() {
	driveTrainSubsystem.setForward(0);
	driveTrainSubsystem.setRight(0);
    
    }

    protected void interrupted() {

    }
    
}
