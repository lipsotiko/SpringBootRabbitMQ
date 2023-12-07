package com.edxm.interview;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class HelloWorldControllerTest {

    @Mock
    private HelloWorldSender sender;

    @InjectMocks
    private HelloWorldController subject;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sends_message() {
        HelloWorld message = new HelloWorld("hello");
        subject.hello(message);
        verify(sender, times(1)).send(message);
    }
}
