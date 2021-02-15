package com.gym.app.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gym.app.entities.Trainer;

@Repository
public interface TrainerRepository extends MongoRepository<Trainer, String>
{
	Optional<Trainer> findById(String id);
}
