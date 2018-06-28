package com.atl.edusoftware.business.services

import com.atl.edusoftware.data.model.Answer
import com.atl.edusoftware.data.model.Question
import com.atl.edusoftware.data.repository.AnswerRepository
import com.atl.edusoftware.data.repository.QuestionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.servlet.http.HttpServletRequest

@Service
class EditService {

    @Autowired
    QuestionRepository questionRepository

    @Autowired
    AnswerRepository answerRepository

    void addTest(HttpServletRequest request) {


        Question question = new Question()
        question.chapterId = request.getParameter('chapter-id') as int
        question.questionText = request.getParameter('question') as String
        questionRepository.save(question)
        Question question1 = questionRepository.findFirstByOrderByIdDesc()
        Answer answer1 = [
                'isCorrect' : false,
                'answerText': request.getParameter('answer-1').toString(),
                'questionId': question1.id
        ]
        Answer answer2 = [
                'isCorrect' : false,
                'answerText': request.getParameter('answer-2').toString(),
                'questionId': question1.id
        ]
        Answer answer3 = [
                'isCorrect' : false,
                'answerText': request.getParameter('answer-3').toString(),
                'questionId': question1.id
        ]
        Answer answer4 = [
                'isCorrect' : true,
                'answerText': request.getParameter('answer-4').toString(),
                'questionId': question1.id
        ]
        Question question2 = questionRepository.findOne(question1.id)
        question1.answers = [answer1, answer2, answer3, answer4]
        questionRepository.save(question2)
    }

}
