package com.zoc.activiti;

import static org.junit.Assert.assertNotNull;


import org.springside.modules.test.spring.SpringTransactionalTestCase;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * 测试流程引擎
 *
 * @author HenryYan
 */
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ProcessEngineTest extends SpringTransactionalTestCase {

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

	/**
	 * 检测引擎是否能正常工作
	 */
	@Test
	public void testProcessEngines() {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("financialReport");
		String processId = processInstance.getId();
		System.out.println("process id " + processId);
	}

}
