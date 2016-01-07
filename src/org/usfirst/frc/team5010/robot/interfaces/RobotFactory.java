package org.usfirst.frc.team5010.robot.interfaces;

public interface RobotFactory {
	public Joystick getJoystick(int param);
	public JoystickButton getJoystickButton(Joystick joystick, int button);
}
