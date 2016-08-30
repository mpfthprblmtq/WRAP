/**
 * File: HelpController.java
 * Desc: Basically just serves as the holding area for text to show up in
 *          the text are in the Help GUI
 *
 * Author: Pat Ripley
 */

package webradio;

public class HelpController {

    /**
     * Returns the string for generic Profiles
     *
     * @return the specified help message
     */
    public static String getProfiles() {
        return "Profiles\n\n"
                + "This feature allows the adding, editing, and deleting of "
                + "profiles, which are basically DJ's, members, prospective "
                + "members, and advisors.  Each profile's ID (800 number) makes "
                + "them unique.\n"
                + "These Profiles are also used in Tasks, to keep track of the "
                + "things DJ's must do to join and remain in the club, as well "
                + "as in Shows, to give hosts to different shows.";
    }

    /**
     * Returns the string for adding profiles
     *
     * @return the specified help message
     */
    public static String getAddProfile() {
        return "Adding a Profile\n\n"
                + "To add a profile, go to Profiles from the main window, then "
                + "go the Add panel.  There you can input "
                + "all of the profile's information\n\n"
                + "After you get done inputting all the data, you can either "
                + "press enter or click on the Add button at the bottom right.\n\n"
                + "Make sure that your fields are valid fields, otherwise WRAP "
                + "will yell at you and a bunch of red text will appear, which "
                + "isn't really fun.\n\n"
                + "The result of the addition will be at the bottom of the window.";
    }

    /**
     * Returns the string for editing profiles
     *
     * @return the specified help message
     */
    public static String getEditProfile() {
        return "Editing a Profile\n\n"
                + "To edit a profile, go to Profiles from the main window, then "
                + "click on a profile from the list on "
                + "the right.\n\n"
                + "When you can see the information for the desired "
                + "profile, you can click on the Edit button.  This makes the "
                + "information editable.\n\n"
                + "Once you're done with editing the fields you want, click "
                + "submit.  The profile will be updated with the new information "
                + "and the result of the editing will be at the bottom of the window.";
    }

    /**
     * Returns the string for deleting profiles
     *
     * @return the specified help message
     */
    public static String getDeleteProfile() {
        return "Deleting a Profile\n\n"
                + "To delete a profile, go to Profiles from the main window, then "
                + "click on the profile from the list on the right.\n\n"
                + "If this is the profile you wish to delete, you can click the "
                + "the delete button.  A window will pop up and ask if you are "
                + "sure about deleting the profile.  If you are, click Yes.\n\n"
                + "If the profile is the host of a show, you will get another window "
                + "asking if you would like to delete that show, or replace the "
                + "profile with a blank object.  Select your option.\n\n"
                + "The result of the deletion will be at the bottom of the window.";
    }

    /**
     * Returns the string for generic accounts
     *
     * @return the specified help message
     */
    public static String getAccounts() {
        return "Accounts\n\n"
                + "This allows the creation of users of the program.  There are "
                + "different levels of access, and each has its own perks.\n"
                + "   0 (Admin) : Unlimited usability\n"
                + "   1 (Mod) : Some features restricted\n"
                + "   2 (User) : Can only view\n\n"
                + "Users' passwords are hashed and salted for security.  When "
                + "editing accounts, you can only edit your own account's "
                + "information.  The only exception is if you're an admin and "
                + "you are chaning the access level of another user.";
    }

    /**
     * Returns the string for adding accounts
     *
     * @return the specified help message
     */
    public static String getAddAccount() {
        return "Adding an Account\n\n"
                + "To add an Account, go to Accounts from the main window, then "
                + "go to the Add tab.  There you can input the username, password, "
                + "access level and name.\n\n"
                + "When you are finished inputting the account data, click on the "
                + "add button to submit it.  Result of the addition will be at "
                + "the bottom of the window";
    }

    /**
     * Returns the string for editing accounts
     *
     * @return the specified help message
     */
    public static String getEditAccount() {
        return "Editing an Account\n\n"
                + "To edit an account, click on the account you would like to "
                + "edit in the list to the right.  Once you select the account, "
                + "click on Edit, which makes the fields editable.  Input the "
                + "information for the edited account.\n\n"
                + "When you are finished, click submit.  The result of the edit "
                + "will be at the bottom of the window.";
    }

    /**
     * Returns the string for deleting accounts
     *
     * @return the specified help message
     */
    public static String getDeleteAccount() {
        return "Deleting an Account\n\n"
                + "To delete an account, click on the account you would like to "
                + "delete in the list to the right.  Once you select the account, "
                + "click delete.  A confirmation will pop up asking if you are "
                + "sure you want to delete that account.  Click yes to delete.\n\n"
                + "The result of the deletion will be at the bottom of the window.";
    }
    
