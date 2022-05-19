package in.co.common.controller;

import in.co.ocha.controller.ORSView;
import in.co.ocha.exception.RecordNotFoundException;
import in.co.ocha.model.BaseModel;
import in.co.common.model.UserModel;
import in.co.ocha.bean.BaseBean;
import in.co.ocha.bean.UserBean;
import in.co.ocha.controller.BaseCtl;
import in.co.ocha.exception.ApplicationException;
import in.co.util.DataUtility;
import in.co.util.DataValidator;
import in.co.util.PropertyReader;
import in.co.util.ServletUtility;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Forget Password functionality Controller. Performs operation for Forget
 * Password
 * 
 * @author Nalin
 * @version 1.0
 * @Copyright (c) Nalin Patel
 */

public class ForgetPasswordCtl extends BaseCtl {
	/**
	 * Logger to log the messages.
	 */

	private static Logger log = Logger.getLogger(ForgetPasswordCtl.class);

	@Override
	protected boolean validate(HttpServletRequest request) {

		log.debug("ForgetPasswordCtl Method validate Started Nalin");

		boolean pass = true;

		String login = request.getParameter("login");

		if (DataValidator.isNull(login)) {
			request.setAttribute("login",
					PropertyReader.getValue("error.require", "Email Id"));
			pass = false;
		} else if (!DataValidator.isEmail(login)) {
			request.setAttribute("login",
					PropertyReader.getValue("error.email", "Login "));
			pass = false;
		}
		log.debug("ForgetPasswordCtl Method validate Ended Nalin");

		return pass;
	}

	@Override
	protected BaseModel populateModel(HttpServletRequest request) {

		log.debug("ForgetPasswordCtl Method populatebean Started");

		UserModel bean = new UserModel();

		bean.setLogin(DataUtility.getString(request.getParameter("login")));

		log.debug("ForgetPasswordCtl Method populatebean Ended");

		return bean;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		log.debug("ForgetPasswordCtl Method doPost Started");

		String op = DataUtility.getString(request.getParameter("operation"));

		UserModel model = (UserModel) populateModel(request);

		// get model
		UserModel model1 = new UserModel();

		if (OP_GO.equalsIgnoreCase(op)) {

			try {
				model.forgetPassword(model.getLogin());
				ServletUtility.setSuccessMessage(
						"Password has been sent to your email id.", request);
			} catch (RecordNotFoundException e) {
				ServletUtility.setErrorMessage(e.getMessage(), request);
				log.error(e);
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
			/*ServletUtility.forward(ORSView.FORGET_PASSWORD_VIEW, request,
					response);*/
		} else {

			/*
			 * ServletUtility.forward(ORSView.FORGET_PASSWORD_VIEW, request,
			 * response);
			 */

			ServletUtility.forwardView(ORSView.FORGET_PASSWORD_VIEW, request,
					response);
		}

		log.debug("ForgetPasswordCtl Method doGet Ended");
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get me");
		if(request.getParameter("login")!= null)
		doPost(request, response);
		ServletUtility.forwardView(ORSView.FORGET_PASSWORD_VIEW, request,
				response);
	}

	@Override
	protected String getView() {
		return ORSView.FORGET_PASSWORD_VIEW;
	}

}