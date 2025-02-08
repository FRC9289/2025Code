package frc.robot.AutonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.oldCode.ArmShootCommand;
import frc.robot.oldCode.Chassis;
import frc.robot.oldCode.DriveCommand;

public class NonSpeakerStartAuto extends SequentialCommandGroup{
    
    public NonSpeakerStartAuto(Chassis chassis)
    {
        addCommands(
            new DriveCommand(chassis, 0, -.65).withTimeout(2.5)
        );
    }
}
