package com.instagramclone.instagramcloneservicemain.service;

import com.instagramclone.instagramcloneservicemain.dto.request.CreateStoryRequest;
import com.instagramclone.instagramcloneservicemain.dto.request.UpdateStoryRequest;
import com.instagramclone.instagramcloneservicemain.dto.response.StoryResponse;
import com.instagramclone.instagramcloneservicemain.model.Story;
import com.instagramclone.instagramcloneservicemain.model.User;
import com.instagramclone.instagramcloneservicemain.repository.StoryRepository;
import com.instagramclone.instagramcloneservicemain.repository.UserRepository;
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

    @Override
    public List<StoryResponse> getAllByUserId(Long id) {
        return storyRepository.findAllByUserId(id).stream().map(StoryResponse::new).toList();
    }
}
