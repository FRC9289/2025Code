// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.subsystems.*;
import frc.robot.AutonCommands.*;
import frc.robot.commands.*;
import frc.robot.SubsystemCommands.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // private static final Chassis _chassis = Chassis.returnInstance();
  public static final Joystick driverController = new Joystick(0);
  public static final JoystickButton resetHeading_Start = new JoystickButton(driverController, CommandConstants.ButtonX);
  // private final ArmShooter _shooter = new ArmShooter();
  private static final Hang hang = new Hang();
  private static Arm arm = new Arm();
  private final Drivetrain drivetrain = Drivetrain.getInstance();
  //initializating commands to put up as choices
  //old code
  // private final Command leftCommand = new LeftStartAuto(drivetrain);
  // private final Command middleCommand = new MiddleStartAuto(drivetrain);
  // private final Command rightCommand = new RightStartAuto(drivetrain);
  // private final Command nonSpeakerCommand = new NonSpeakerStartAuto(drivetrain);
  // private final OldHanger _hanger = new OldHanger();

  SendableChooser<Command> m_chooser;
  


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // configureBindings();
    CameraServer.startAutomaticCapture();
    drivetrain.setDefaultCommand(new SwerveDrive());
    configureBindings();
     m_chooser = new SendableChooser<>();


    //set up choices for autonomous program
    //  m_chooser.setDefaultOption("Non-Speaker Start", nonSpeakerCommand);
    // m_chooser.addOption("Left Start", leftCommand);
    // m_chooser.addOption("Middle Start", middleCommand);
    // m_chooser.addOption("Right Start", rightCommand);

    SmartDashboard.putData("Autonomous Chooser", m_chooser);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() 
  {
    resetHeading_Start.onTrue(new InstantCommand(drivetrain::zeroHeading, drivetrain));
    hang.setDefaultCommand(new HangMethods(hang, driverController));
    arm.setDefaultCommand(new ArmMethods(arm, driverController));
    // Configure the trigger bindings
    // _shooter.setDefaultCommand(new ArmShooterDefaultCommand(_shooter, _chassisController));
    // _hanger.setDefaultCommand(new HangDefaultCommand(_hanger, _chassisController));
    // _chassis.setDefaultCommand(new ArcadeDrive(_chassis, _chassisController));

    //uncomment when hanger installed onto the bot
    // _hanger.setDefaultCommand(new HangDefaultCommand(_hanger, _armController));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
      return m_chooser.getSelected();
      //return new AutoDrive(_chassis, _shooter);
  }
}