package org.example.Exceptions;

public class AuthError extends RuntimeException {
  protected String username;
  protected String message;

    public AuthError(String message, String username) {
        super(message);
        this.username = username;
    }

    public AuthError(String message) {
    }

    @Override
  public String toString() {
    return super.getMessage()+ " AuthError{" +
            "username='" + username + '\'' +
            '}';
  }
}
