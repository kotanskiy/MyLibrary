package library.rest.controller;

import library.rest.model.services.LibraryService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public String getAllBooks() throws IOException {
        return objectMapper.writeValueAsString(libraryService.getAllBooks());
    }

}
