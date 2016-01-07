package org.usfirst.frc.team5010.robot.impls;

import org.usfirst.frc.team5010.robot.interfaces.Joystick;
import org.usfirst.frc.team5010.robot.interfaces.JoystickButton;

public class JoystickButtonWPI implements JoystickButton {
	private JoystickWPI joystick = null;
	private int button = 0;
	private edu.wpi.first.wpilibj.buttons.JoystickButton joystickButton = null;
	
	public JoystickButtonWPI(Joystick joystick, int button) {
		this.joystick = (JoystickWPI) joystick;
		this.button = button;
		joystickButton = new edu.wpi.first.wpilibj.buttons.JoystickButton(this.joystick.getJoystick(), button);
	}

	@Override
	public int getButtonIndex() {
		return button;
	}

}
