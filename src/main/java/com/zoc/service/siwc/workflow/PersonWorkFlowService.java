package com.zoc.service.siwc.workflow;

import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zoc.entity.siwc.Person;
import com.zoc.service.siwc.PersonService;

@Component
@Transactional
public class PersonWorkFlowService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private PersonService personService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	protected TaskService taskService;

	@Autowired
	protected HistoryService historyService;

	@Autowired
	protected RepositoryService repositoryService;

	@Autowired
	private IdentityService identityService;

	public ProcessInstance startWorkFlow(Person person, Map<String, Object> variables) {
		String businessKey = person.getId().toString();
		// 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
		identityService.setAuthenticatedUserId(person.getMaker_id());

		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("orgPersonAdd", businessKey,
				variables);

		String processInstanceId = processInstance.getId();

		person.setProcessInstanceId(processInstanceId);

		logger.debug("start person add flow {}", processInstanceId);

		personService.add(person);

		return processInstance;
	}

}
