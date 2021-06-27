package kgu.limbae.board.repository;

import kgu.limbae.board.domain.PostVO;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public class JpaPostRepository implements PostRepository{

    private final EntityManager em;

    public JpaPostRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public PostVO save(PostVO postVO) {
        try{
            em.getTransaction().begin();
            em.persist(postVO);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }

        return postVO;
    }

    @Override
    public Optional<PostVO> findById(Long id) {
        PostVO postVO = em.find(PostVO.class, id);
        return Optional.ofNullable(postVO);
    }

    @Override
    public List<PostVO> findAll() {

        List<PostVO> list = em.createQuery("select p from posts p", PostVO.class).getResultList();

        return list;
    }

    @Override
    public boolean update(PostVO vo) {
        try{
            em.getTransaction().begin();
            PostVO postVO = em.find(PostVO.class, vo.getPostId());
            postVO.setTitle(vo.getTitle());
            postVO.setContent(vo.getContent());
            em.getTransaction().commit();

            return true;
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        Optional<PostVO> post = this.findById(id);
        if(post.isPresent()){
            try{
                em.getTransaction().begin();
                em.remove(post.get());
                em.getTransaction().commit();
                return true;
            }catch (Exception e){
                e.printStackTrace();
                em.getTransaction().rollback();
                return false;
            }
        }else{
            return false;
        }
    }
}
