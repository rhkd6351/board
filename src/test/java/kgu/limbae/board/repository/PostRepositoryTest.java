package kgu.limbae.board.repository;

import kgu.limbae.board.domain.PostVO;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class PostRepositoryTest {

    @Autowired
    public PostRepository postRepository;

    @Commit
    @Test
    void save() {
        //given

        PostVO postVO = new PostVO();
        postVO.setTitle("test title123");
        postVO.setContent("test content123");
        //when

        PostVO result = postRepository.save(postVO);
        //then
        assertThat(postVO).isEqualTo(result);

    }


    @Test
    public void find() {
        //given
        Long id = 3L;

        //when
        assertThat(postRepository.findById(id)).isNotEmpty();
    }

    @Test
    public void postUpdate(){
        //given
        final Long id = 3L;

        PostVO newVO = new PostVO();
        newVO.setPostId(id);
        newVO.setTitle("changed title");
        newVO.setContent("changed content");

        //when
        boolean isSuccess = postRepository.update(newVO);

        //then
        assertThat(isSuccess).isEqualTo(true);
    }

}
