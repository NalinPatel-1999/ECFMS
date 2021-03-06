package in.co.ocha.controller;

import in.co.ocha.model.BaseModel;

import in.co.ocha.model.CrimeReportModel;
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
public class CrimeReportListCtl extends BaseCtl {
	private static Logger log = Logger.getLogger(CrimeReportListCtl.class);

	@Override
	protected BaseModel populateModel(HttpServletRequest request) {
		CrimeReportModel model = new  CrimeReportModel();

		model.setTypeOfCrime(DataUtility.getString(request
				.getParameter("typeOfCrime")));
		
		model.setPlace(DataUtility.getString(request
				.getParameter("place")));

		return model;
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		log.debug("CrimeReportListCtl doGet Start");

		List list = null;

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader
				.getValue("page.size")) : pageSize;

		CrimeReportModel model = (CrimeReportModel) populateModel(request);

		String op = DataUtility.getString(request.getParameter("operation"));
		
		//get the selected checkbox ids array for delete list
		String[] ids = request.getParameterValues("ids");
		
		try {

			if (OP_SEARCH.equalsIgnoreCase(op) || "Next".equalsIgnoreCase(op)
					|| "Previous".equalsIgnoreCase(op)) {

				if (OP_SEARCH.equalsIgnoreCase(op)) {
					pageNo = 1;
				} else if (OP_NEXT.equalsIgnoreCase(op)) { 
					ServletUtility.redirect(ORSView.CRIMEREPORT_CTL, request, response);
					return;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op))  {
					ServletUtility.redirect(ORSView.CRIMEREPORT_LIST_CTL, request, response);
					return;
				}

			} else if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.CRIMEREPORT_CTL, request, response);
				return;
			} else if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				
				if (ids != null && ids.length > 0) {
					CrimeReportModel deletemodel = new CrimeReportModel();
					for (String id : ids) {
						deletemodel.setId(DataUtility.getInt(id));
						deletemodel.delete();
					}
				} else {
					ServletUtility.setErrorMessage(
							"Select at least one record", request);
				}
			}
			list = model.search(pageNo, pageSize);
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

		log.debug("CrimeReportListCtl doGet End");
	}

	@Override
	protected String getView() {
		return ORSView.CRIMEREPORT_LIST_VIEW;
	}

}
