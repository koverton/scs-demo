package com.solace.streams;

import com.solace.streams.messages.EmailSent;
import com.solace.streams.messages.UserSignedUp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;

import static com.solace.streams.messages.MsgUtil.*;

/// - - - - - - - - - - - - - - - - - - - - - - - - - -
/// - - - - User-Signed-Up event processor:     - - - -
/// - - - - - Sends an email, and an event      - - - -
/// - - - - - - - - - - - - - - - - - - - - - - - - - -

@SpringBootApplication
public class DemoProcessorApp
{
    // 1. Bind to the application.yml INPUT and OUTPUT

    public EmailSent onUserSignup(final UserSignedUp event) {

        System.out.println(" ================= USER SIGNUP ============== ");

        System.out.println(" ================= SEND AN EMAIL ============== ");

        // 2. Convert UserSignedUp event into an internal EmailSent event

        return null;
    }


    public static void main( String[] args )
    {
        SpringApplication.run(DemoProcessorApp.class, args);
    }
}
