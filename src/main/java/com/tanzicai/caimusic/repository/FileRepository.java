package com.tanzicai.caimusic.repository;

import com.tanzicai.caimusic.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {
}
