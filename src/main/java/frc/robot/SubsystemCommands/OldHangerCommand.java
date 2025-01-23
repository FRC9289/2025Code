package frc.robot.SubsystemCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.OldHanger;

public class OldHangerCommand extends Command{
    
    OldHanger hangMotor;
    String motorID ="";
    double power;

   public OldHangerCommand(OldHanger _hangMotor, double speed)
   {
        this.hangMotor = _hangMotor;
        this.power = speed;
        addRequirements(hangMotor);
   } 

   @Override
   public void execute()
   {
     hangMotor.move(power);
   }
}
