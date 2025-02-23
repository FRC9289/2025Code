package frc.robot.AutonCommands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;

public class AutonR extends Command{
    private Drivetrain drivetrain = Drivetrain.getInstance();
    private Timer timer;
    private Timer timer2;  
    private double t_total = 3.25;
    private double t1 = 0.5588; //Speed = 4 m/s, Distance = 88 inches
    private double t2 = 0.5; //Uknown distance, pls fix
    private double t3 = 0.1667; //Rotation = 60 degrees
    private double front;
    private double side;
    private double rotation;

    private AutonR() {
        timer = new Timer();
        timer2 = new Timer(); //Rly dumb but it could work. I think.
        addRequirements(drivetrain);
    }

    @Override
    public void initialize(){
        timer.restart();
    }

    @Override
    public void execute(){
        drivetrain.swerveDrive(front, side, rotation, false, new Translation2d(), false);
        timer2.restart();
        while (!timer2.hasElapsed(t1)){
            front = 0.25;
            side = 0;
            rotation = 0;
        }
        timer2.restart();
        while (!timer2.hasElapsed(t2)){
            front = 0;
            side = 0.25;
            rotation = 0;
        }
        timer2.restart();
        while (!timer2.hasElapsed(t3)){
            front = 0;
            side = 0;
            rotation = 0.25;
        }
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.swerveDrive(0, 0, 0, false, new Translation2d(), false);
        System.out.println("interrupted");
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= t_total;
    }
}
//Written by Wolfram121