package uz.muhammadtrying.postcrudswaggerside.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.muhammadtrying.postcrudswaggerside.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}