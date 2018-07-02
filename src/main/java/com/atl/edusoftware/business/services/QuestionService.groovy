package com.atl.edusoftware.business.services

import com.atl.edusoftware.data.model.Answer
import com.atl.edusoftware.data.model.Chapter
import com.atl.edusoftware.data.model.Question
import com.atl.edusoftware.data.repository.AnswerRepository
import com.atl.edusoftware.data.repository.ChapterRepository
import com.atl.edusoftware.data.repository.QuestionRepository
import com.atl.edusoftware.web.TestRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class QuestionService {

    @Autowired
    QuestionRepository questionRepository

    @Autowired
    AnswerRepository answerRepository

    @Autowired
    ChapterRepository chapterRepository

    void addTest(TestRequest request) {
        Chapter chapter = chapterRepository.findOne(request.chapterNumber as Integer)
        Question question = [
                'id'          : request.questionId ?: null,
                'questionText': request.questionText,
                'chapter'     : chapter
        ]
        questionRepository.save(question)

        Answer answer1 = [
                'Id'        : request.answerId1 ?: null,
                'isCorrect' : request.isAnswer1Correct,
                'answerText': request.answerText1,
                'questionId': question
        ]

        Answer answer2 = [
                'Id'        : request.answerId2 ?: null,
                'isCorrect' : request.isAnswer2Correct,
                'answerText': request.answerText2,
                'questionId': question
        ]

        Answer answer3 = [
                'Id'        : request.answerId3 ?: null,
                'isCorrect' : request.isAnswer3Correct,
                'answerText': request.answerText3,
                'questionId': question
        ]
        Answer answer4 = [
                'Id'        : request.answerId4 ?: null,
                'isCorrect' : request.isAnswer4Correct,
                'answerText': request.answerText4,
                'questionId': question
        ]

        List<Answer> answerList = [answer1, answer2, answer3, answer4]
        answerList.each { answer ->
            answerRepository.save(answer)
        }
    }

    Question getQuestionById(Long questionId) {
        questionRepository.findOne(questionId)
    }

    TestRequest getTestRequestByQuestionId(Long questionId) {
        TestRequest testRequest = new TestRequest()
        Question question = questionRepository.findOne(questionId)
        testRequest.questionId = questionId
        testRequest.questionText = question.questionText ?: ""
        testRequest.answerText1 = question?.answers[0].answerText ?: ""
        testRequest.answerId1 = question?.answers[0]?.Id ?: null
        testRequest.answerText2 = question?.answers[1].answerText ?: ""
        testRequest.answerId2 = question?.answers[1]?.Id ?: null
        testRequest.answerText3 = question?.answers[2].answerText ?: ""
        testRequest.answerId3 = question?.answers[2]?.Id ?: null
        testRequest.answerText4 = question?.answers[3].answerText ?: ""
        testRequest.answerId4 = question?.answers[3]?.Id ?: null
        testRequest.isAnswer1Correct = question?.answers[0]?.isCorrect ?: false
        testRequest.isAnswer2Correct = question?.answers[1]?.isCorrect ?: false
        testRequest.isAnswer3Correct = question?.answers[2]?.isCorrect ?: false
        testRequest.isAnswer4Correct = question?.answers[3]?.isCorrect ?: false
        testRequest.chapterNumber = question?.chapter?.chapterId ?: 0

        testRequest
    }

    void deleteQuestion(Long questionId) {
        questionRepository.delete(questionId)
    }

}
