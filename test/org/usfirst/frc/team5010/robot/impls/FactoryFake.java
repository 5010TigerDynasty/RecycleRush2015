package org.usfirst.frc.team5010.robot.impls;

import org.usfirst.frc.team5010.robot.interfaces.Joystick;
import org.usfirst.frc.team5010.robot.interfaces.JoystickButton;
import org.usfirst.frc.team5010.robot.interfaces.RobotFactory;

public class FactoryFake implements RobotFactory {
	@Override
	public Joystick getJoystick(int param) {
		return new JoystickFake(param);
	}

	@Override
	public JoystickButton getJoystickButton(Joystick joystick, int button) {
		return new JoystickButtonFake(joystick, button);
	}

}
