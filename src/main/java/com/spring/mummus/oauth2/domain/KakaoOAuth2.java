package com.spring.mummus.oauth2.domain;

import com.spring.mummus.member.entity.Member;

import java.util.Map;

public class KakaoOAuth2 implements OAuth2 {

    private Map<String, Object> attributes;

    public KakaoOAuth2(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public Member from(OAuth2 oAuth2) {
        return Member.builder()
                .name(oAuth2.getName())
                .provider(oAuth2.getProvider())
                .build();
    }
//    public static String snsId;
//    public static Map<String, Object> account;
//    public static Map<String, Object> profile;
//
//    public KakaoOAuth2(Map<String, Object> attributes) {
//        snsId = String.valueOf(attributes.get("id"));
//        account = (Map<String, Object>) attributes.get("kakao_account");
//        profile = (Map<String, Object>) account.get("profile");
//    }
//
//    public String getSnsId() {
//        return snsId;
//    }
//
//    public String getName() {
//        return String.valueOf(profile.get("nickname"));
//    }
}
