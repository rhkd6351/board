package kgu.limbae.board.controller;

import kgu.limbae.board.domain.PostVO;
import kgu.limbae.board.dto.DeletePostDTO;
import kgu.limbae.board.dto.InsertPostDTO;
import kgu.limbae.board.dto.UpdatePostDTO;
import kgu.limbae.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final PostService postService;

    @Autowired
    public BoardController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping(value = "/posts")
    @ResponseBody
    public List<PostVO> getPosts(){
        return postService.findAllPosts();
    }

    @GetMapping(value = "/post")
    @ResponseBody
    public PostVO getPost(@RequestParam(name = "postId") Long postId){
        return postService.findOne(postId).get();
    }

    @PostMapping(value="/post")
    @ResponseBody
    public Long insertPost(@RequestBody InsertPostDTO dto){
        PostVO vo = new PostVO();
        vo.setTitle(dto.getTitle());
        vo.setContent(dto.getContent());

        if(dto.getContent() == null || dto.getContent().equals("") || dto.getTitle().equals("") || dto.getTitle() == null){
            return -1L;
        }

        return postService.join(vo);
    }

    @DeleteMapping(value = "/post")
    @ResponseBody
    public void deletePost(@RequestBody DeletePostDTO dto){
        PostVO vo = new PostVO();
        vo.setPostId(dto.getPostId());
        postService.remove(vo);
    }

    @PutMapping("/post")
    @ResponseBody
    public PostVO updatePost(@RequestBody UpdatePostDTO postDTO){
        PostVO vo = new PostVO();
        vo.setPostId(postDTO.getPostId());
        vo.setTitle(postDTO.getTitle());
        vo.setContent(postDTO.getContent());

        return postService.update(vo);
    }


}
