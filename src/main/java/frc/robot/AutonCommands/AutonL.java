package frc.robot.AutonCommands;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.CommandConstants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;

public class AutonL extends Command{
    private Drivetrain drivetrain = Drivetrain.getInstance();
    private Timer timer;
    private double t_total = 3.25;
    private double t1 = 0.5588; //Speed = 4 m/s, Distance = 88 inches
    private double front;
    private double side;
    private double rotation;

    private AutonL() {
        timer = new Timer();
        addRequirements(drivetrain);
    }

    @Override
    public void initialize(){
        timer.restart();
    }

    @Override
    public void execute(){
        drivetrain.swerveDrive(front, side, rotation, false, new Translation2d(), false);
        if(timer.get() < t1){
        }
    }
}
//Written by Wolfram121