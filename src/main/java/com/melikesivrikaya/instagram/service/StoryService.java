package com.melikesivrikaya.instagram.service;
import com.melikesivrikaya.instagram.model.Story;
import com.melikesivrikaya.instagram.request.CreateStoryRequest;
import com.melikesivrikaya.instagram.request.UpdateStoryRequest;
import com.melikesivrikaya.instagram.response.StoryResponse;

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
