package org.example.Exceptions;

public class AuthErrorNotPartnerRu extends AuthErrorNotPartner {
    String country;
    public AuthErrorNotPartnerRu(String message, String username, String codePartner) {
        super(message, username, codePartner);
    }
}
