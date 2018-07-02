package com.atl.edusoftware.web

import com.atl.edusoftware.annotations.Request

@Request
class UserLoginRequest{
    String email
    String password
}

@Request
class TestRequest {
    Long questionId
    String questionText
    String answerText1
    Long answerId1
    boolean isAnswer1Correct
    String answerText2
    Long answerId2
    boolean isAnswer2Correct
    Long answerId3
    String answerText3
    boolean isAnswer3Correct
    Long answerId4
    String answerText4
    boolean isAnswer4Correct
    int chapterNumber
}

@Request
class ChaptersRequest {
    String id
    String theory
}