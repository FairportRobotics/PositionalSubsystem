# PositionalSubsystem

PositionalSubsystem is a Java library that defines a relationship between PositionCommand and any subsystem that implements A_PositionSubsystem (called 'PositionSubsystem' from now on), namely those that can be set to some position using some generic type 'T'.

PositionCommand can be used as is, but subsystems must implement methods in the interface properly themselves.

# How to use

The generic 'T' is like an agreement between the PositionCommand and PositionSubsystem where 'T' is the object that both the PositionCommand and the PositionSubsystem agree to interact with each other via the 'setPosition' method.

Subsystems used by the directory can extend the A_PositionSubsystem and would need to implement properly the abstract methods. All subsystems are provided a method that would return a new PositionCommand with the correct generic, given the position.

Example usage of PositionCommand:

```Java (in RobotContainer.java's "configureBindings()' method)
    XboxController.povUp().onTrue(new PositionCommand<Double>(ExampleSubsystem, position));
    // OR //
    XboxController.povUp().onTrue(ExampleSubsystem.getNewPositionCommand(position))
```

Example subsystem:

```Java
import org.fairportrobotics.PositionalSubsystem.A_PositionSubsystem;

public class ExampleSubsystem extends A_PositionSubsystem<Double> {

    public ExampleSubsystem(){
        super("ExampleSubsystem"); // Setting subsystem name

        @Override
        public boolean canGoToPosition(T checkPosition)
        {
            //Implementation goes here.
        }

        @Override
        public boolean setPosition(T setPosition)
        {
            //Implementation goes here.
        }

        @Override
        public boolean isAtPosition()
        {
            //Implementation goes here.
        }

        @Override
        public void stopMotors()
        {
            //Implementation goes here.
        }

        //getNewPositionCommand(T position) is already implemented to be called outside this class.
    }
}
```

# Including in FRC Project

To include this library in a Java FRC Robot project.

# Building

The project can be built and published to the local Maven repository using `./gradlew pubLocal`

## Updating version

The version tag can be found in `gradle.properties`. When updating the version match the year to the current year, and increment the major and minor version as needed.
