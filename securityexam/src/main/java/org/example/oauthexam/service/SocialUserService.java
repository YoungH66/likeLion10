package org.example.oauthexam.service;

import lombok.RequiredArgsConstructor;
import org.example.oauthexam.domain.SocialUser;
import org.example.oauthexam.repository.SocialUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocialUserService {
    private final SocialUserRepository socialUserRepository;

    @Transactional
    // 소셜에서 정보를 가져와서 저장하거나, 이미 존재하면 수정한다.
    public SocialUser saveOrUpdate(String socialId, String provider, String username, String email, String avatarUrl) {
        Optional<SocialUser> existingUser = socialUserRepository.findBySocialIdAndProvider(socialId, provider);
        SocialUser socialUser;
        if(existingUser.isPresent()) {
            // 이미 소셜유저 정보를 가진 사용자라면
            socialUser = existingUser.get();
            socialUser.setUsername(username);
            socialUser.setEmail(email);
            socialUser.setAvatarUrl(avatarUrl);
        }else{
            socialUser = new SocialUser();
            socialUser.setUsername(username);
            socialUser.setEmail(email);
            socialUser.setAvatarUrl(avatarUrl);
            socialUser.setSocialId(socialId);
            socialUser.setProvider(provider);
        }

        return socialUserRepository.save(socialUser);
    }
}
