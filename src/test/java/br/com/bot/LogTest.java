package br.com.bot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class LogTest {

    private final Appender appender = mock(Appender.class);
    private final Logger logger = Logger.getRootLogger();

    @Before
    public void setup() {
        logger.addAppender(appender);
    }

    @Test
    public void validateInfoLogInteraction() {
        Log.info("Info interaction!");

        ArgumentCaptor<LoggingEvent> argument = forClass(LoggingEvent.class);

        verify(appender).doAppend(argument.capture());

        assertThat(argument.getValue().getLevel()).isEqualTo(Level.INFO);
        assertThat(argument.getValue().getMessage()).isEqualTo("Info interaction!");
        assertThat(argument.getValue().getLoggerName()).isEqualTo("root");
    }

    @Test
    public void validateWarningLogInteraction() {
        Log.warning("Warning interaction!");

        ArgumentCaptor<LoggingEvent> argument = forClass(LoggingEvent.class);

        verify(appender).doAppend(argument.capture());

        assertThat(argument.getValue().getLevel()).isEqualTo(Level.WARN);
        assertThat(argument.getValue().getMessage()).isEqualTo("Warning interaction!");
        assertThat(argument.getValue().getLoggerName()).isEqualTo("root");
    }

    @Test
    public void validateErrorLogInteraction() {
        Log.error("Error interaction!");

        ArgumentCaptor<LoggingEvent> argument = forClass(LoggingEvent.class);

        verify(appender).doAppend(argument.capture());

        assertThat(argument.getValue().getLevel()).isEqualTo(Level.ERROR);
        assertThat(argument.getValue().getMessage()).isEqualTo("Error interaction!");
        assertThat(argument.getValue().getLoggerName()).isEqualTo("root");
    }

    @After
    public void cleanup() {
        logger.removeAppender(appender);
    }

}
