package org.usfirst.frc.team5010.robot.impls;

import org.usfirst.frc.team5010.robot.interfaces.Joystick;

public class JoystickWPI implements Joystick {
	private edu.wpi.first.wpilibj.Joystick joystick = null;
	private int port = 0;
	
	public JoystickWPI(int param) {
		port = param;
		joystick = new edu.wpi.first.wpilibj.Joystick(param);
	}

	@Override
	public int getPort() {
		// TODO Auto-generated method stub
		return port;
	}

	public edu.wpi.first.wpilibj.Joystick getJoystick() {
		return joystick;
	}

}
