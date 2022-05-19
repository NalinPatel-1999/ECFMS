package in.co.ocha.controller;

import in.co.ocha.model.BaseModel;

import in.co.ocha.model.MailModel;
import in.co.common.model.UserModel;
import in.co.ocha.bean.UserBean;

import in.co.ocha.exception.ApplicationException;
import in.co.util.DataUtility;
import in.co.util.PropertyReader;
import in.co.util.ServletUtility;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * User List functionality Controller. Performs operation for list, search and
 * delete operations of User
 * 
 * @author Nalin
 * @version 1.0
 * @Copyright (c) Nalin Patel
 */

public class InboxListCtl extends BaseCtl {
	
	private static Logger log = Logger.getLogger(InboxListCtl.class);

	@Override
	protected BaseModel populateModel(HttpServletRequest request) {
		
		MailModel model = new MailModel();
		UserModel userBean = (UserModel) request.getSession().getAttribute("user");
		model.setReceiver(userBean.getLogin());
		model.setSender(DataUtility.getString(request.getParameter("sender")));

		return model;
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		log.debug("InboxListCtl doGet Start");

		List list = null;

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader
				.getValue("page.size")) : pageSize;

		MailModel model = (MailModel) populateModel(request);
		
		String op = DataUtility.getString(request.getParameter("operation"));

		// get the selected checkbox ids array for delete list
		String[] ids = request.getParameterValues("ids");

		try {

			if (OP_SEARCH.equalsIgnoreCase(op) || "Next".equalsIgnoreCase(op)
					|| "Previous".equalsIgnoreCase(op)) {

				if (OP_SEARCH.equalsIgnoreCase(op)) {
					pageNo = 1;
				} else if (OP_NEXT.equalsIgnoreCase(op)) {
					pageNo++;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
					ServletUtility.redirect(ORSView.INBOX_LIST_CTL, request,
							response);
					return;
				}

			} else if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.INBOX_LIST_CTL, request,
						response);
				return;
			} else if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;

				if (ids != null && ids.length > 0) {

					System.out.println("in this loop");
					MailModel deletemodel = new MailModel();
					for (String id : ids) {
						System.out.println(id);
						deletemodel.setId(DataUtility.getInt(id));
						deletemodel.delete();

					}
				} else {
					ServletUtility.setErrorMessage(
							"Select at least one record", request);
				}
			}
			
			list = model.search(pageNo, pageSize);
			
			System.out.println("list size" + list.size());
			
			ServletUtility.setList(list, request);
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No record found ", request);
			}
			ServletUtility.setList(list, request);

			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			
			ServletUtility.forwardView(getView(), request, response);

		} catch (ApplicationException e) {
			log.error(e);
			ServletUtility.handleException(e, request, response);
			return;
		}

		log.debug("InboxListCtl doGet End");
	}

	@Override
	protected String getView() {
		return ORSView.INBOX_LIST_VIEW;
	}

}