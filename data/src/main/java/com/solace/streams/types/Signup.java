package com.solace.streams.types;

public class Signup implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

  public static enum Method
	{
		EMAIL("email"),
		FACEBOOK("facebook"),
		TWITTER("twitter"),
		GITHUB("github"),
		GOOGLE("google");
		private final String value;
		private Method(  final String value){
    this.value=value;
  }
		public @Override String toString() {
		return this.value;
	}
	}

	public Signup() {}
	public Signup(final Method method) {
      this.method = method;
    }

	public void setMethod(final Method method) {
		this.method = method;
	}
	public Method getMethod() {
		return this.method;
	}


    private Method method;
}
