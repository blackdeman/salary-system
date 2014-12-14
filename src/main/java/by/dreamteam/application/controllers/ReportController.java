package by.dreamteam.application.controllers;
import by.dreamteam.businessservices.entities.Report;
import by.dreamteam.database.ReportDAO;
import java.util.Date;
import javax.ejb.EJB;

/**
 * @author dkaganovich
 * @version 1.0
 * @created 06-Dec-2014 3:35:02 PM
 */
public class ReportController {

	private Report report;
	
        @EJB
        ReportDAO reportDAO;

	public ReportController(){
	}

	public void confirmReport(){
	}

	public void createReport(){
	}

	public Report getReport(){
		return null;
	}

	/**
	 * 
	 * @param report
	 */
	public void selectReport(Report report){
	}

	/**
	 * 
	 * @param department
	 */
	public void setDepartment(String department){
	}

	/**
	 * 
	 * @param endDate
	 */
	public void setEndDate(Date endDate){
	}

	/**
	 * 
	 * @param report
	 */
	public void setReport(Report report){
	}

	/**
	 * 
	 * @param startDate
	 */
	public void setStartDate(Date startDate){
	}
}//end ReportController