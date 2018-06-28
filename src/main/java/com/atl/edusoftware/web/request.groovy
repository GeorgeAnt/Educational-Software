package com.atl.edusoftware.web

import com.atl.edusoftware.annotations.Request

@Request
class UserLoginRequest{
    String email
    String password
}

@Request
class TestRequest {
    String questionText
    String answerText1
    boolean isAnswer1Correct
    String answerText2
    boolean isAnswer2Correct
    String answerText3
    boolean isAnswer3Correct
    String answerText4
    boolean isAnswer4Correct
    String answerText5
    boolean isAnswer5Correct
    String answerText6
    boolean isAnswer6Correct
    def chapterNumber
    def CorrectNumber
}