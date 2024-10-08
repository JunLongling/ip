package Buu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

/**
 * JUnit test class for the Deadline class in the GPT application.
 */
public class DeadlineTest {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test
    public void testToFileFormat_withValidDeadline() {
        // Arrange
        LocalDateTime deadlineDateTime = LocalDateTime.parse("2023-08-26 18:00", DATE_TIME_FORMATTER);
        Deadline deadline = new Deadline("Submit assignment", deadlineDateTime);

        // Act
        String actual = deadline.toFileFormat();

        // Assert
        String expected = "D | 0 | Submit assignment | 2023-08-26 18:00 | 1";
        assertEquals(expected, actual);
    }

    @Test
    public void testToString_withValidDeadline() {
        // Arrange
        LocalDateTime deadlineDateTime = LocalDateTime.parse("2023-08-26 18:00", DATE_TIME_FORMATTER);
        Deadline deadline = new Deadline("Submit assignment", deadlineDateTime);

        // Act
        String actual = deadline.toString();

        // Assert
        String expected = "[D][ ] Submit assignment (by: Aug 26 2023, 6:00pm) (Priority: Low Priority)";
        assertEquals(expected, actual);
    }

    @Test
    public void testMarkAsDone() {
        // Arrange
        LocalDateTime deadlineDateTime = LocalDateTime.parse("2023-08-26 18:00", DATE_TIME_FORMATTER);
        Deadline deadline = new Deadline("Submit assignment", deadlineDateTime);

        // Act
        deadline.markAsDone();
        String actual = deadline.toString();

        // Assert
        String expected = "[D][X] Submit assignment (by: Aug 26 2023, 6:00pm) (Priority: Low Priority)";
        assertEquals(expected, actual);
    }

    @Test
    public void testSetPriority() {
        // Arrange
        LocalDateTime deadlineDateTime = LocalDateTime.parse("2023-08-26 18:00", DATE_TIME_FORMATTER);
        Deadline deadline = new Deadline("Submit assignment", deadlineDateTime);

        // Act
        deadline.setPriority(3);
        String actual = deadline.toString();

        // Assert
        String expected = "[D][ ] Submit assignment (by: Aug 26 2023, 6:00pm) (Priority: High Priority)";
        assertEquals(expected, actual);
    }
}
