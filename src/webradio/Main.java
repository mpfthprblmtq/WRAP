package webradio;

public class Main {

    public static Account p;

    static MainGUI mainGUI;

    static AccountGUI accountGUI;
    static boolean accountGUIVisible = false;

    static ProfileGUI profileGUI;
    static boolean profileGUIVisible = false;
    
    static TaskGUI taskGUI;
    static boolean taskGUIVisible = false;

    static FinanceGUI financeGUI;
    static boolean financeGUIVisible = false;

    static LinkGUI linkGUI;
    static boolean linkGUIVisible = false;

    static ReportsGUI reportsGUI;
    static boolean reportsGUIVisible = false;
    
    static BugReportGUI bugreportGUI;
    static boolean bugreportGUIVisible = false;

    public static void main(String[] args) {
        
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setLocationRelativeTo(null);
        loginGUI.setVisible(true);
    }

    public static void SetUser(Account p) {
        Main.p = p;
    }
    
    public static Account getUser() {
        return p;
    }

    public static void Logout() {
        Main.p = null;
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setLocationRelativeTo(null);
        loginGUI.setVisible(true);
    }

    public static void LaunchMainGUI() {
        mainGUI = new MainGUI();
        mainGUI.setLocationRelativeTo(null);
        mainGUI.setVisible(true);
    }

    public static void CloseMainGUI() {
        mainGUI.dispose();
    }

    public static void LaunchAccountGUI() {
        if (!accountGUIVisible) {
            accountGUI = new AccountGUI();
            accountGUI.setLocationRelativeTo(null);
            accountGUI.setVisible(true);
            accountGUIVisible = true;
        }
    }

    public static void CloseAccountGUI() {
        accountGUI.dispose();
        accountGUIVisible = false;
    }

    public static void LaunchProfileGUI() {
        if (!profileGUIVisible) {
            profileGUI = new ProfileGUI();
            profileGUI.setLocationRelativeTo(null);
            profileGUI.setVisible(true);
            profileGUIVisible = true;
        }
    }

    public static void CloseProfileGUI() {
        profileGUI.dispose();
        profileGUIVisible = false;
    }
    
    public static void LaunchTaskGUI() {
        if (!taskGUIVisible) {
            taskGUI = new TaskGUI();
            taskGUI.setLocationRelativeTo(null);
            taskGUI.setVisible(true);
            taskGUIVisible = true;
        }
    }

    public static void CloseTaskGUI() {
        taskGUI.dispose();
        taskGUIVisible = false;
    }

    public static void LaunchFinanceGUI() {
        if (!financeGUIVisible) {
            financeGUI = new FinanceGUI();
            financeGUI.setLocationRelativeTo(null);
            financeGUI.setVisible(true);
            financeGUIVisible = true;
        }
    }

    public static void CloseFinanceGUI() {
        financeGUI.dispose();
        financeGUIVisible = false;
    }

    public static void LaunchLinkGUI() {
        if (!linkGUIVisible) {
            linkGUI = new LinkGUI();
            linkGUI.setLocationRelativeTo(null);
            linkGUI.setVisible(true);
            linkGUIVisible = true;
        }
    }

    public static void CloseLinkGUI() {
        linkGUI.dispose();
        linkGUIVisible = false;
    }

    public static void LaunchReportsGUI() {
        if (!reportsGUIVisible) {
            reportsGUI = new ReportsGUI();
            reportsGUI.setLocationRelativeTo(null);
            reportsGUI.setVisible(true);
            reportsGUIVisible = true;
        }
    }

    public static void CloseReportsGUI() {
        reportsGUI.dispose();
        reportsGUIVisible = false;
    }
    
    public static void LaunchBugReportGUI() {
        if (!bugreportGUIVisible) {
            bugreportGUI = new BugReportGUI();
            bugreportGUI.setLocationRelativeTo(null);
            bugreportGUI.setVisible(true);
            bugreportGUIVisible = true;
        }
    }

    public static void CloseBugReportGUI() {
        bugreportGUIVisible = false;
    }
}
