
package org.usfirst.frc.team5010.robot;

import org.usfirst.frc.team5010.robot.interfaces.Joystick;
import org.usfirst.frc.team5010.robot.interfaces.JoystickButton;
import org.usfirst.frc.team5010.robot.interfaces.RobotFactory;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// Another type of button you can create is a DigitalIOButton, which is
	// a button or switch hooked up to the cypress module. These are useful if
	// you want to build a customized operator interface.
	// Button button = new DigitalIOButton(1);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	private int upButtonIndex = 1;
	private int downButtonIndex = 2;
	private Joystick mainJoystick;
	private JoystickButton upButton;// whatever if the drivers want buttons
	private JoystickButton downButton;

	public OI(RobotFactory factory) {
		mainJoystick = factory.getJoystick(1);
		upButton = factory.getJoystickButton(mainJoystick, upButtonIndex);
		downButton = factory.getJoystickButton(mainJoystick, downButtonIndex);
	}

	public int getUpButtonIndex() {
		return upButtonIndex;
	}

	public int getDownButtonIndex() {
		return downButtonIndex;
	}

	public JoystickButton getUpButton() {
		return upButton;
	}

	public JoystickButton getDownButton() {
		return downButton;
	}

	public Joystick getMainJoystick() {
		return mainJoystick;
	}
	
	
}
