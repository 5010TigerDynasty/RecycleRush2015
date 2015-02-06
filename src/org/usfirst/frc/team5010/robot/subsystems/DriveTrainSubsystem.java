/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team5010.robot.subsystems;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5010.robot.RobotMap;

/**
 *
 * @author HP Customer
 */
public class DriveTrainSubsystem extends Subsystem implements PIDOutput{

    private Gyro gyro=RobotMap.gyro;//source must be integral of velocity error
    private double p=.1;
    private double i=0;
    private double d=.5;
    private PIDController controller = new PIDController(p,i,d,gyro,this);
    private boolean isPIDing = false;
    private double forward=0,right=0;
    private SpeedController leftMotor=RobotMap.leftMotor,rightMotor=RobotMap.rightMotor;
    
    protected void initDefaultCommand() {
	
    }
    public void setForward(double forward){
	this.forward=forward;
	updateSpeeds();
    }
    public void setRight(double right){
	this.right=right;
	updateSpeeds();
    }
    public double getForward(){
	return this.forward;
    }
    public double getRight(){
	return this.right;
    }
    private void setLeftWheels(double speed){
	leftMotor.set(speed);
    }
    private void setRightWheels(double speed){
	rightMotor.set(speed);
    }
    private void updateSpeeds(){
	if(!isPIDing){
	    setLeftWheels(forward+right);
	    setRightWheels(forward-right);
	    System.out.println(right+" "+forward);
	}
	if(isPIDing&& (right!=0||forward==0)){//we need to turn or stop, stop the PID
	    isPIDing=false;
	    controller.disable();
	}
	if(!isPIDing&& right==0){//we need to not turn, start the PID;
	    isPIDing=true;
	    gyro.setPIDSourceParameter(PIDSourceParameter.kAngle);
	    controller.setSetpoint(gyro.pidGet());
	    controller.enable();
	}
    }

    public void pidWrite(double right) {
	if(isPIDing){
	    right*=Math.abs(forward);
	    setLeftWheels(this.forward+right);
	    setRightWheels(this.forward-right);
	}
    }
    
    
}
