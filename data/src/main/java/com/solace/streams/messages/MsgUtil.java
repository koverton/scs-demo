package com.solace.streams.messages;

import com.solace.streams.types.Signup;
import com.solace.streams.types.User;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;

public class MsgUtil {
    private static Integer idgen = 1;
    private static RandomString rando = new RandomString(5);
    static private final ObjectMapper mapper = new ObjectMapper();



    static public UserSignedUp makeUserSignup() {
        String username = rando.nextString();
        String fullname = initCap(username) + " " + initCap(rando.nextString());
        Signup.Method method = rando.nextMethod();
        return new UserSignedUp(
                new UserSignedUp.Payload(
                        new User((++idgen).toString(),username, fullname),
                        new Signup(method)
                )
        );
    }

    static public EmailSent sendEmail(final UserSignedUp signup) {
        return new EmailSent(
                new EmailSent.Payload(
                        signup.getPayload().getUser(),
                        signup.toString()
                )
        );
    }

    static public Message<UserSignedUp> makeMessage(UserSignedUp signedUpEvent) {
        return MessageBuilder.createMessage(
                signedUpEvent,
                new MessageHeaders(new HashMap<>())
        );
    }


    static public void simplePrint(EmailSent msg) {
        System.out.println("USERID: " + msg.getPayload().getUser().getId());
    }

    static public void prettyPrint(EmailSent msg) {
        try {
            System.out.println(
                    mapper.writerWithDefaultPrettyPrinter()
                            .writeValueAsString(msg)
            );
        }
        catch(JsonProcessingException jpe) {
            jpe.printStackTrace();
        }
    }



    private static String initCap(String word) {
        if (word != null && word.length() > 0) {
            char[] charArray = word.toCharArray();
            charArray[0] = Character.toUpperCase(charArray[0]);
            return new String(charArray);
        } else {
            return "";
        }
    }
}
