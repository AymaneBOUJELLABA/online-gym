package com.gym.app.seeders;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gym.app.entities.Admin;
import com.gym.app.entities.Gymclass;
import com.gym.app.entities.Role;
import com.gym.app.entities.Trainer;
import com.gym.app.entities.User;
import com.gym.app.entities.Video;
import com.gym.app.repositories.AdminRepository;
import com.gym.app.repositories.GymclassRepository;
import com.gym.app.repositories.RoleRepository;
import com.gym.app.repositories.TrainerRepository;
import com.gym.app.repositories.UserRepository;
import com.gym.app.repositories.VideoRepository;

@Component
public class DbSeeder implements CommandLineRunner
{
	@Autowired
	private GymclassRepository gymrepo;
	@Autowired
	private VideoRepository vidrepo;
	@Autowired
	private RoleRepository rolerepo;
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private AdminRepository adminrepo;
	@Autowired
	private TrainerRepository trainerrepo;
	
	
	@Override
	public void run(String... args) throws Exception
	{
		//delete all
		gymrepo.deleteAll();
		rolerepo.deleteAll();
		userrepo.deleteAll();
		trainerrepo.deleteAll();
		adminrepo.deleteAll();
		

		//create roles
		Role role1 = new Role("client",new ArrayList<String>());
		Role role2 = new Role("trainer",new ArrayList<String>());
		Role role3 = new Role("admin",new ArrayList<String>());
		rolerepo.insert(Arrays.asList(role1,role2,role3));
		
		//create a user
		User user = new User("user1","email.com","12/11/1999","KB162627","fakepassword",role1.getName(),new ArrayList<String>());
		userrepo.insert(user);
		
		//create a trainer 
		Trainer trainer = new Trainer("user2","email2.com","12/12/1999","KB162227","fakepassword2",role2.getName(),new ArrayList<String>(),"Legs training");
		trainerrepo.insert(trainer);
		
		//create an admin
		Admin admin = new Admin("user3","email3.com","13/12/1999","KB162223","fakepassword3",role3.getName(),new ArrayList<String>());
		adminrepo.insert(admin);
		
		//add users to roles 
		role1.setUsers(Arrays.asList(user.getId()));
		role2.setUsers(Arrays.asList(trainer.getId()));
		role3.setUsers(Arrays.asList(admin.getId()));
		
		rolerepo.saveAll(Arrays.asList(role1,role2,role3));
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
		
		//add gym to user and trainer
		user.setGymclasses(Arrays.asList(gym1.getId()));
		trainer.setGymclasses(Arrays.asList(gym1.getId()));
		
		//save changes 
		userrepo.save(user);
		trainerrepo.save(trainer);
		
		
		System.out.println("gym updated");
	}
	

}
