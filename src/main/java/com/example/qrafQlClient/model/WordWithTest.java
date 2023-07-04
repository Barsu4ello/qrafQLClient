package com.example.qrafQlClient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WordWithTest {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("english")
    private String english;
    @JsonProperty("russian")
    private String russian;
    @JsonProperty("word_type")
    private String wordType;
    @JsonProperty("test")
    private MyTest test;
    @JsonProperty("user_id")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getRussian() {
        return russian;
    }

    public void setRussian(String russian) {
        this.russian = russian;
    }

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    public MyTest getTest() {
        return test;
    }

    public void setTest(MyTest test) {
        this.test = test;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

class MyTest {
    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}


