package frc.robot.SubsystemCommands;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwerveDrive extends Command{
    private Drivetrain drivetrain = drivetrain.getInstance();

    public 

    //x1 & y1 are the x and y axis from the strafing joystick
    // x2 is the x axis from the rotation joystick
    public static void drive(double x1, double y1, double x2){
        // square root of the length + width squared
        double r = Math.sqrt ((L * L) + (W * W));
        //revsers the input of the y axis
        y1 *=-1;

        //a, b, c, and d are the speeds of each of the 4 motors,   
        //with this code (0->1), change as needed depending on the motors
        double a = x1 - x2 * (L / r);
        double b = x1 + x2 * (L / r);
        double c = y1 - x2 * (W / r);
        double d = y1 + x2 * (W / r);

        //speeds
        BRDMotor.set(Math.sqrt((a * a) + (d * d)));
        BLDMotor.set(Math.sqrt((a * a) + (c * c)));
        FRDMotor.set(Math.sqrt((b * b) + (d * d)));
        FLDMotor.set(Math.sqrt((b * b) + (c * c)));

        //Angle of each motor
        FRTMotor.set(Math.atan2(a, d) / Math.PI);
        BLTMotor.set(Math.atan2(a, c) / Math.PI);
        FRTMotor.set(Math.atan2(b, d) / Math.PI);
        FLTMotor.set(Math.atan2(b, c) / Math.PI);

        SmartDashboard.putNumber("FLD", FLDMotor.get());
        SmartDashboard.putNumber("FLT", FLTMotor.get());
        SmartDashboard.putNumber("FRD", FRDMotor.get());
        SmartDashboard.putNumber("FRT", FRTMotor.get());
        SmartDashboard.putNumber("BLD", BLDMotor.get());
        SmartDashboard.putNumber("BLT", BLTMotor.get());
        SmartDashboard.putNumber("BRD", BRDMotor.get());
        SmartDashboard.putNumber("BRT", BRTMotor.get());
    }
    public SwerveDrive(){
        // //reset it every time -> to reset encosder specifically to initial settings
        FLDMotor.restoreFactoryDefaults();
        FLTMotor.restoreFactoryDefaults();
        FRDMotor.restoreFactoryDefaults();
        FRTMotor.restoreFactoryDefaults();
        BLDMotor.restoreFactoryDefaults();
        BLTMotor.restoreFactoryDefaults();
        BRDMotor.restoreFactoryDefaults();
        BRTMotor.restoreFactoryDefaults();

        // //set the speed limit on how fast the motor can go
        FLDMotor.setSmartCurrentLimit(MAX_SPEED);
        FLTMotor.setSmartCurrentLimit(1);
        FRDMotor.setSmartCurrentLimit(MAX_SPEED);
        FRTMotor.setSmartCurrentLimit(1);
        BLDMotor.setSmartCurrentLimit(MAX_SPEED);
        BLTMotor.setSmartCurrentLimit(1);
        BRDMotor.setSmartCurrentLimit(MAX_SPEED);
        BRTMotor.setSmartCurrentLimit(1);

        // //saves changes to motor controller / encoder
        FLDMotor.burnFlash();
        FLTMotor.burnFlash();
        FRDMotor.burnFlash();
        FRTMotor.burnFlash();
        BLDMotor.burnFlash();
        BLTMotor.burnFlash();
        BRDMotor.burnFlash();
        BRTMotor.burnFlash();

    }
    
}
