package com.instagramclone.instagramcloneservicemain.service;

import com.instagramclone.instagramcloneservicemain.dto.request.CreateStoryRequest;
import com.instagramclone.instagramcloneservicemain.dto.request.UpdateStoryRequest;
import com.instagramclone.instagramcloneservicemain.dto.response.StoryResponse;
import com.instagramclone.instagramcloneservicemain.model.Story;

import java.util.List;
import java.util.Optional;

public interface StoryService {
    List<Story> getAll();
    Optional<Story> getById(Long id);
    StoryResponse create(CreateStoryRequest request);
    StoryResponse update(UpdateStoryRequest request);
    boolean deleteById( Long id);
    List<StoryResponse>  getAllByUserId(Long id);
}
