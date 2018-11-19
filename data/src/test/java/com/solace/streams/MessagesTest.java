package com.solace.streams;

import com.solace.streams.messages.*;
import com.solace.streams.types.*;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class MessagesTest {


    @Test
    public void emailSentTest() {
        EmailSent message = new EmailSent();
        assertNotNull(message);

        EmailSent fullmsg = new EmailSent(
            new EmailSent.Payload(
                new User("id", "user", "full name"),
                "This is the content"
            ));
        assertNotNull(fullmsg);
    }

    @Test
    public void userSignedUpTest() {
        UserSignedUp empty = new UserSignedUp();
        assertNotNull(empty);

        UserSignedUp fullmsg = new UserSignedUp(
                new UserSignedUp.Payload(
                        new User("id", "user", "Full Name"),
                        new Signup(Signup.Method.TWITTER)
                )
        );
        assertNotNull(fullmsg);
    }
}
