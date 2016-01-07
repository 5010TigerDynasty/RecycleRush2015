package org.usfirst.frc.team5010.robot.impls;

import org.usfirst.frc.team5010.robot.interfaces.Joystick;
import org.usfirst.frc.team5010.robot.interfaces.JoystickButton;

public class JoystickButtonFake implements JoystickButton {
	public int button;
	
	public JoystickButtonFake(Joystick joystick, int button) {
		this.button = button;
	}

	@Override
	public int getButtonIndex() {
		return button;
	}

}
