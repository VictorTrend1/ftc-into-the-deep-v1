package org.firstinspires.ftc.teamcode.manuel;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@TeleOp(name="teleopv1")

public class TEPEOP extends LinearOpMode {
    private enum state {INIT, COLECTARE, SCORARE, AGATARE};
    private enum scorare {HIGHER_BUCKET,SPECIMEN,LOWER_BUCKET}

    @Override
    public void runOpMode() throws InterruptedException {

        Thread auto;
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        constants constante = new constants();
        hardware motoare = new hardware(hardwareMap);

        drive.leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        drive.leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        drive.rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        drive.rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motoare.setpos(motoare.gripper, constante.GRIPPER_DESCHIS);
        motoare.setpos(motoare.gripperrot, constante.GRIPPER_LUNG);
        motoare.setpos(motoare.cioc, constante.CIOC_INIT);
        motoare.setpos(motoare.extindere, constante.EXTINDERE_RETRAS);
        motoare.neveu(constante.NEVEU_INIT);
        motoare.setpos(motoare.ciocn, constante.NEVEU_CIOC_INIT);
        motoare.setpos(motoare.grippern, constante.GRIPPERN_INCHIS);
        motoare.culisante(constante.CULISANTA_JOS);

        state mod = state.INIT;
        scorare loc = scorare.SPECIMEN;

        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {


            drive.setDrivePowers(new PoseVelocity2d(
                    new Vector2d(
                            -gamepad1.left_stick_y,
                            -gamepad1.left_stick_x
                    ),
                    -gamepad1.right_stick_x

            ));

            switch (mod) {
                case INIT: {
                    motoare.setpos(motoare.gripper, constante.GRIPPER_DESCHIS);
                    motoare.setpos(motoare.gripperrot, constante.GRIPPER_LAT);
                    motoare.setpos(motoare.cioc, constante.CIOC_INIT);
                    motoare.setpos(motoare.extindere, constante.EXTINDERE_RETRAS);
                    motoare.neveu(constante.NEVEU_INIT);
                    motoare.setpos(motoare.ciocn, constante.NEVEU_CIOC_INIT);
                    motoare.setpos(motoare.grippern, constante.GRIPPERN_DESCHIS);


                    if(gamepad2.touchpad){
                        motoare.setpos(motoare.gripper, constante.GRIPPER_DESCHIS);
                        motoare.setpos(motoare.gripperrot, constante.GRIPPER_LUNG);
                        motoare.setpos(motoare.cioc, constante.CIOC_INIT);
                        motoare.setpos(motoare.extindere, constante.EXTINDERE_RETRAS);
                        motoare.neveu(constante.NEVEU_INIT);
                        motoare.setpos(motoare.ciocn, constante.NEVEU_CIOC_INIT);
                        motoare.setpos(motoare.grippern, constante.GRIPPERN_INCHIS);
                        motoare.culisante(constante.CULISANTA_SUS);

                        sleep(100);
                        mod = state.AGATARE;
                        break;
                    }


                    if (gamepad2.square) {

                        motoare.setpos(motoare.gripper, constante.GRIPPER_DESCHIS);
                        motoare.setpos(motoare.cioc, constante.CIOC_COLECTARE);
                        motoare.setpos(motoare.extindere, constante.EXTINDERE_RETRAS);


                        sleep(100);
                        mod = state.COLECTARE;
                        break;
                    }

                }

                case COLECTARE: {
                 if(gamepad2.left_trigger !=0){
                     motoare.setpos(motoare.gripperrot,constante.GRIPPER_LAT);
                 }
                 else{
                     motoare.setpos(motoare.gripperrot,constante.GRIPPER_LUNG);
                 }


                 if(gamepad2.right_trigger !=0){
                     motoare.setpos(motoare.cioc,constante.CIOC_COLECTARE_JOS);
                 }
                 else{
                     motoare.setpos(motoare.cioc,constante.CIOC_COLECTARE);
                 }


                 if(gamepad2.left_bumper){
                     motoare.setpos(motoare.extindere,constante.EXTINDERE_EXTINS);
                 }


                 if(gamepad2.right_bumper){
                     motoare.setpos(motoare.extindere,constante.EXTINDERE_RETRAS);
                 }


                 if(gamepad1.left_bumper){
                     motoare.setpos(motoare.gripper, constante.GRIPPER_INCHIS);
                 }


                 if(gamepad1.right_bumper){
                     motoare.setpos(motoare.gripper,constante.GRIPPER_DESCHIS);
                 }


                 if(gamepad2.touchpad){
                     motoare.setpos(motoare.gripper, constante.GRIPPER_DESCHIS);
                     motoare.setpos(motoare.gripperrot, constante.GRIPPER_LUNG);
                     motoare.setpos(motoare.cioc, constante.CIOC_INIT);
                     motoare.setpos(motoare.extindere, constante.EXTINDERE_RETRAS);
                     motoare.neveu(constante.NEVEU_INIT);
                     motoare.setpos(motoare.ciocn, constante.NEVEU_CIOC_INIT);
                     motoare.setpos(motoare.grippern, constante.GRIPPERN_INCHIS);
                     motoare.culisante(constante.CULISANTA_SUS);

                     sleep(100);
                     mod = state.AGATARE;
                     break;
                 }


                if(gamepad2.square) {


                    motoare.setpos(motoare.gripperrot, constante.GRIPPER_LUNG);
                    motoare.setpos(motoare.cioc, constante.CIOC_INIT);
                    motoare.setpos(motoare.extindere, constante.EXTINDERE_RETRAS);
                    motoare.neveu(constante.NEVEU_INIT);
                    motoare.setpos(motoare.ciocn, constante.NEVEU_CIOC_INIT);
                    motoare.setpos(motoare.grippern, constante.GRIPPERN_INCHIS);
                    motoare.setpos(motoare.gripper, constante.GRIPPER_DESCHIS);


                    sleep(100);
                    mod = state.SCORARE;
                    break;
                }
                }
                case SCORARE:{
                    switch (loc){
                        case SPECIMEN:{
                            motoare.setpos(motoare.grippern, constante.GRIPPERN_INCHIS);
                            motoare.culisante(constante.CULISANTA_SPECIMENE);
                            motoare.neveu(constante.NEVEU_SCORARE_SPECIMEN);
                            motoare.setpos(motoare.ciocn, constante.NEVEU_CIOC_SCOARARE_SPECIMEN);

                            if(gamepad1.dpad_up)
                            {
                                auto = new Thread(() -> {
                                    try {
                                        motoare.culisante(constante.CULISANTE_SPECIMENE_SCORAT);
                                        while (motoare.culi1.isBusy()) {
                                            telemetry.addData("Pozitie motor:", motoare.culi1.getCurrentPosition());
                                        }
                                        motoare.grippern.setPosition(constante.GRIPPERN_DESCHIS);

                                        telemetry.update();
                                    }
                                    catch (Exception eroare) {
                                        telemetry.addData("Eroare in thread: ", eroare.getMessage());
                                        telemetry.update();
                                    }

                                });
                                auto.start();
                            }


                            if(gamepad1.square){
                                motoare.setpos(motoare.grippern, constante.GRIPPERN_INCHIS);
                                motoare.culisante(constante.CULISANTA_JOS);

                                sleep(100);
                                loc = scorare.HIGHER_BUCKET;
                                break;

                            }


                            if(gamepad1.square){
                                motoare.setpos(motoare.grippern,constante.GRIPPERN_INCHIS);
                                motoare.culisante(constante.CULISANTA_JOS);

                                sleep(100);
                                loc = scorare.LOWER_BUCKET;
                                break;

                            }


                        }


                        case HIGHER_BUCKET:{
                            if(gamepad1.dpad_up){
                                auto = new Thread(()->{

                                    try{
                                        motoare.culisante(constante.CULISANTA_UPPERBUCKET);
                                        while (motoare.culi1.isBusy()){
                                            telemetry.addData("Pozitie culisante: ",motoare.culi1.getCurrentPosition());
                                        }
                                        motoare.neveu(constante.NEVEU_SCORARE_BASKET);
                                        motoare.setpos(motoare.ciocn, constante.NEVEU_CIOC_SCORARE_BASKET);
                                        telemetry.update();
                                    }


                                    catch(Exception eroare){
                                        telemetry.addData("Eroare in thread: ",eroare);
                                        telemetry.update();
                                    }


                                });

                            }


                            if(gamepad2.right_bumper){
                                motoare.setpos(motoare.grippern,constante.GRIPPERN_DESCHIS);

                            }


                        }


                        case LOWER_BUCKET:{
                            if(gamepad1.dpad_up){

                                auto = new Thread(()->{
                                   try {
                                       motoare.culisante(constante.CULISANTA_LOWEBUCKET);
                                       while(motoare.culi1.isBusy()){
                                           telemetry.addData("Pozitie culisante: ",motoare.culi1.getCurrentPosition());
                                       }

                                       motoare.neveu(constante.NEVEU_SCORARE_BASKET);
                                       motoare.setpos(motoare.ciocn, constante.NEVEU_CIOC_SCORARE_BASKET);
                                       telemetry.update();
                                   }


                                   catch (Exception eroare){
                                       telemetry.addData("Eroare in thread: ", eroare);
                                       telemetry.update();
                                   }


                                    if(gamepad2.right_bumper){
                                        motoare.setpos(motoare.grippern,constante.GRIPPERN_DESCHIS);
                                    }

                                });
                                auto.start();


                            }




                        }



                        if(gamepad2.square){
                            motoare.setpos(motoare.gripper, constante.GRIPPER_DESCHIS);
                            motoare.setpos(motoare.gripperrot, constante.GRIPPER_LUNG);
                            motoare.setpos(motoare.cioc, constante.CIOC_INIT);
                            motoare.setpos(motoare.extindere, constante.EXTINDERE_RETRAS);
                            motoare.neveu(constante.NEVEU_INIT);
                            motoare.setpos(motoare.ciocn, constante.NEVEU_CIOC_INIT);
                            motoare.setpos(motoare.grippern, constante.GRIPPERN_INCHIS);
                            motoare.culisante(constante.CULISANTA_JOS);


                            sleep(100);
                            mod = state.INIT;
                            break;

                                }


                        if(gamepad2.touchpad){
                            motoare.setpos(motoare.gripper, constante.GRIPPER_DESCHIS);
                            motoare.setpos(motoare.gripperrot, constante.GRIPPER_LUNG);
                            motoare.setpos(motoare.cioc, constante.CIOC_INIT);
                            motoare.setpos(motoare.extindere, constante.EXTINDERE_RETRAS);
                            motoare.neveu(constante.NEVEU_INIT);
                            motoare.setpos(motoare.ciocn, constante.NEVEU_CIOC_INIT);
                            motoare.setpos(motoare.grippern, constante.GRIPPERN_INCHIS);
                            motoare.culisante(constante.CULISANTA_SUS);

                            sleep(100);
                            mod = state.AGATARE;
                            break;
                        }

                    }

                }

                case AGATARE:{

                    int pozitie= constante.CULISANTA_SUS;
                    if(gamepad2.right_bumper && motoare.culi2.getCurrentPosition()<constante.CULISANTA_SUS){
                        pozitie+=20;
                    }
                    if(gamepad2.left_bumper && motoare.culi2.getCurrentPosition()> constante.CULISANTA_JOS){
                        pozitie-=20;
                    }
                    if(gamepad2.dpad_down){
                        pozitie = constante.CULISANTA_AGATARE;
                    }

                    motoare.culisante(pozitie);


                }


            }
        }
    }
}
/// putina creatie cu thread-urile alea :Skull:

