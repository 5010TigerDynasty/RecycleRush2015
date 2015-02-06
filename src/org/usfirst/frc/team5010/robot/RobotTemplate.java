/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team5010.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team5010.robot.commands.CommandBase;
import org.usfirst.frc.team5010.robot.commands.DriveCommand;
import org.usfirst.frc.team5010.robot.commands.ExampleCommand;
import org.usfirst.frc.team5010.robot.commands.LiftCommand;
import org.usfirst.frc.team5010.robot.commands.LifterSafety;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {

    private Command autonomousCommand;
    private Command lifterCommand;
    private Command driveCommand;
    private Command lifterSafety;
    private boolean oldRobot = true;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
	// instantiate the command used for the autonomous period
	autonomousCommand = new ExampleCommand();

	// Initialize all subsystems
	CommandBase.init();
	if (!oldRobot) {
	    lifterSafety = new LifterSafety();
	    lifterSafety.start();
	}
    }

    public void autonomousInit() {
	// schedule the autonomous command (example)
	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
	Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
	// teleop starts running. If you want the autonomous to 
	// continue until interrupted by another command, remove
	// this line or comment it out.
	autonomousCommand.cancel();
	if (!oldRobot) {
	    lifterCommand = new LiftCommand();
	    lifterCommand.start();
	}
	driveCommand = new DriveCommand();
	driveCommand.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
	Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
	LiveWindow.run();
    }

    public void disabledInit() {
	if (lifterCommand != null) {
	    lifterCommand.cancel();
	}
	if (driveCommand != null) {
	    driveCommand.cancel();
	}
    }
}
