package com.tech.spcours.pos.service;

import com.tech.spcours.pos.dto.ProfileDto;
import com.tech.spcours.pos.entity.ProfileEntity;
import com.tech.spcours.pos.repostary.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileDto registerProfile(ProfileDto profileDto){
        ProfileEntity newProfile = toEntity(profileDto);//Convert DTO → Entity
        newProfile.setActivationToken(UUID.randomUUID().toString());// used generating activation token for email,password reset
        newProfile = profileRepository.save(newProfile);//save todatabase
        return toDTO(newProfile) ;
    }

    public ProfileEntity toEntity(ProfileDto profileDto) {// used for converting dto to entity
        return  ProfileEntity.builder()
                .id(profileDto.getId())
                .fullName(profileDto.getFullName())
                .email(profileDto.getEmail())
                .profileImage(profileDto.getProfileImage())
                .createdDate(profileDto.getCreatedDate())
                .updatedAt(profileDto.getUpdatedAt())
                .build();
    }


    public ProfileDto toDTO(ProfileEntity profileEntity) {
        return ProfileDto.builder()
                .id(profileEntity.getId())
                .fullName(profileEntity.getFullName())
                .email(profileEntity.getEmail())
                .profileImage(profileEntity.getProfileImage())
                .createdDate(profileEntity.getCreatedDate())
                .updatedAt(profileEntity.getUpdatedAt())
                .build();
    }

}
