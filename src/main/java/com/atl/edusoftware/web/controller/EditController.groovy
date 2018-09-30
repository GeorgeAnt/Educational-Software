package com.atl.edusoftware.web.controller

import com.atl.edusoftware.business.services.ChapterService
import com.atl.edusoftware.business.services.LogsService
import com.atl.edusoftware.business.services.QuestionService
import com.atl.edusoftware.business.services.QuizService
import com.atl.edusoftware.data.model.Chapter
import com.atl.edusoftware.web.TestRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping(value = '/edit')
class EditController {

    @ModelAttribute("testRequest")
    TestRequest testRequest() {
        return new TestRequest()
    }

    @ModelAttribute("chapterRequest")
    Chapter chapter() {
        return new Chapter()
    }

    @Autowired
    QuestionService editService

    @Autowired
    ChapterService chapterService

    @Autowired
    QuizService quizService

    @Autowired
    LogsService logsService

    @Autowired
    QuestionService questionService

    @GetMapping(value = '/addQuestion')
    ModelAndView getAddQuestion() {
        ModelAndView modelAndView = new ModelAndView()
        modelAndView.setViewName('addQuestion')
        modelAndView.addObject('questions', quizService.findAll())
        return modelAndView
    }

    @PostMapping(value = '/addQuestion')
    ModelAndView addQuestion(
            @ModelAttribute("testRequest") TestRequest testRequest) {
        ModelAndView modelAndView = new ModelAndView()
        editService.addTest(testRequest)
        modelAndView.setViewName("dashboard")
        modelAndView.addObject('success', 'Your question have being successfully imported')
        return modelAndView
    }

    @GetMapping(value = '/questions', params = ["chapterId"])
    ModelAndView getQuestionsToEdit(@RequestParam("chapterId") int chapterId) {
        ModelAndView modelAndView = new ModelAndView()
        modelAndView.setViewName('questionsPerChapterList')
        modelAndView.addObject('questionList', quizService.getQuizByChapterId(chapterId))
        return modelAndView
    }

    @PostMapping(value = '/question', params = ["edit"])
    ModelAndView getEditQuestionView(@RequestParam("questionId") Long questionId) {
        ModelAndView modelAndView = new ModelAndView()
        modelAndView.setViewName('addQuestion')
        modelAndView.addObject('testRequest', questionService.getTestRequestByQuestionId(questionId))
        return modelAndView
    }

    @PostMapping(value = '/question', params = ["delete"])
    ModelAndView deleteQuestion(@RequestParam("questionId") Long questionId) {
        ModelAndView modelAndView = new ModelAndView()
        try {
            questionService.deleteQuestion(questionId)
        } catch (Exception e) {
            modelAndView.addObject('error', 'Something went Wrong')
            modelAndView.setViewName('dashboard')
            return modelAndView
        }
        modelAndView.setViewName('dashboard')
        modelAndView.addObject('success', 'Your question has being successfully deleted')
        return modelAndView
    }

    @GetMapping(value = '/theory', params = ["chapterId"])
    ModelAndView getEditTheoryView(@RequestParam("chapterId") int chapterId) {
        ModelAndView modelAndView = new ModelAndView()
        modelAndView.setViewName("editTheory")
        modelAndView.addObject('chapter', chapterService.getChapterById(chapterId))
        return modelAndView
    }

    @PostMapping(value = '/theory')
    ModelAndView addTheory(@ModelAttribute("chapterRequest") Chapter chapter, Model model) {
        try {
            chapterService.saveChapter(chapter)
        } catch (Exception e) {
            model.addAttribute('error', 'Something went Wrong')
            return new ModelAndView('redirect:/dashboard', model)
        }
        model.addAttribute('success', 'Your edit was successful!')
        return new ModelAndView('dashboard', model)
    }

}
