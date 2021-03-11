package org.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rest.messenger.database.DatabaseClass;
import org.rest.messenger.model.Profile;


public class ProfileService {

    private Map<String,Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService(){
        profiles.put("Pavan", new Profile(1, "Pavan", "Pavan", "Tiruvuri") );
        profiles.put("Kiran", new Profile(2, "Kiran", "Kiran", "Tiruvuri") );
    }

    public List<Profile> getAllProfiles(){
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String name){
        //if(profiles.containsKey(name))
            return profiles.get(name);
    }

    public Profile addProfile(Profile profile){
        profile.setId(profiles.size()+1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile){
        if(profile.getProfileName().isEmpty()){
            return null;
        }
        profiles.put(profile.getProfileName(),profile);
        return profile;

    }

    public Profile deleteProfile(String profileName){
        return profiles.remove(profileName);
    }
    
}
