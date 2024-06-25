package uz.muhammadtrying.postcrudswaggerside.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.muhammadtrying.postcrudswaggerside.dto.CommentDTO;
import uz.muhammadtrying.postcrudswaggerside.entity.Post;
import uz.muhammadtrying.postcrudswaggerside.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/get/all")
    public List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("/get/{postId}")
    public Post findById(@PathVariable Integer postId) {
        return postService.findById(postId);
    }

    @PostMapping("/add")
    public Integer addPost(@RequestBody Post post) {
        return postService.add(post);
    }

    @PostMapping("/update")
    public Post updatePost(@RequestBody Post post) {
        return postService.update(post);
    }

    @DeleteMapping("/delete/{postId}")
    public Integer deleteById(@PathVariable Integer postId) {
        return postService.deleteById(postId);
    }

    @PostMapping("/add/comment")
    public Integer addComment(@RequestBody CommentDTO commentDTO) {
        return postService.addComment(commentDTO);
    }

    @GetMapping("/get/comments/{postId}")
    public List<CommentDTO> getComments(@PathVariable Integer postId) {
        return postService.findCommentsByPostId(postId);
    }
}
