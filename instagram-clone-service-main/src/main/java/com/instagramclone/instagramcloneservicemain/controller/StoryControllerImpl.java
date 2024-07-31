package com.instagramclone.instagramcloneservicemain.controller;

import com.instagramclone.instagramcloneservicemain.dto.request.CreateStoryRequest;
import com.instagramclone.instagramcloneservicemain.dto.request.UpdateStoryRequest;
import com.instagramclone.instagramcloneservicemain.dto.response.StoryResponse;
import com.instagramclone.instagramcloneservicemain.model.Story;
import com.instagramclone.instagramcloneservicemain.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/story")
public class StoryControllerImpl implements StoryController {
    private final StoryService storyService;
    @GetMapping
    @Override
    public List<StoryResponse> getAll() {
        return storyService.getAll().stream().map(StoryResponse::new).toList();
    }
    @GetMapping("{id}")
    @Override
    public Story getById(@PathVariable Long id) {
        return storyService.getById(id).get();
    }
    @PostMapping
    @Override
    public StoryResponse create(@RequestBody CreateStoryRequest request) {
        return storyService.create(request);
    }
    @PutMapping
    @Override
    public StoryResponse update(@RequestBody UpdateStoryRequest request) {
        return storyService.update(request);
    }
    @DeleteMapping("{id}")
    @Override
    public boolean deleteById(@PathVariable Long id) {
        return storyService.deleteById(id);
    }
    @GetMapping("userId/{id}")
    @Override
    public List<StoryResponse>  getAllByUserId(@PathVariable Long id) {
        return storyService.getAllByUserId(id);
    }
}
