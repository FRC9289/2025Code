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
    private double drive_seconds = 3.25;
    private double t1 = 0.5588;

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
        if(timer.get() < t1){
            drivetrain.swerveDrive(0.25, 0.0, 0.0, false, new Translation2d(), false);
        }
    }
}
//Written by Wolfram121