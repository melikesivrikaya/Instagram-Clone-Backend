package com.instagramclone.instagramcloneservicemain.response;

import com.instagramclone.instagramcloneservicemain.model.Story;
import lombok.Data;

@Data
public class StoryResponse {
    private Long id,userId;
    private String storyUrl;

    public StoryResponse(Story story){
        this.id = story.getId();
        this.userId = story.getUser().getId();
        this.storyUrl = story.getStoryUrl();
    }
}
