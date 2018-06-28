package com.atl.edusoftware.web.controller

import com.atl.edusoftware.business.Implementation.UserServiceImpl
import com.atl.edusoftware.business.services.ChapterService
import com.atl.edusoftware.business.services.LogsService
import com.atl.edusoftware.business.services.TestsService
import com.atl.edusoftware.data.model.Chapter
import com.atl.edusoftware.data.model.Logs
import com.atl.edusoftware.data.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

@Controller
class DashboardController {
    @Autowired
    private TestsService quizService

    @Autowired
    private UserServiceImpl userService

    @Autowired
    LogsService logsService

    @Autowired
    TestsService testsService

    @Autowired
    ChapterService chapterService

    @GetMapping(value = "/dashboard")
    String getDashboardView(HttpSession session, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication()
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()
            User user = userService.findUserByEmail(userDetails.username)
            session.setAttribute('userId', user.id)
            model.addAttribute('role', userDetails.authorities[0])
        }
        return "dashboard"
    }

    @PostMapping(value = "/dashboard")
    ModelAndView getResults(HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView()

        double result = testsService.getResults(request)
        int chapterId = session.getAttribute('chapterId') as int
        long userId = session.getAttribute('userId') as long
        String resultMessage = logsService.compareResults(chapterId, result)
        Logs log = ['chapterId': chapterId, 'studentStats': result, 'userId': userId]

        logsService.insertOrUpdateOnLogs(log)

        modelAndView.setViewName("dashboard")
        modelAndView.addObject('result', result.toString())
        modelAndView.addObject('resultMessage', resultMessage)
        return modelAndView
    }

    @GetMapping(value = "/stats")
    ModelAndView getMyStatsView(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView()

        long userId = session.getAttribute('userId') as long

        modelAndView.setViewName("stats")
        modelAndView.addObject('statResults', logsService.getLogsByUserId(userId))
    }

    @GetMapping(value = "/theory")
    ModelAndView getTheoryView() {
        ModelAndView modelAndView = new ModelAndView()

        Iterable<Chapter> chapterIterable = chapterService.getAllChapterData()
        modelAndView.addObject('chapters', chapterIterable)
        modelAndView.setViewName("theory")
        return modelAndView
    }

    @GetMapping(value = "/edit")
    String getEditView() {

        return 'edit'
    }
}
