package com.zoc.service.siwc.impl;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.zoc.entity.siwc.Person;
import com.zoc.service.siwc.workflow.PersonWorkFlowService;

@ContextConfiguration(locations = { "/applicationContext.xml" })
public class PersonAddServiceImplTest extends SpringTransactionalTestCase {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private FormService formService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private HistoryService historyService;

	@Autowired
	private ManagementService managementService;
	
	@Autowired
	private PersonWorkFlowService personWorkFlowService;
	
	@Test
	public void testAllPass(){
		Person person = new Person();
		person.setId(new Long("123456"));
		person.setMaker_id("admin");
		person.setPerson_name("super");
		person.setPerson_id("superzoc");
		Map<String, Object> variables = new HashMap<String, Object>();
		ProcessInstance processInstance = personWorkFlowService.startWorkFlow(person, variables);
		assertNotNull(person.getProcessInstanceId());
	}

}
