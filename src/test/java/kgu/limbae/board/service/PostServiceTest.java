//package kgu.limbae.board.service;
//
//import kgu.limbae.board.domain.PostVO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@Transactional
//@SpringBootTest
//public class PostServiceTest {
//
//    @Autowired
//    PostService postService;
//
//    @Test
//    public void findOneTest() {
//        //given
//        Long id = 42L;
//        Optional<PostVO> post;
//
//        //when
//        post = postService.findOne(id);
//
//        //then
//        assertThat(post).isNotEmpty();
//    }
//
//}
