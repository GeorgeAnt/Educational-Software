package com.atl.edusoftware.business.services

import com.atl.edusoftware.data.model.Answer
import com.atl.edusoftware.data.model.Question
import com.atl.edusoftware.data.repository.AnswerRepository
import com.atl.edusoftware.data.repository.QuestionRepository
import com.atl.edusoftware.web.TestRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EditService {

    @Autowired
    QuestionRepository questionRepository

    @Autowired
    AnswerRepository answerRepository

    void addTest(TestRequest request) {

        Question question = ['questionText': request.questionText, 'chapterId': request.chapterNumber as int]
        questionRepository.save(question)

        Answer answer1 = [
                'isCorrect' : request.isAnswer1Correct,
                'answerText': request.answerText1,
                'questionId': question
        ]

        Answer answer2 = [
                'isCorrect' : request.isAnswer2Correct,
                'answerText': request.answerText2,
                'questionId': question
        ]

        Answer answer3 = [
                'isCorrect' : request.isAnswer3Correct,
                'answerText': request.answerText3,
                'questionId': question
        ]
        Answer answer4 = [
                'isCorrect' : request.isAnswer4Correct,
                'answerText': request.answerText4,
                'questionId': question
        ]

        List<Answer> answerList = [answer1, answer2, answer3, answer4]
        answerList.each { answer ->
            answerRepository.save(answer)
        }
    }

}
