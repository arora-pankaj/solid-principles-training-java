package com.iongroup.ldp.example;

import static com.iongroup.ldp.example.EmployeeBuilder.anEmployee;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.MonthDay;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BirthdayGreeterTest {
  private static final int CURRENT_MONTH = 7;
  private static final int CURRENT_DAY_OF_MONTH = 9;
  private static final MonthDay TODAY = MonthDay.of(CURRENT_MONTH, CURRENT_DAY_OF_MONTH);

  @Mock private EmployeeRepository employeeRepository;
  @Mock private Clock clock;

  @InjectMocks private BirthdayGreeter birthdayGreeter;

  private final ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();

  @Test
  public void should_send_greeting_email_to_employee() {
    System.setOut(new PrintStream(consoleContent));
    given(clock.monthDay()).willReturn(TODAY);
    Employee employee = anEmployee().build();
    given(employeeRepository.findEmployeesBornOn(MonthDay.of(CURRENT_MONTH, CURRENT_DAY_OF_MONTH)))
        .willReturn(Collections.singletonList(employee));

    birthdayGreeter.sendGreetings();

    String actual = consoleContent.toString();
    String expected =
        "To:"
            + employee.getEmail()
            + ", Subject: Happy birthday!, Message: Happy birthday, dear "
            + employee.getFirstName()
            + "!";
    assertEquals(expected, actual);
  }
}
