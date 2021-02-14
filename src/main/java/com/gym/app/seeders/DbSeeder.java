package com.gym.app.seeders;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gym.app.entities.Gymclass;
import com.gym.app.entities.Video;
import com.gym.app.repositories.GymclassRepository;
import com.gym.app.repositories.VideoRepository;


public class DbSeeder implements CommandLineRunner
{
	@Autowired
	private GymclassRepository gymrepo;
	@Autowired
	private VideoRepository vidrepo;
	
	@Override
	public void run(String... args) throws Exception
	{
		//delete all
		//gymrepo.deleteAll();

		//create a gym
		Gymclass gym1 = new Gymclass("yoga", "a fake id",new ArrayList<String>());
		//insert the gym
		gym1 = gymrepo.insert(gym1);
		System.out.println("gym inserted : " + gym1);
		
		//add 2 videos
		Video vid1 = new Video("a cool video", "url1",gym1.getId());
		Video vid2 = new Video("a great video", "url2", gym1.getId());
		
		//save the vids
		vidrepo.saveAll(Arrays.asList(vid1,vid2));
		System.out.println("vids created");
		//add the vids to the gym
		gym1.setVideos(Arrays.asList(vid1.getId(),vid2.getId()));
		
		//save the changes
		gymrepo.save(gym1);
		
		System.out.println("gym updated");
	}
	

}
