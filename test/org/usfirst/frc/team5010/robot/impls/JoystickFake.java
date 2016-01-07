package org.usfirst.frc.team5010.robot.impls;

import org.usfirst.frc.team5010.robot.interfaces.Joystick;

public class JoystickFake implements Joystick {
	public int port;
	public JoystickFake(int param) {
		port = param;
	}
	@Override
	public int getPort() {
		return port;
	}

}
