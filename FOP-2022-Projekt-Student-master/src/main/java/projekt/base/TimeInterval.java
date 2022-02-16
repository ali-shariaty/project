package projekt.base;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeInterval {
    public final LocalDateTime start;
    public final LocalDateTime end;

    /**
     * Takes parameters
     * @param start the parameter to initialize the attribute with the same name
     * @param end the parameter to initialize the attribute with the same name
     * @throws NullPointerException if any of the parameters is null
     * @throws IllegalArgumentException if the start happens chronologically sooner than the end
     */
    public TimeInterval(LocalDateTime start, LocalDateTime end) throws NullPointerException, IllegalArgumentException{
        if(start == null)
            throw new NullPointerException("start");
        if(end == null)
            throw new NullPointerException("end");
        if(start.isAfter(end))
            throw new IllegalArgumentException("Start " + start.toString() + " is after end " + end.toString());
        this.start = start;
        this.end = end;
    }

    /**
     * Getter method
     * @return the object the "start" attribute refers to
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * Getter method
     * @return the object the "end" attribute refers to
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     * @return a Duration object, the time gone by from the start event to the end event
     */
    public Duration getDuration()
    {
        return Duration.between(start, end);
    }
}
