package com.atl.edusoftware.web.controller

import com.atl.edusoftware.business.services.EditService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping(value = '/edit')
class EditController {

    @Autowired
    EditService editService

    @GetMapping(value = '/tests')
    String getEditTest() {
        return 'editTest'
    }

    @GetMapping(value = '/theory')
    String getEditTheory() {
        return 'editTheory'
    }

    @PostMapping(value = '/tests')
    String addTest(HttpServletRequest request) {
        editService.addTest(request)

        return 'dashboard'
    }

    @PostMapping(value = '/theory')
    String addTheory() {
        return 'dashboard'
    }

}
