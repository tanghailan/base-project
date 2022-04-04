package com.coderman.configure;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Collections;
import java.util.List;

/**
 * @author coderman
 * @Title: 配置事务
 * @Description: TOD
 * @date 2022/3/1618:05
 */
public class BasicTransactionConfigure {


    public TransactionInterceptor transactionInterceptor(PlatformTransactionManager transactionManager) {

        NameMatchTransactionAttributeSource transactionAttributeSource = new NameMatchTransactionAttributeSource();
        List<RollbackRuleAttribute> rollbackRuleAttributeList = Collections.singletonList(new RollbackRuleAttribute(Throwable.class));


        // 使用事务
        RuleBasedTransactionAttribute requiredLongTx = new RuleBasedTransactionAttribute();
        requiredLongTx.setTimeout(30);
        requiredLongTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredLongTx.setRollbackRules(rollbackRuleAttributeList);
        transactionAttributeSource.addTransactionalMethod("save", requiredLongTx);

        // 使用事务
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
        requiredLongTx.setTimeout(15);
        requiredLongTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredLongTx.setRollbackRules(rollbackRuleAttributeList);

        transactionAttributeSource.addTransactionalMethod("insert", requiredTx);
        transactionAttributeSource.addTransactionalMethod("update", requiredTx);
        transactionAttributeSource.addTransactionalMethod("modify", requiredTx);
        transactionAttributeSource.addTransactionalMethod("delete", requiredTx);
        transactionAttributeSource.addTransactionalMethod("remove", requiredTx);

        // 使用事务
        RuleBasedTransactionAttribute requiredNewTx = new RuleBasedTransactionAttribute();
        requiredLongTx.setTimeout(15);
        requiredLongTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        requiredLongTx.setRollbackRules(rollbackRuleAttributeList);

        transactionAttributeSource.addTransactionalMethod("noTran", requiredNewTx);

        // 使用事务
        RuleBasedTransactionAttribute requiredTimerTx = new RuleBasedTransactionAttribute();
        requiredLongTx.setTimeout(50);
        requiredLongTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredLongTx.setRollbackRules(rollbackRuleAttributeList);
        transactionAttributeSource.addTransactionalMethod("*Timer", requiredTimerTx);

        // 使用事务
        RuleBasedTransactionAttribute requiredLongTimerTx = new RuleBasedTransactionAttribute();
        requiredLongTx.setTimeout(150);
        requiredLongTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredLongTx.setRollbackRules(rollbackRuleAttributeList);
        transactionAttributeSource.addTransactionalMethod("*LongTimer", requiredLongTimerTx);

        // 只读事务
        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        requiredLongTx.setReadOnly(true);
        requiredLongTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);
        transactionAttributeSource.addTransactionalMethod("*", readOnlyTx);

        return new TransactionInterceptor(transactionManager, transactionAttributeSource);
    }

    public Advisor advisor(Advice advisor, String expression) {

        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);

        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(aspectJExpressionPointcut, advisor);
        defaultPointcutAdvisor.setOrder(5);

        return defaultPointcutAdvisor;
    }


}
