package com.tanzicai.caimusic.repository;

import com.tanzicai.caimusic.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, String>, JpaSpecificationExecutor<Music> {
    Optional<Music> findById(String id);
}
