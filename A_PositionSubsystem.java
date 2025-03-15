

import edu.wpi.first.wpilibj2.command.Subsystem;

/**
 * T is some generic type that is either the position itself or a container to
 * retrieve the position.
 * PositionSubsystem compliments the logic of PositionCommand.
 */
public abstract class A_PositionSubsystem<T> extends TestableSubsystem {
    /**
     * Constructor for PositionSubsystem.
     * 
     * @param name is the name of the subsystem to be printed in the logs.
     */
    protected A_PositionSubsystem(String name) {
        super(name);
    }

    /**
     * Check if the subsystem can go to the desired position.
     * 
     * @param checkPosition is the position to check if the subsystem can go to.
     * @return true if the subsystem can go to the desired position, false
     *         otherwise.
     */
    public abstract boolean canGoToPosition(T checkPosition);

    /**
     * Set the position of the subsystem.
     * 
     * @param setPosition is the position to set the subsystem to.
     * @return true if the position was set successfully, false otherwise.
     */
    public abstract boolean setPosition(T setPosition);

    /**
     * Check if the subsystem is at the desired position.
     * 
     * @return true if the subsystem is at the desired position, false otherwise.
     */
    public abstract boolean isAtPosition();

    /**
     * Stops the motors of the subsystem.
     */
    public abstract void stopMotors();

    /**
     * Get a new PositionCommand with the desired position.
     * 
     * @param position is the desired position this new position command would set
     *                 this subsystem to.
     * @return a new PositionCommand with the desired position.
     */
    public PositionCommand<T> getNewPositionCommand(T position) {
        return new PositionCommand<T>(this, position);
    }
}