package org.firstinspires.ftc.teamcode.manuel;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class hardware {
    Servo gripper,gripperrot,cioc,extindere,neveud,neveus,ciocn,grippern;
    DcMotorEx culi1,culi2;

    public hardware(HardwareMap hardwareMap){
        gripper = hardwareMap.get(Servo.class,"gripper");  /** gripper **/
        gripperrot = hardwareMap.get(Servo.class,"gripperrot");  /** gripperrot **/
        cioc = hardwareMap.get(Servo.class,"cioc");  /** cioc **/

        extindere = hardwareMap.get(Servo.class,"extindere");    /** extindere **/

        neveud = hardwareMap.get(Servo.class,"neveud");  /** neveu **/
        neveus = hardwareMap.get(Servo.class,"neveus"); /** neveu **/
        ciocn = hardwareMap.get(Servo.class,"ciocn"); /**  cioc neveu **/
        grippern = hardwareMap.get(Servo.class,"grippert"); /**  gripper transfer **/

        culi1 = hardwareMap.get(DcMotorEx.class,"culi1");
        culi1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        culi1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        culi1.setDirection(DcMotorSimple.Direction.FORWARD);

        culi2 = hardwareMap.get(DcMotorEx.class,"culi2");
        culi2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        culi2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        culi2.setDirection(DcMotorSimple.Direction.FORWARD);


    }
    public void controlmotor(DcMotorEx motor,int pos){
        motor.setTargetPosition(pos);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(1);
    }
    public void culisante(int pos){
        controlmotor(culi1,-pos);
        controlmotor(culi2,pos);
    }

    public void setpos(Servo servo,double pos){
        servo.setPosition(pos);
    }

    public void neveu(double pos){
        neveud.setPosition(pos);
        neveus.setPosition(pos);
    }




}
