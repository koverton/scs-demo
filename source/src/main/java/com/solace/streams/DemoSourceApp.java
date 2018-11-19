package com.solace.streams;

import com.solace.streams.messages.*;
import com.solace.streams.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import static com.solace.streams.messages.MsgUtil.makeMessage;
import static com.solace.streams.messages.MsgUtil.makeUserSignup;

/// - - - - - - - - - - - - - - - - - - - - - - - - - -
/// - - - - Mock User-Signed-Up event generator - - - -
/// - - - - - - - - - - - - - - - - - - - - - - - - - -

@SpringBootApplication
public class DemoSourceApp
{


    public void sendUserSignupEvent() {

        System.out.println(" ================= USER SIGNUP EVENT ============== ");
        // 1. Generate a new UserSignedUp event

        // 2. Convert that to a SCS Message (prepare it for serialization)

        // 3. Send the message to the application.yml OUTPUT destination
    }

    // 4. Schedule fixed rate trigger to generate a flow of messages


    public static void main( String[] args )
    {
        SpringApplication.run(DemoSourceApp.class, args);
    }

}
