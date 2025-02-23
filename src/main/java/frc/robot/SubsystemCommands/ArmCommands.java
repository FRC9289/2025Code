package frc.robot.SubsystemCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.Timer;

public class ArmCommands extends Command {
    // Define Motor Attributes
    Arm armMotor;
    double power;
    boolean up;
    Timer timer = new Timer();
    double mtime = 2;

    public ArmCommands(Arm _armMotor, double speed) {
        this.armMotor = _armMotor;
        this.power = speed;
        this.up = false;
        addRequirements(armMotor);
    }

    public void up() {
        if (up) {
            timer.reset();
            while (timer.get() < mtime) {
                armMotor.move(this.power);
            }
        }
    }

    public void down() {
        if (!up) {
            timer.reset();
            while (timer.get() < mtime) {
                armMotor.move(-1 * this.power);
            }
        }
    }
}
//Written by Wolfram121