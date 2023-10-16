package com.melikesivrikaya.instagram.service;

import com.melikesivrikaya.instagram.model.Story;
import com.melikesivrikaya.instagram.model.User;
import com.melikesivrikaya.instagram.repository.StoryRepository;
import com.melikesivrikaya.instagram.repository.UserRepository;
import com.melikesivrikaya.instagram.request.CreateStoryRequest;
import com.melikesivrikaya.instagram.request.UpdateStoryRequest;
import com.melikesivrikaya.instagram.response.StoryResponse;
import com.melikesivrikaya.instagram.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService {
    private final StoryRepository storyRepository;
    private final UserRepository userRepository;
    @Override
    public List<Story> getAll() {
        return storyRepository.findAll();
    }

    @Override
    public Optional<Story> getById(Long id) {
        return storyRepository.findById(id);
    }

    @Override
    public StoryResponse create(CreateStoryRequest request) {
        Story story = new Story();
        User user = userRepository.findById(request.getUserId()).get();
        story.setStoryUrl(request.getStoryUrl());
        story.setUser(user);
        storyRepository.save(story);
        return new StoryResponse(story);
    }

    @Override
    public StoryResponse update(UpdateStoryRequest request) {
        Story story = storyRepository.findById(request.getId()).get();
        story.setStoryUrl(request.getStoryUrl());
        return new StoryResponse(storyRepository.save(story));
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            storyRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
