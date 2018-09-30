package com.atl.edusoftware.business.services

import com.atl.edusoftware.data.model.Chapter
import com.atl.edusoftware.data.model.Question
import com.atl.edusoftware.data.repository.ChapterRepository
import com.atl.edusoftware.data.repository.QuestionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.servlet.http.HttpServletRequest
import java.text.DecimalFormat

@Service
class QuizService {

    @Autowired
    private QuestionRepository questionRepository

    @Autowired
    private ChapterRepository chapterRepository

    Iterable<Question> findAll() {
        return questionRepository.findAll()
    }

    List<Question> getQuizByChapterId(int chapterId) {
        Chapter chapter = chapterRepository.findOne(chapterId)
        return questionRepository.findFirst10ByChapter(chapter)
    }

    List<Question> getQuestionsInRandomOrder() {
        return questionRepository.findQuestionsInRandomOrder()
    }

    static Double getResults(HttpServletRequest request) {
        def count = 0
        def total = 0
        DecimalFormat decimalFormat = new DecimalFormat("####0.00")
        request.getParameterMap().each { k ->
            if (k.value[0] == "true") {
                count++
            }
            total++
        }
        return decimalFormat.format(count * 100 / (total - 1)) as double
    }

}
