package kgu.limbae.board.repository;

import kgu.limbae.board.domain.PostVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PostRepository extends JpaRepository<PostVO, Long> {
//    PostVO save(PostVO postVO);
//    Optional<PostVO> findById(Long id);
//    List<PostVO> findAll();
//    boolean update(PostVO vo);
//    boolean delete(Long id);
}
