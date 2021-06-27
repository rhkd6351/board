package kgu.limbae.board;

import kgu.limbae.board.repository.PostRepository;
import kgu.limbae.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final EntityManagerFactory emf;


    public SpringConfig(EntityManagerFactory emf) {
        this.emf = emf;
    }

//    @Bean
//    public PostService postService() {
//        return new PostService(postRepository());
//    }


//    @Bean
//    public PostRepository postRepository() {
//        return new PostRepository(emf.createEntityManager());
//    }
}
