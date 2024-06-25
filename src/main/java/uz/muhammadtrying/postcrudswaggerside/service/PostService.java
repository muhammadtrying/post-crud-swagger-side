package uz.muhammadtrying.postcrudswaggerside.service;

import org.springframework.stereotype.Service;
import uz.muhammadtrying.postcrudswaggerside.dto.CommentDTO;
import uz.muhammadtrying.postcrudswaggerside.entity.Post;

import java.util.List;

@Service
public interface PostService {
    List<Post> findAll();

    Post findById(Integer postId);

    Integer add(Post post);

    Post update(Post post);

    Integer deleteById(Integer postId);

    Integer addComment(CommentDTO commentDTO);

    List<CommentDTO> findCommentsByPostId(Integer postId);
}
