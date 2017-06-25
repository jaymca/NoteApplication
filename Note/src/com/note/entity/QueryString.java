package com.note.entity;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(value =
{
	/*******************************
     * Note Query
     *******************************/

    @NamedQuery(name = "QUERY_TASK_ESCALATION_COUNT", query = "SELECT task FROM TaskDB task " + "WHERE task.taskId = :escalatedTaskId ")

})
		
public class QueryString {

}
