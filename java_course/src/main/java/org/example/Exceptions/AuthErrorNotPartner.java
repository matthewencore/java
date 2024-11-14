package org.example.Exceptions;

public class AuthErrorNotPartner extends AuthError {
    String codePartner;
    public AuthErrorNotPartner(String message,String username,String codePartner) {
        super(message,username);
        this.codePartner = codePartner;
    }

    @Override
    public String toString() {
        return super.getMessage() +" AuthErrorNotPartner{" +
                " username= " + super.username +
                " codePartner='" + codePartner + '\'' +
                '}';
    }
}
