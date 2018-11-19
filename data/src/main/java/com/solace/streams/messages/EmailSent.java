package com.solace.streams.messages;

import com.solace.streams.types.User;

public class EmailSent {
	public static class Payload implements java.io.Serializable {
		private static final long serialVersionUID = 1L;
		
		public Payload() {}
		public Payload(final User user, final String content) {
		    this.user = user;
		    this.content = content;
        }

		public void setUser(final User user) {
			this.user = user;
		}
		public User getUser() {
			return this.user;
		}

		public void setContent(final String content) {
			this.content = content;
		}
		public String getContent() {
			return this.content;
		}

		private String content;
		private User user;
	}

	public EmailSent() {}
	public EmailSent(final Payload payload) {
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
