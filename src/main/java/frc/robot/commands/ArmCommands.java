package frc.robot.commands;
import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.Timer;

public class ArmCommands {
    Arm arm;
    double power;
    boolean up;
    Timer timer = new Timer();
    double time = 2;

    public ArmCommands(double speed) {
        this.arm = new Arm();
        this.power = speed;
        this.up = false;
    }

    public void run() {
        if (!up) {
            timer.reset();
            while (timer.get() < time) {
                arm.move(this.power);
            }
        }
        else if (up) {
            timer.reset();
            while (timer.get() < time) {
                arm.move(-1 * this.power);
            }
        }
    }
}
// Written by Wolfram121