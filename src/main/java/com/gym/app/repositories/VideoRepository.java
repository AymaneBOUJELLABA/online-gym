package com.gym.app.repositories;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.gym.app.entities.Video;

public interface VideoRepository extends MongoRepository<Video, String>
{
	Optional<Video> findById(String id);
}
