package com.solace.streams.messages;

import com.solace.streams.types.Signup;
import com.solace.streams.types.User;

public class UserSignedUp {
	public static class Payload implements java.io.Serializable {
		private static final long serialVersionUID = 1L;

		public Payload() {}
		public Payload(User user, Signup signup) {
		    this.user = user;
		    this.signup = signup;
        }

		public User getUser() {
			return this.user;
		}
		public void setUser(final User user) {
			this.user = user;
		}

		public Signup getSignup() {
			return this.signup;
		}
		public void setSignup(final Signup signup) {
			this.signup = signup;
		}


		private User user;
		private Signup signup;
	}

	public UserSignedUp() {}
	public UserSignedUp(final Payload payload) {
	    this.payload = payload;
    }

	public void setPayload(final Payload payload) {
		this.payload = payload;
	}
	public Payload getPayload() {
		return this.payload;
	}

    private Payload payload;
}
