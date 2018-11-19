package com.solace.streams;

import com.solace.streams.types.*;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class TypesTest {

    @Test
    public void userTest() {
        User user = new User();
        assertNotNull(user);
        User fullUser = new User("1", "jimmy", "Jimmy Durante");
        assertNotNull(fullUser);
    }

    @Test
    public void signupTest() {
        Signup signup = new Signup();
        assertNotNull(signup);

        Signup fullSignup = new Signup(Signup.Method.TWITTER);
        assertNotNull(fullSignup);
    }
}
