package com.atl.edusoftware.web.controller

import com.atl.edusoftware.business.services.LogsService
import com.atl.edusoftware.business.services.QuizService
import com.atl.edusoftware.business.services.UserService
import com.atl.edusoftware.commons.Result
import com.atl.edusoftware.data.model.Logs
import com.atl.edusoftware.data.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession
import java.security.Principal

@Controller
@RequestMapping(value = "/logs")
class LogsController {

    @Autowired
    LogsService logsService

    @Autowired
    QuizService quizService

    @Autowired
    UserService userService

    @GetMapping(value = "/changeReadStatus")
    ModelAndView setReadStatus(
            @RequestParam("chapterId") int chapterId,
            @RequestParam("isTheoryRead") boolean isTheoryRead, Principal principal) {
        ModelAndView modelAndView = new ModelAndView()
        User user = userService.findUserByEmail(principal.name)
        Logs log = logsService.getLogByUserIdAndChapterId(user.id, chapterId)
        log.isTheoryRead = isTheoryRead ?: false
        logsService.insertOrUpdateOnLogs(log)

        modelAndView.setViewName("dashboard")
        return modelAndView
    }

    @PostMapping(value = "/quizResults")
    ModelAndView getResults(HttpServletRequest request, HttpSession session, Principal principal) {
        ModelAndView modelAndView = new ModelAndView()

        double score = quizService.getResults(request)
        //TODO better practice would be user id to populated in session on login. try https://stackoverflow.com/questions/24882007/populate-user-session-after-login if we got time.
        User user = userService.findUserByEmail(principal.name)
        int chapterId = session?.getAttribute('chapterId') as int
        Logs log = ['chapterId': chapterId, 'testStats': score, 'userId': user.id]
        Result result = logsService.handleResults(log)
        logsService.insertOrUpdateOnLogs(log)

        modelAndView.setViewName("dashboard")
        modelAndView.addObject('score', score.toString())
        modelAndView.addObject('resultMessage', result.message)
        return modelAndView
    }

}
