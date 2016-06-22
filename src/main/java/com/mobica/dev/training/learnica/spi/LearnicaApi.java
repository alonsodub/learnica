package com.mobica.dev.training.learnica.spi;

import static com.google.devrel.training.conference.service.OfyService.factory;
import static com.google.devrel.training.conference.service.OfyService.ofy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.ForbiddenException;
import com.google.api.server.spi.response.NotFoundException;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.users.User;
// CONSTANTS
import com.mobica.dev.training.learnica.Constants;
// CLASSES
import com.mobica.dev.training.learnica.domain.Profile;
import com.mobica.dev.training.learnica.domain.Skill;
import com.mobica.dev.training.learnica.domain.Tech;
// FORMS
import com.mobica.dev.training.learnica.form.ProfileForm;
import com.mobica.dev.training.learnica.form.SkillForm;
import com.mobica.dev.training.learnica.form.TechForm;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Work;
import com.googlecode.objectify.cmd.Query;



/**
 * Defines conference APIs.
 */
@Api(name = "learnica", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = {
        Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID },
        description = "API for the Lernica Backend application.")
public class LearnicaApi {

    /*
     * Get the display name from the user's email. For example, if the email is
     * lemoncake@example.com, then the display name becomes "lemoncake."
     */
    private static final Boolean True = null;
    private static final Boolean False = null;

    private static String extractDefaultDisplayNameFromEmail(String email) {
        return email == null ? null : email.substring(0, email.indexOf("@"));
    }

    /**
     * Creates or updates a Profile object associated with the given user
     * object.
     *
     * @param user
     *            A User object injected by the cloud endpoints.
     * @param profileForm
     *            A ProfileForm object sent from the client form.
     * @return Profile object just created.
     * @throws UnauthorizedException
     *             when the User object is null.
     */

    // Declare this method as a method available externally through Endpoints
    @ApiMethod(name = "saveProfile", path = "profile", httpMethod = HttpMethod.POST)
    // The request that invokes this method should provide data that
    // conforms to the fields defined in ProfileForm
    // TODO 1 Pass the ProfileForm parameter
    // TODO 2 Pass the User parameter
    public Profile saveProfile(final User user, ProfileForm newProfileForm)
            throws UnauthorizedException {

        // TODO 2
        // If the user is not logged in, throw an UnauthorizedException
        if (user == null) {
            throw new UnauthorizedException("Authorization required");
        }

        // TODO 2
        // Get the userId and mainEmail
        String mainEmail = user.getEmail();
        String userId = user.getUserId();
        ProfileForm profileForm = new ProfileForm("Doge","Software Eng","123456789","doge@gmail.com", "doge.mobica", "gdl");

        String displayName = profileForm.getDisplayName();
        String position = profileForm.getPosition();
        String phone = profileForm.getPhone();
        String skype = profileForm.getSkype;
        String location = profileForm.getLocation();



        // Get the Profile from the datastore if it exists
        // otherwise create a new one
        //Profile profile = ofy().load().key(Key.create(Profile.class, userId))
        //        .now();
        /*
        if (profile == null) {
            // Populate the displayName and teeShirtSize with default values
            // if not sent in the request
            if (displayName == null) {
                displayName = extractDefaultDisplayNameFromEmail(user
                        .getEmail());
            }
            if (teeShirtSize == null) {
                teeShirtSize = TeeShirtSize.NOT_SPECIFIED;
            }
            // Now create a new Profile entity
            profile = new Profile(userId, displayName, mainEmail, teeShirtSize);
        } else {
            // The Profile entity already exists
            // Update the Profile entity
            profile.update(displayName, teeShirtSize);
        }
        */

        // TODO 3
        // Save the entity in the datastore
        Profile profile = new Profile(userId, displayName, mainEmail);

        //ofy().save().entity(profile).now();

        // Return the profile
        return profile;
    }

    /**
     * Returns a Profile object associated with the given user object. The cloud
     * endpoints system automatically inject the User object.
     *
     * @param user
     *            A User object injected by the cloud endpoints.
     * @return Profile object.
     * @throws UnauthorizedException
     *             when the User object is null.
     */
    @ApiMethod(name = "getProfile", path = "profile", httpMethod = HttpMethod.GET)
    public Profile getProfile(final User user) throws UnauthorizedException {
        if (user == null) {
            throw new UnauthorizedException("Authorization required");
        }

        // TODO
        // load the Profile Entity
        String userId = user.getUserId();
        //Key key = Key.create(Profile.class, userId);

        //Profile profile = (Profile) ofy().load().key(key).now();

        // TODO 3
        // Save the entity in the datastore
        Profile profile = new Profile("123456", "Doge", "mainEmail");
        return profile;
    }

    /**
     * Gets the Profile entity for the current user
     * or creates it if it doesn't exist
     * @param user
     * @return user's Profile
     */
    private static Profile getProfileFromUser(User user) {
        // First fetch the user's Profile from the datastore.
        Profile profile = ofy().load().key(
                Key.create(Profile.class, user.getUserId())).now();
        if (profile == null) {
            // Create a new Profile if it doesn't exist.
            // Use default displayName and teeShirtSize
            String email = user.getEmail();
            profile = new Profile(user.getUserId(),
                    extractDefaultDisplayNameFromEmail(email), email, TeeShirtSize.NOT_SPECIFIED);
        }
        return profile;
    }

    @ApiMethod(name="getSkills",path = "skills", httpMethod = HttpMethod.POST)
    public List<Skill> getSkills(final User user)throws UnauthorizedException {
      if (user == null)
        throw new UnauthorizedException("Authorization required");
      Skill s1 = new Skill("Linux","1","10");
      Skill s2 = new Skill("Eclipse","1","10");
      Skill s3 = new Skill("Windows","1","10");
      Skill s4 = new Skill("Android Studio","1","10");
      Skill s5 = new Skill("Git","1","10");
      List<Skill> skills = new List<Skill>();
      skills.add(s1);skills.add(s2);skills.add(s3);skills.add(s4);skills.add(s5);
      return skills;
    }
    @ApiMethod(name="addSkill",path = "skills", httpMethod = HttpMethod.POST)
    public Boolean addSkill(final User user, SkillForm skillForm)throws UnauthorizedException {
      if (user == null)
        throw new UnauthorizedException("Authorization required");
      String name = skillForm.getName();
      String id = skillForm.getId();
      String value = skillForm.getValue();
      Skill s = new Skill(name,id,value);
      if (s != null)
        return true;
      return false;
    }
    @ApiMethod(name="getTechs",path = "techs", httpMethod = HttpMethod.POST)
    public List<Tech> getTechs(final User user)throws UnauthorizedException {
      if (user == null)
        throw new UnauthorizedException("Authorization required");
      Tech t1 = new Tech("java","1","10");
      Tech t2 = new Tech("python","1","10");
      Tech t3 = new Tech("c","1","10");
      Tech s4 = new Tech("c++","1","10");
      Tech s5 = new Tech(".net","1","10");
      List<Tech> techs = new List<Tech>();
      techs.add(t1);techs.add(t2);techs.add(t3);techs.add(t4);techs.add(t5);
      return techs;
    }
    @ApiMethod(name="addTech",path = "techs", httpMethod = HttpMethod.POST)
    public Boolean addTech(final User user, TechForm techForm)throws UnauthorizedException {
      if (user == null)
        throw new UnauthorizedException("Authorization required");
      String name = techForm.getName();
      String id = techForm.getId();
      String value = techForm.getValue();
      Tech t = new Tech(name,id,value);
      if (t != null)
        return true;
      return false;
    }
}
