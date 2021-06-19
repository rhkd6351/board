package kgu.limbae.board.repository;

import kgu.limbae.board.domain.PostVO;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    PostVO save(PostVO postVO);
    Optional<PostVO> findById(Long id);
    List<PostVO> findAll();
    boolean update(PostVO vo);
    boolean delete(Long id);
}
