package kgu.limbae.board.controller;

import kgu.limbae.board.domain.PostVO;
import kgu.limbae.board.dto.InsertPostDTO;
import kgu.limbae.board.dto.UpdatePostDTO;
import kgu.limbae.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }


}
