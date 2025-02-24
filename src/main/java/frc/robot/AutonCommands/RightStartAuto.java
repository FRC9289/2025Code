package frc.robot.AutonCommands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.oldCode.ArmShootCommand;
import frc.robot.oldCode.DriveCommand;
import frc.robot.oldCode.ArmShooter;
import frc.robot.oldCode.Chassis;

public class RightStartAuto extends SequentialCommandGroup{
    final double shooterSpeed = 1;

    public RightStartAuto(Chassis chassis, ArmShooter shooter)
    {
        addCommands(
            new ArmShootCommand(shooter, shooterSpeed).withTimeout(1),
            new DriveCommand(chassis, 0, 1).withTimeout(3),
            new DriveCommand(chassis, -1, 0).withTimeout(0.5),
            new DriveCommand(chassis, 0, 1).withTimeout(1)
            
        );
        // shoot, go straight, turn left, then go straight again
    }
}
