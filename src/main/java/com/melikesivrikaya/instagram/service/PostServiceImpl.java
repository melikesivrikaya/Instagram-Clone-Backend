package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.*;
import com.melikesivrikaya.instagram.repository.CommentRepository;
import com.melikesivrikaya.instagram.repository.LikeRepository;
import com.melikesivrikaya.instagram.repository.PostRepository;
import com.melikesivrikaya.instagram.repository.UserRepository;
import com.melikesivrikaya.instagram.request.CreatePostRequest;
import com.melikesivrikaya.instagram.request.UpdatePostRequest;
import com.melikesivrikaya.instagram.response.FriendResponse;
import com.melikesivrikaya.instagram.response.PostResponse;
import com.melikesivrikaya.instagram.response.PostResponseWithCommentsAndLikes;
import com.melikesivrikaya.instagram.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final FriendService friendService;
    private final CommentRepository commentRepository;
    @Override
    public List<PostResponse> getAll() {
        List<Post> posts =  postRepository.findAll();
        return posts.stream().map(PostResponse::new).collect(Collectors.toList());
    }

    @Override
    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public PostResponse create(CreatePostRequest post) {
        Post newPost = new Post();
        newPost.setPhotourl(post.getPhotourl());
        newPost.setTitle(post.getTitle());
        newPost.setDescription(post.getDescription());
        User user = userRepository.findById(post.getUserId()).get();
        newPost.setUser(user);
        try {
            postRepository.save(newPost);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new PostResponse(newPost);
    }

    @Override
    public PostResponse update(UpdatePostRequest post) {
        Post currentPost = postRepository.findById(post.getId()).get();
        if(post.getTitle() != null){
            currentPost.setTitle(post.getTitle());
        }
        if (post.getDescription() != null){
            currentPost.setDescription(post.getDescription());
        }
        if(post.getPhotourl() != null){
            currentPost.setPhotourl(post.getPhotourl());
        }
        try {
            postRepository.save(currentPost);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new PostResponse(currentPost);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            postRepository.deleteById(id);
            return true;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public List<PostResponseWithCommentsAndLikes> allPostsWithCommentAndLikesByUserId(Long userId) {
        List<Post> postsByUserId = postRepository.findByUserId(userId);
        List<PostResponseWithCommentsAndLikes> list = new ArrayList<>();
        postsByUserId.forEach(post -> {
            List<Like> likes = likeRepository.findByPostId(post.getId());
            List<Comment> comments = commentRepository.findByPostId(post.getId());
            list.add(new PostResponseWithCommentsAndLikes(post, likes ,comments ));
        });
        return  list;
    }

    @Override
    public List<PostResponseWithCommentsAndLikes> getAllPostsWitoutFriend(Long userId){
        List<Post> posts = postRepository.findAll();
        List<FriendResponse> friends = friendService.getAllByUserId(userId);
        List<PostResponseWithCommentsAndLikes> postList = new ArrayList<>();
        posts.forEach(post -> {
            boolean state = friends.stream().anyMatch(friend -> Objects.equals(friend.getFriendId(), post.getUser().getId()));
            if (!state){
                List<Like> likes = likeRepository.findByPostId(post.getId());
                List<Comment> comments = commentRepository.findByPostId(post.getId());
                postList.add(new PostResponseWithCommentsAndLikes(post,likes,comments));
            }
        });
        return postList;
    }
}
