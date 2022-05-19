package in.co.ocha.controller;

import in.co.util.PropertyReader;

/**
 * Contains ORS View and Controller URI
 * 
 * @author Nalin
 * @version 1.0
 * @Copyright (c) Nalin Patel
 */

public interface ORSView {

	public String APP_CONTEXT = PropertyReader.getValue("app.path");

	public String PAGE_FOLDER = "/jsp";
	public String COMMON_FOLDER = "/common";
	public String USER_FOLDER = "/user"; 

	public String IMG_FOLDER = APP_CONTEXT + "/img";
	public String IMAGES_FOLDER = APP_CONTEXT + "/images";
	public String CSS_FOLDER = APP_CONTEXT + "/css";
	public String JS_FOLDER = APP_CONTEXT + "/js";

	// generic Views
	public String JAVA_DOC_VIEW = APP_CONTEXT + "/doc/index.html";
	public String ERROR_VIEW = COMMON_FOLDER + "/Error.jsp";
	public String LAYOUT_VIEW = "/Layout.jsp";

	// User View Folder
	public String USER_VIEW = USER_FOLDER + "/UserView.jsp";
	public String USER_LIST_VIEW = USER_FOLDER + "/UserListView.jsp";
	public String USER_REGISTRATION_VIEW = USER_FOLDER
			+ "/UserRegistrationView.jsp";
	public String LOGIN_VIEW = USER_FOLDER + "/LoginView.jsp";
	public String CHANGE_PASSWORD_VIEW = USER_FOLDER
			+ "/ChangePasswordView.jsp";
	public String MY_PROFILE_VIEW = USER_FOLDER + "/MyProfileView.jsp";
	public String FORGET_PASSWORD_VIEW = USER_FOLDER
			+ "/ForgetPasswordView.jsp";

	// Role View
	public String ROLE_VIEW = USER_FOLDER + "/RoleView.jsp";
	public String ROLE_LIST_VIEW = USER_FOLDER + "/RoleListView.jsp";

	//Common Folder
	public String WELCOME_VIEW = COMMON_FOLDER + "/Welcome.jsp";
	
	// generic Controller
	public String ERROR_CTL = "/ErrorCtl";
	public String WELCOME_CTL = APP_CONTEXT + "/WelcomeCtl";
	
	// User Controller
	
	// Without Login
    public String LOGIN_CTL = APP_CONTEXT + "/LoginCtl";
	public String LOGOUT_CTL = APP_CONTEXT + "/LoginCtl";
	public String USER_REGISTRATION_CTL = APP_CONTEXT + "/UserRegistrationCtl";
	public String FORGET_PASSWORD_CTL = APP_CONTEXT + "/ForgetPasswordCtl";
	public String CHANGE_PASSWORD_CTL = APP_CONTEXT + "/ctl/ChangePasswordCtl";
	
	// After Login
	public String USER_CTL = APP_CONTEXT + "/ctl/UserCtl";
	public String USER_LIST_CTL = APP_CONTEXT + "/ctl/UserListCtl";
	public String MY_PROFILE_CTL = APP_CONTEXT + "/ctl/MyProfileCtl";
	
	// Role Controller
	public String ROLE_CTL = APP_CONTEXT + "/ctl/RoleCtl";
	public String ROLE_LIST_CTL = APP_CONTEXT + "/ctl/RoleListCtl";
	
	
	//Complaint Controller
	

	public String COMPLAINT_CTL = APP_CONTEXT + "/ctl/ComplaintCtl";
	public String COMPLAINT_LIST_CTL = APP_CONTEXT + "/ctl/ComplaintListCtl";

	public String FEEDBACK_CTL = APP_CONTEXT + "/ctl/FeedbackCtl";
	public String FEEDBACK_LIST_CTL = APP_CONTEXT + "/ctl/FeedbackListCtl";

	public String MAIL_CTL = APP_CONTEXT + "/ctl/MailCtl";
	public String MAIL_LIST_CTL = APP_CONTEXT + "/ctl/MailListCtl";

	public String INBOX_LIST_CTL = APP_CONTEXT + "/ctl/InboxListCtl";
	public String SENDBOX_LIST_CTL = APP_CONTEXT + "/ctl/SendboxListCtl";

//hot news ctls
	public String HOT_NEWS_CTL = APP_CONTEXT + "/ctl/HotNewsCtl";
	public String HOT_NEWS_LIST_CTL = APP_CONTEXT + "/ctl/HotNewsListCtl";

	public String HOTNEWS_VIEW = PAGE_FOLDER + "/HotNewsView.jsp";
	public String HOTNEWS_LIST_VIEW = PAGE_FOLDER + "/HotNewsListview.jsp";
	public String CRIMEREPORT_VIEW = PAGE_FOLDER + "/CrimeReportView.jsp";
	public String CRIMEREPORT_LIST_VIEW = PAGE_FOLDER
			+ "/CrimeReportListView.jsp";
	public String CRIMEREPORT_CTL = APP_CONTEXT + "/ctl/CrimeReportCtl";
	public String CRIMEREPORT_LIST_CTL = APP_CONTEXT
			+ "/ctl/CrimeReportListCtl";
	public String COMPLAINT_VIEW = PAGE_FOLDER + "/ComplaintView.jsp";
	public String COMPLAINT_LIST_VIEW = PAGE_FOLDER + "/ComplaintListView.jsp";

	public String FEEDBACK_VIEW = PAGE_FOLDER + "/FeedbackView.jsp";
	public String FEEDBACK_LIST_VIEW = PAGE_FOLDER + "/FeedbackListView.jsp";

	public String MAIL_VIEW = PAGE_FOLDER + "/MailView.jsp";
	public String MAIL_LIST_VIEW = PAGE_FOLDER + "/MailListView.jsp";

	public String INBOX_LIST_VIEW = PAGE_FOLDER + "/InboxListView.jsp";
	public String SENDBOX_LIST_VIEW = PAGE_FOLDER + "/SendboxListView.jsp";

	public String MOSTWANTED_VIEW = PAGE_FOLDER + "/MostWantedView.jsp";
	public String MOSTWANTED_LIST_VIEW = PAGE_FOLDER
			+ "/MostWantedListView.jsp";
	public String MOSTWANTED_CTL = APP_CONTEXT + "/ctl/MostWantedCtl";
	public String MOSTWANTED_LIST_CTL = APP_CONTEXT + "/ctl/MostWantedListCtl";
	public String MISSINGPERSON_VIEW = PAGE_FOLDER + "/MissingPersonView.jsp";
	public String MISSINGPERSON_LIST_VIEW = PAGE_FOLDER
			+ "/MissingPersonListView.jsp";
	public String MISSINGPERSON_CTL = APP_CONTEXT + "/ctl/MissingPersonCtl";
	public String MISSINGPERSON_LIST_CTL = APP_CONTEXT
			+ "/ctl/MissingPersonListCtl";
	public String POLICESTATION_VIEW = PAGE_FOLDER + "/PoliceStationView.jsp";
	public String POLICESTATION_CTL = APP_CONTEXT + "/ctl/PoliceStationCtl";
	public String POLICESTATION_LIST_VIEW = PAGE_FOLDER
			+ "/PoliceStationListView.jsp";
	public String POLICESTATION_LIST_CTL = APP_CONTEXT
			+ "/ctl/PoliceStationListCtl";

}