    /**
     * Returns the string for generic tasks
     *
     * @return the specified help message
     */
    public static String getTasks() {
        return "Tasks\n\n"
                + "This feature allows for the checking of each profile's tasks, "
                + "which are basically things that club members must do to either "
                + "join or remain in the club.\n\n"
                + "This includes paying dues, being trained on the board, "
                + "turning the proper paperwork in, and turning in a show "
                + "description and time.\n\n"
                + "It also can check if the profile is \"good\" or \"bad,\" "
                + "based on the profile's standing on the four tasks.";
    }
    
    /**
     * Returns the string for editing a profile's tasks
     *
     * @return the specified help message
     */
    public static String getEditTasks() {
        return "Editing a Profile's Task\n\n"
                + "To Edit a profile's tasks, go to Tasks from the main window, "
                + "then click on the profile you want from the list on the right.\n\n"
                + "Once selected, click edit, making the four check boxes editable. "
                + "Check the tasks that the profile completed, then click submit "
                + "to update the selected profile.  Once you click submit, it "
                + "will update with the profile's standing.";
    }
    
    /**
     * Returns the string for generic Shows
     *
     * @return the specified help message
     */
    public static String getShows() {
        return "Shows\n\n"
                + "This feature allows the addition, editing, and deletion of shows, "
                + "one of the pinnacles of Web Radio.  You can add the show name, "
                + "description, days and times of the show, and the hosts.";
    }
    
    /**
     * Returns the string for adding shows
     *
     * @return the specified help message
     */
    public static String getAddShow() {
        return "Adding a Show\n\n"
                + "To add a show, go to the Shows window from the main window, then "
                + "go to the add panel.  There you can enter the show name, description, "
                + "days and times of the show, and the host(s).\n\n"
                + "Once the information is entered, click the add button.  The "
                + "result of the addition will be at the bottom of the window.";
    }

    /**
     * Returns the string for editing shows
     *
     * @return the specified help message
     */
    public static String getEditShow() {
        return "Editing a Show\n\n"
                + "To edit a show, click on the show you would like to edit from "
                + "the list on the right.  Once selected, click the Edit button.  "
                + "There you can edit the information you would like.\n\n"
                + "When you're done editing, click submit.  The result of the "
                + "edit will be at the bottom of the window.";
    }

    /**
     * Returns the string for deleting shows
     *
     * @return the specified help message
     */
    public static String getDeleteShow() {
        return "Deleting a Show\n\n"
                + "To delete a show, click on the show you would like to "
                + "delete in the list to the right.  Once you select the show, "
                + "click delete.  A confirmation will pop up asking if you are "
                + "sure you want to delete that show.  Click yes to delete.\n\n"
                + "The result of the deletion will be at the bottom of the window.";
    }
    
    /**
     * Returns the string for generic finances
     *
     * @return the specified help message
     */
    public static String getFinances() {
        return "Finances\n\n"
                + "This feature allows for the tracking of the club's funds, "
                + "adding, editing, and deleting transactions that the club "
                + "makes, along with some minor additional features, like a money "
                + "counter, and a calculator.";
    }
    
    /**
     * Returns the string for using the money counter
     *
     * @return the specified help message
     */
    public static String getMoneyCounter() {
        return "Using the Money Counter\n\n"
                + "To use the Money Counter, simply put in what value of each "
                + "denomination you have in the necessary slots.  As you are "
                + "inputting the values, a running total will be calculated as "
                + "you go.";
    }
    
    /**
     * Returns the string for generic reports
     *
     * @return the specified help message
     */
    public static String getReports() {
        return "Reports\n\n"
                + "This feature allows for the printing of different reports, such "
                + "as Profiles (full, simple, contact info), Shows (simple, full), "
                + "and much more.\n\n"
                + "The reports are outputted to text files, but "
                + "later builds will be to make them output to Microsoft Excel "
                + "files as well.";
    }
    
    /**
     * Returns the string for generating reports
     *
     * @return the specified help message
     */
    public static String getGeneratingReports() {
        return "Generating reports\n\n"
                + "To generate reports, start by choosing what type of report you "
                + "would like, be it Profiles, Accounts, etc.\n"
                + "Then choose what type of report to generate, be it simple, full, "
                + "etc.\n"
                + "Then choose how you would like it to be sorted.  This allows "
                + "for like things to be grouped together as well.\n\n"
                + "Once you're ready to generate, click the Generate button in "
                + "the bottom right of the window.  Once the report is generated, "
                + "the result of the generation will be displayed at the bottom "
                + "of the window.";
    }

}
