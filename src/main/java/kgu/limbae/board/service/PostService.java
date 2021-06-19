package kgu.limbae.board.service;

import kgu.limbae.board.domain.PostVO;
import kgu.limbae.board.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
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

    public boolean remove(Long id){
        return postRepository.delete(id);
    }

    public boolean update(PostVO vo){
        return postRepository.update(vo);
    }
}