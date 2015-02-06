/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5010.robot;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.PIDSource;
/**
 *
 * @author HP Customer
 */
public class SpeedControllerGroup implements SpeedController, PIDOutput {
    private SpeedController num1,num2;
    private double invertMult;//-1 or 1
    public SpeedControllerGroup(SpeedController num1, SpeedController num2,boolean invert){
	this.num1 = num1;
	this.num2 = num2;
	invertMult=invert?-1:1;
    }
    public double get() {
	//we'll trust other parts of the project not to hold refences to these and change them
	return num1.get()*invertMult;
    }

    public void set(double d, byte b) {
	d*=invertMult;
	num1.set(d,b);
	num2.set(d,b);
    }

    public void set(double d) {
	d*=invertMult;
	num1.set(d);
	num2.set(d);
    }

    public void disable() {
	num1.disable();
	num2.disable();
    }

    public void pidWrite(double d) {
	num1.pidWrite(d);
	num2.pidWrite(d);
    }

}