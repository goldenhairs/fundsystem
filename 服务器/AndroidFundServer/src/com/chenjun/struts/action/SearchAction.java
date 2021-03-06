/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.chenjun.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.chenjun.dao.MySQLConnection;
import com.chenjun.fund.model.JjBaseInfo;
import com.chenjun.struts.form.SearchForm;

/** 
 * MyEclipse Struts
 * Creation date: 03-10-2012
 * 
 * XDoclet definition:
 * @struts.action path="/search" name="searchForm" input="/searchTestJsp.jsp" scope="request" validate="true"
 */
public class SearchAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SearchForm searchForm = (SearchForm) form;
		
		String info = searchForm.getInfo();
		
		MySQLConnection myConn = new MySQLConnection();
		
		List<JjBaseInfo> jjBaseInfos = myConn.querySearch(info);
		
		request.setAttribute("jjBaseInfos", jjBaseInfos);
		
		return new ActionForward("/jjBaseInfos.jsp");
	}
}