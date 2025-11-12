package com.texstre.celebclothing.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="boutique_followers")
public class BotiqFollowers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "botiq_follower_id")
    private Long botiqFollowId;
    @Column(name = "botiq_id")
    private String botiqId;
    @Column(name = "follower_user_id")
    private String followUserId;
    @NotNull
    @Column(name = "is_following", nullable=false)
    @ColumnDefault("0")
    private boolean isFollowing;
}

