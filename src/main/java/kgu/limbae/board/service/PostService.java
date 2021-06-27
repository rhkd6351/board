package kgu.limbae.board.service;

import kgu.limbae.board.domain.PostVO;
import kgu.limbae.board.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class PostService{

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Long join(PostVO postVO){
        postRepository.save(postVO);
        return postVO.getPostId();
    }

    public Optional<PostVO> findOne(Long id){
        return postRepository.findById(id);
    }

    public List<PostVO> findAllPosts(){
        return postRepository.findAll();
    }

    public void remove(PostVO vo){
        postRepository.delete(vo);
    }

    public PostVO update(PostVO vo){
        PostVO pvo = postRepository.getById(vo.getPostId());
        pvo.setTitle(vo.getTitle());
        pvo.setContent(vo.getContent());
        return postRepository.save(pvo);
    }
}