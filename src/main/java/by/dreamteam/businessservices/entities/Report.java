package by.dreamteam.businessservices.entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author fpm.demchenk
 * @version 1.0
 * @created 06-Dec-2014 3:35:02 PM
 */
public class Report {

	private BigDecimal averSalary;
	private Date endDate;
	private Long reportId;
	private Date startDate;

	public Report(){

	}

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @param employeeList
	 */
	public Report(Date startDate, Date endDate, EmployeeList employeeList){

	}
}//end Report