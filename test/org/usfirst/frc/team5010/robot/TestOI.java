package org.usfirst.frc.team5010.robot;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.usfirst.frc.team5010.robot.impls.FactoryFake;
import org.usfirst.frc.team5010.robot.interfaces.RobotFactory;

public class TestOI {
	static RobotFactory factory = null;
	
	@BeforeClass
	public static void setup() {
		factory = new FactoryFake();
	}
	
	@Test
	public void CreateOI() {
		OI oi = new OI(factory);
		assertNotNull(oi);
		assertEquals(1, oi.getMainJoystick().getPort());
		assertEquals(oi.getUpButtonIndex(), oi.getUpButton().getButtonIndex());
		assertEquals(oi.getDownButtonIndex(), oi.getDownButton().getButtonIndex());
	}

}
