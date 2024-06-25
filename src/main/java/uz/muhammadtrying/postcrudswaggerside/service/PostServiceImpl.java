package uz.muhammadtrying.postcrudswaggerside.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.muhammadtrying.postcrudswaggerside.dto.CommentDTO;
import uz.muhammadtrying.postcrudswaggerside.entity.Post;
import uz.muhammadtrying.postcrudswaggerside.repo.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final RestTemplate restTemplate;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Integer postId) {
        return postRepository.findById(postId).get();
    }

    @Override
    public Integer add(Post post) {
        return postRepository.save(post).getId();
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Integer deleteById(Integer postId) {
        postRepository.deleteById(postId);
        return postId;
    }

    @Override
    public Integer addComment(CommentDTO commentDTO) {
        HttpEntity<CommentDTO> request = new HttpEntity<>(commentDTO);
        ResponseEntity<Integer> response = restTemplate.exchange(
                "http://localhost:8080/api/comment/add",
                HttpMethod.POST,
                request,
                Integer.class
        );

        return response.getBody();
    }

    @Override
    public List<CommentDTO> findCommentsByPostId(Integer postId) {
        ResponseEntity<List<CommentDTO>> response = restTemplate.exchange(
                "http://localhost:8080/api/comment/get/by/post/id/" + postId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }
}
