package com.example.demodoan.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_tokens")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token extends Base{
    @Column(name = "username",unique = true,nullable = false)
    private String username;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "refresh_token")
    private String refressToken;

}
