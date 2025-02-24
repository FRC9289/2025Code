package frc.robot.AutonCommands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.oldCode.ArmShootCommand;
import frc.robot.oldCode.DriveCommand;
import frc.robot.oldCode.ArmShooter;
import frc.robot.oldCode.Chassis;


public class LeftStartAuto extends SequentialCommandGroup{

    final double shooterSpeed = 1;

    public LeftStartAuto(Chassis chassis, ArmShooter shooter)
    {
//TODO, TEST ON THURDSAY --> CHANGED TO NOT HAVE DEADLINEPARALLEL

        addCommands(
            new ArmShootCommand(shooter, shooterSpeed).withTimeout(1),
            new DriveCommand(chassis, 0, 1).withTimeout(3),
            new DriveCommand(chassis, 1, 0).withTimeout(0.5),
            new DriveCommand(chassis, 0, 1).withTimeout(1)
            
        );

        // shoot, go straight, turn right, then go straight
    }
}
