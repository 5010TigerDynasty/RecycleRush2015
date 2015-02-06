/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5010.robot.commands;

/**
 *
 * @author HP Customer
 */
public abstract class JoystickBasedCommand extends CommandBase{
    private double deadZone=.2;
    private double assumeMaximum=.95;
    protected double filterInput(double input){
	if(Math.abs(input)<deadZone){
	    return -0;
	}
	if(input>assumeMaximum){
	    return 1;
	}
	if(input<-assumeMaximum){
	    return -1;
	}
	return input*input*input;
    }
}
