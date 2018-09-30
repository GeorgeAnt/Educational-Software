package com.atl.edusoftware.web.controller

import com.atl.edusoftware.business.Implementation.UserServiceImpl
import com.atl.edusoftware.business.services.ChapterService
import com.atl.edusoftware.business.services.LogsService
import com.atl.edusoftware.business.services.QuizService
import com.atl.edusoftware.data.model.Chapter
import com.atl.edusoftware.data.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

import java.security.Principal

@Controller
class DashboardController {
    @Autowired
    private QuizService quizService

    @Autowired
    private UserServiceImpl userService

    @Autowired
    LogsService logsService

    @Autowired
    QuizService quizService

    @Autowired
    ChapterService chapterService

    @GetMapping(value = "/dashboard")
    String getDashboardView(Model model) {
        model.addAttribute('chapters', chapterService.getAllChapterData())
        return "dashboard"
    }

    @GetMapping(value = "/stats")
    ModelAndView getMyStatsView(Principal principal) {
        ModelAndView modelAndView = new ModelAndView()

        User user = userService.findUserByEmail(principal.name)
        modelAndView.setViewName("stats")
        modelAndView.addObject('statResults', logsService.getLogsByUserId(user.id))
    }

    @GetMapping(value = "/theory", params = ["chapterId"])
    ModelAndView getTheoryView(@RequestParam("chapterId") int chapterId, Principal principal) {
        ModelAndView modelAndView = new ModelAndView()

        Chapter chapter = chapterService.getChapterById(chapterId)
        User user = userService.findUserByEmail(principal.name)
        modelAndView.addObject('log', logsService.getLogByUserIdAndChapterId(user.id, chapterId))
        modelAndView.addObject('chapter', chapter)
        modelAndView.setViewName("theory")
        return modelAndView
    }
}
