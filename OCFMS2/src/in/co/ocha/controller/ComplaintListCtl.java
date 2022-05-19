package in.co.ocha.controller;

import in.co.ocha.model.ComplaintModel;
import in.co.ocha.model.CrimeReportModel;
import in.co.ocha.model.PoliceStationModel;
import in.co.ocha.bean.BaseBean;

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
 * Station List functionality Controller. Performs operation for list, search
 * and delete operations of Student
 * 
 * @author Nalin	
 * @version 1.0
 * @Copyright (c) Nalin Patel
 */

public class ComplaintListCtl extends BaseCtl {

	private static Logger log = Logger.getLogger(ComplaintListCtl.class);

	@Override
	protected ComplaintModel populateModel(HttpServletRequest request) {

		ComplaintModel model = new ComplaintModel();
		System.out.println("Date is " + request.getParameter("doc"));
		System.out.println("Date is "
				+ DataUtility.getDate(request.getParameter("doc")));

		model.setcomplaintId(DataUtility.getString(request
				.getParameter("complaintId")));
		model.setType(DataUtility.getString(request.getParameter("type")));

		model.setDoc(DataUtility.getDate(request.getParameter("doc")));
		model.setPoliceStationId(DataUtility.getLong(request
				.getParameter("policeStationid")));
		model.setpoliceStationName(DataUtility.getString(request
				.getParameter("policeStationname")));
		model.setDoc1(DataUtility.getString(request.getParameter("doc1")));
		model.setDoc1(DataUtility.getString(request.getParameter("doc2")));
		model.setDoc1(DataUtility.getString(request.getParameter("doc3")));
		model.setDoc1(DataUtility.getString(request.getParameter("doc4")));

		return model;
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.debug("ComplaintListCtl doGet Start");

		List list = null;
		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;

		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader
				.getValue("page.size")) : pageSize;

		ComplaintModel model = (ComplaintModel) populateModel(request);

		String op = DataUtility.getString(request.getParameter("operation"));
		//get the selected checkbox ids array for delete list
		String[] ids = request.getParameterValues("ids");
		ComplaintModel cmodel = new ComplaintModel();

		try {

			if (OP_SEARCH.equalsIgnoreCase(op) || "Next".equalsIgnoreCase(op)
					|| "Previous".equalsIgnoreCase(op)) {

				if (OP_SEARCH.equalsIgnoreCase(op)) {
					pageNo = 1;
				} else if (OP_NEXT.equalsIgnoreCase(op)) {
					pageNo++;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
					pageNo--;
				}

			}else if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.COMPLAINT_CTL, request, response);
				return;
			}else if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				
				if (ids != null && ids.length > 0) {
					ComplaintModel deletemodel = new ComplaintModel();
					for (String id : ids) {
						deletemodel.setId(DataUtility.getInt(id));
						deletemodel.delete();
					}
				} else {
					ServletUtility.setErrorMessage(
							"Select at least one record", request);
				}
			}
			
			list = cmodel.search(pageNo, pageSize);
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
		log.debug("ComplaintListCtl doGet End");
	}

	@Override
	protected String getView() {
		return ORSView.COMPLAINT_LIST_VIEW;
	}
}