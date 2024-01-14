package com.hsenid.talkbook.model;

public class UserChat {

    private Long chatId;

    private String user_id;
    private String chatDescription;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getChatDescription() {
        return chatDescription;
    }

    public void setChatDescription(String chatDescription) {
        this.chatDescription = chatDescription;
    }
}
