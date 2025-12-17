package com.tech.spcours.pos.repostary;

import com.tech.spcours.pos.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository {

    // select * from tbl_profiles where email
    Optional<ProfileEntity> findByEmail(String email);

}
