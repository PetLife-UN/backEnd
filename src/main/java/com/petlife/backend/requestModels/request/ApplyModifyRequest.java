package com.petlife.backend.requestModels.request;

import javax.validation.constraints.NotBlank;

public class ApplyModifyRequest {
    @NotBlank
    private Long id;
    @NotBlank
    private boolean publicationVisible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPublicationVisible() {
        return publicationVisible;
    }

    public void setPublicationVisible(boolean publicationVisible) {
        this.publicationVisible = publicationVisible;
    }
}
