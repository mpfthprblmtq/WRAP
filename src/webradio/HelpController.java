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
     * Returns the string for types of profiles
     *
     * @return the specified help message
     */
    public static String getProfileTypes() {
        return "Profile Types\n\n"
                + "DJ:  A member of the club that is currently hosting a show\n\n"
                + "Member:  Someone in the club that is currently not hosting "
                + "a show, but is still active in the club\n\n"
                + "Prospect:  Someone not in the club yet, needs to go through "
                + "the steps to become a DJ yet\n\n"
                + "Advisor:  A faculty member or professor that generally oversees "
                + "the club and its operations";
    }

    /**
     * Returns the string for fields for the profile gui
     *
     * @return the specified help message
     */
    public static String getFieldsProfiles() {
        return "Profile Fields\n\n"
                + "First Name:  Profile's first name.\n\n"
                + "Last Name:  Profile's last name.\n\n"
                + "800 Number:  Profile's 800 number (usually on the cougar "
                + "card).\n\n"
                + "Phone:  Primary phone, or best way to reach them.\n\n"
                + "SIUe Email:  Email associated with the university (usually "
                + "their eid + @siue.edu).\n\n"
                + "Preferred Email:  Email to best get a hold of them (can be "
                + "their siue email as well, if they prefer).\n\n"
                + "Type:  The type of profile they are.  Can be DJ, Member, "
                + "Prospect or Advisor.\n\n"
                + "Position:  The profile's role in the club.  Can be President, "
                + "Vice President, Secretary, Treasurer, SM Manager, or Technical"
                + " officer.\n\n"
                + "Notes:  Any notes on the profile (i.e. \"needs updated "
                + "email addresses\"";
    }
    
    /**
     * Returns the string for generic accounts
     *
     * @return the specified help message
     */
    public static String getAccounts() {
        return "Accounts\n\n"
                + "This allows the creation of users of the program."  
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
     * Returns the string for account types
     *
     * @return the specified help message
     */
    public static String getAccountType() {
        return "Account Types\n\n"
                + "There are three different levels of access, and each has its own perks.\n\n"
                + "   0 (Admin) : Unlimited usability\n"
                + "   1 (Mod) : Some features restricted\n"
                + "   2 (User) : Can only view\n\n";
    }
    
    public static String getFieldsAccounts() {
        return "Account Fields\n\n"
                + "Username:  Desired username, must be unique.\n\n"
                + "Password:  Desired password.  This is hashed and salted, so "
                + "the password is never written to the disk.\n\n"
                + "Access:  Access level for account, gives account different "
                + "permissions per level.\n\n"
                + "Name:  What the account owner's name is (for the welcome "
                + "message).";
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
     * Returns the string for task descriptions
     * 
     * @return the specified help message 
     */
    public static String getTaskDesctriptions() {
        return "Task Descriptions\n\n"
                + "Dues Paid:  Payment of $6 dues per semester.  Can either be "
                + "paid in person, or online through our website (dues paid online "
                + "are $6.50 to account for greedy little PayPal).\n\n"
                + "Board Trained:  Going through a training on how to use the board "
                + "and it's functions.  Must be with a specified board trainer.\n\n"
                + "Show Description/Time:  Turning in information for a show so "
                + "that we know about it and we can put it on the website.\n\n"
                + "Paperwork turned in:  Turning in an application or applying online "
                + "so we have it on record.";
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
     * Returns the string for Show's fields
     * 
     * @return the specified help message
     */
    public static String getFieldsShows() {
        return "Show Fields\n\n"
                + "Show Name:  The name of the show.\n\n"
                + "Show Description:  The description of the show.\n\n"
                + "Social:  The primary social network page of the show (i.e. a "
                + "facebook page, a souncloud profile, twitter account, etc).\n\n"
                + "Days/Times:  The days and times the show will take place.  Note "
                + "that when you change the number on the spinner, it will affect "
                + "the boxes below it, enabling more or less days/times.\n\n"
                + "Hosts:  The host(s) of the show.  Linked with profiles.";
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
     * Returns the string for adding transactions
     *
     * @return the specified help message
     */
    public static String getAddTransaction() {
        return "Adding a Transaction\n\n"
                + "To add a transaction, go to the Transcations tab in the Finances window, then "
                + "go to the add panel.  There you can enter the store, date, purchaser, "
                + "amount, and reasons/notes.\n\n"
                + "Once the information is entered, click the add button.  The "
                + "result of the addition will be at the bottom of the window.";
    }
    
    /**
     * Returns the string for editing transactions
     *
     * @return the specified help message
     */
    public static String getEditTransaction() {
        return "Editing a Transaction\n\n"
                + "To edit a transaction, click on the transaction you would like to edit from "
                + "the list on the right.  Once selected, click the Edit button.  "
                + "There you can edit the information you would like.\n\n"
                + "When you're done editing, click submit.  The result of the "
                + "edit will be at the bottom of the window.";
    }
    
    /**
     * Returns the string for using the money counter
     *
     * @return the specified help message
     */
    public static String getDeleteTransaction() {
        return "Delete a Transaction\n\n"
                + "To delete a transaction, click on the transaction you would like to "
                + "delete in the list to the right.  Once you select the transaction, "
                + "click delete.  A confirmation will pop up asking if you are "
                + "sure you want to delete that transaction.  Click yes to delete.\n\n"
                + "The result of the deletion will be at the bottom of the window.";
    }
    
    /**
     * Returns the string for the account amounts
     *
     * @return the specified help message
     */
    public static String getAccountAmounts() {
        return "Account Amounts\n\n"
                + "To change the account amounts for a specified account, go "
                + "to that account tab (bank, cash, or 8-account), press edit, "
                + "change the amount, then press submit.  That field should update, "
                + "as well as the total amount at the bottom.";
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
     * Returns the string for transaction fields
     *
     * @return the specified help message
     */
    public static String getFieldsTransactions() {
        return "Transaction Fields\n\n"
                + "Store:  Store the item(s) were purchased at.\n\n"
                + "Date:  Date the item(s) were purchased.\n\n"
                + "Purchaser:  Person who actually purchased it.\n\n"
                + "Amount:  Amount of the purchase.\n\n"
                + "Reason:  Reason for purchase (i.e. Donut Fundraiser).\n\n"
                + "Notes:  Any special notes to append.";
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
