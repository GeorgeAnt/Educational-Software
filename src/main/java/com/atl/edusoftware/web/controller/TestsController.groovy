package com.atl.edusoftware.web.controller

import com.atl.edusoftware.business.services.QuizService
import com.atl.edusoftware.commons.Maps
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpSession

@Controller
@RequestMapping(value = "/tests")
class TestsController {

    @Autowired
    QuizService testsService

    @GetMapping
    String Tests() {
        return "tests"
    }

    @GetMapping(value = "/chapter", params = "chapterId")
    ModelAndView getTestsById(@RequestParam("chapterId") int chapterId, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView()
        modelAndView.setViewName("quiz")
        session.setAttribute('chapterId', chapterId)
        modelAndView.addObject('questions', testsService.getQuizByChapterId(chapterId))
        modelAndView.addObject('chapterName', Maps.CHAPTERS[chapterId])
        return modelAndView
    }

    @GetMapping(value = "/chapter", params = "overall")
    ModelAndView getOverall(@RequestParam("overall") int overall, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView()
        modelAndView.setViewName("quiz")
        session.setAttribute('chapterId', overall)
        modelAndView.addObject('questions', testsService.getQuestionsInRandomOrder())
        modelAndView.addObject('chapterName', Maps.CHAPTERS[overall])
        return modelAndView
    }
}
