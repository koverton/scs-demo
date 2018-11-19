package com.solace.streams;

import com.solace.streams.messages.EmailSent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;

import static com.solace.streams.messages.MsgUtil.*;

/// - - - - - - - - - - - - - - - - - - - - - - - - - -
/// - - - - EmailSent event listener            - - - -
/// - - - - - observes the resulting event      - - - -
/// - - - - - - - - - - - - - - - - - - - - - - - - - -

@SpringBootApplication
public class DemoSinkApp
{

    // 1. Bind to the application.yml INPUT
    public void onEmailSent(final EmailSent event) {

        // 2. Biz-logic: for now just prettyprint each message

    }


    public static void main( String[] args )
    {
        SpringApplication.run(DemoSinkApp.class, args);
    }
}
