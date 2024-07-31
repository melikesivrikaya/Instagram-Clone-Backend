package com.instagramclone.postservicemain.dto.resquest;

import lombok.Data;

@Data
public class UpdatePostRequest {
    private Long id;
    private String title,description,photourl;
}
