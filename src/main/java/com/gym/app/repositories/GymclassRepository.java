package com.gym.app.repositories;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gym.app.entities.Gymclass;

@Repository
public interface GymclassRepository extends MongoRepository<Gymclass, String>
{
	Optional<Gymclass> findById(String id);
}
