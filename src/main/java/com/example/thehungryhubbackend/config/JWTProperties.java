package com.example.thehungryhubbackend.config;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Component
public class JWTProperties {
    private final OAuth2 oAuth2;
    private final Auth auth;

    public Auth getAuth() {
        return auth;
    }

    public OAuth2 getOauth2() {
        return oAuth2;
    }

    public JWTProperties(JwtConfiguration jwtConfiguration){
        ArrayList<String> authorizedRedirectUrisVal = new ArrayList<>(jwtConfiguration.getAuthorizedRedirectUris());
        this.oAuth2 = new OAuth2(authorizedRedirectUrisVal);
        this.auth = new Auth();
    }

    public static class Auth {
        private String tokenSecret;
        private long tokenExpirationMsec;

        public String getTokenSecret() {
            return tokenSecret;
        }

        public void setTokenSecret(String tokenSecret) {
            this.tokenSecret = tokenSecret;
        }

        public long getTokenExpirationMsec() {
            return tokenExpirationMsec;
        }

        public void setTokenExpirationMsec(long tokenExpirationMsec) {
            this.tokenExpirationMsec = tokenExpirationMsec;
        }
    }

    public OAuth2 getOAuth2(){
        return oAuth2;
    }

    public static final class OAuth2{
        public List<String> authorizedRedirectUris;

        public OAuth2(List<String> authorizedRedirectUris){
            this.authorizedRedirectUris = authorizedRedirectUris;
        }

        List<String> getAuthorizedRedirectUris(){
            return authorizedRedirectUris;
        }

        public OAuth2 authorizedRedirectUris(List<String> authorizedRedirectUris){
            this.authorizedRedirectUris = authorizedRedirectUris;
            return this;
        }
    }



    @Configuration
    @ConfigurationProperties(prefix = "thehungryhub.jwt")
    @Validated
    static class JwtConfiguration{

        @NotEmpty
        private List<String> authorizedRedirectUris;

        public List<String> getAuthorizedRedirectUris(){
            return this.authorizedRedirectUris;
        }

        public void setAuthorizedRedirectUris(List<String> authorizedRedirectUris){
            this.authorizedRedirectUris = authorizedRedirectUris;
        }
    }
}
