package com.example.qrafQlClient.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Word {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("english")
    private String english;
    @JsonProperty("russian")
    private String russian;
    @JsonProperty("word_type")
    private String wordType;
    @JsonProperty("test_id")
    private Long testId;
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

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", english='" + english + '\'' +
                ", russian='" + russian + '\'' +
                ", wordType='" + wordType + '\'' +
                ", testId=" + testId +
                ", userId=" + userId +
                '}';
    }
}
