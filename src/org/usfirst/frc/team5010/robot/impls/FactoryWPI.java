package org.usfirst.frc.team5010.robot.impls;

import org.usfirst.frc.team5010.robot.interfaces.*;

public class FactoryWPI implements RobotFactory {
	@Override
	public Joystick getJoystick(int param) {
		return new JoystickWPI(param);
	}

	@Override
	public JoystickButton getJoystickButton(Joystick joystick, int button) {
		return new JoystickButtonWPI(joystick, button);
	}
}
