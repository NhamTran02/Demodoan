package com.example.demodoan.dto.response;

import com.example.demodoan.dto.request.ForumDTO;
import com.example.demodoan.model.Base;
import com.example.demodoan.model.Forum;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ForumListResponse {
    private List<ForumDTO> forums;
    private int totalPages;
}
