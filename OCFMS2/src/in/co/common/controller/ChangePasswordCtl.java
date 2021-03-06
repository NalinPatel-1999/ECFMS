package in.co.common.controller;

import in.co.ocha.controller.ORSView;

import in.co.ocha.exception.RecordNotFoundException;
import in.co.ocha.model.BaseModel;
import in.co.common.model.UserModel;
import in.co.ocha.bean.BaseBean;
import in.co.ocha.bean.UserBean;
import in.co.ocha.controller.BaseCtl;
import in.co.ocha.exception.ApplicationException;
import in.co.ocha.model.AppRoles;
import in.co.util.AccessUtility;
import in.co.util.DataUtility;
import in.co.util.DataValidator;
import in.co.util.PropertyReader;
import in.co.util.ServletUtility;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Change Password functionality Controller. Performs operation for Change
 * Password
 * 
 * @author Nalin	
 * @version 1.0
 * @Copyright (c) Nalin Patel
 */

public class ChangePasswordCtl extends BaseCtl {

	public static final String OP_CHANGE_MY_PROFILE = "Change My Profile";

	/**
	 * Logger to log the messages.
	 */

	private static Logger log = Logger.getLogger(ChangePasswordCtl.class);

	/**
	 * Validates Input data
	 */
	@Override
	protected boolean validate(HttpServletRequest request) {

		log.debug("ChangePasswordCtl Method validate Started");

		boolean pass = true;

		String op = request.getParameter("operation");

		if (OP_CHANGE_MY_PROFILE.equalsIgnoreCase(op)) {

			return pass;
		}
		if (DataValidator.isNull(request.getParameter("oldPassword"))) {
			request.setAttribute("oldPassword",
					PropertyReader.getValue("error.require", "Old Password"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("newPassword"))) {
			request.setAttribute("newPassword",
					PropertyReader.getValue("error.require", "New Password"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("confirmPassword"))) {
			request.setAttribute("confirmPassword", PropertyReader.getValue(
					"error.require", "Confirm Password"));
			pass = false;
		}
		if (!request.getParameter("newPassword").equals(
				request.getParameter("confirmPassword"))
				&& !"".equals(request.getParameter("confirmPassword"))) {
			ServletUtility.setErrorMessage(
					"New and confirm passwords not matched", request);

			pass = false;
		}

		log.debug("ChangePasswordCtl Method validate Ended");

		return pass;
	}

	@Override
	protected BaseModel populateModel(HttpServletRequest request) {
		log.debug("ChangePasswordCtl Method populatebean Started");

		UserModel bean = new UserModel();

		bean.setPassword(DataUtility.getString(request
				.getParameter("oldPassword")));

		bean.setConfirmPassword(DataUtility.getString(request
				.getParameter("confirmPassword")));

		populateModel(bean, request);

		log.debug("ChangePasswordCtl Method populatebean Ended");

		return bean;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);

		log.debug("ChangePasswordCtl Method doGet Started");

		String op = DataUtility.getString(request.getParameter("operation"));

		// get model
		UserModel model = new UserModel();

		UserModel bean = (UserModel) populateModel(request);

		UserModel sessionModel = (UserModel) session.getAttribute("user");

		String newPassword = (String) request.getParameter("newPassword");

		long id = sessionModel.getId();

		if (OP_SAVE.equalsIgnoreCase(op)) {

			try {
				boolean flag = model.changePassword(id, bean.getPassword(),
						newPassword);
				if (flag == true) {
					bean = model.findByLogin(sessionModel.getLogin());
					session.setAttribute("user", bean);
					ServletUtility.setModel(bean, request);
					ServletUtility.setSuccessMessage(
							"Password has been changed Successfully.", request);
				}
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;

			} catch (RecordNotFoundException e) {
				ServletUtility.setErrorMessage("Old PassWord is Invalid",
						request);
			}

		} else if (OP_CHANGE_MY_PROFILE.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.MY_PROFILE_CTL, request, response);
			return;

		}

		ServletUtility.forwardView(getView(), request, response);

		log.debug("ChangePasswordCtl Method doGet Ended");
	}

	@Override
	protected String getView() {
		return ORSView.CHANGE_PASSWORD_VIEW;
	}

}








