package com.example.myspring.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CuiChengLong
 * @Date: 2023/5/22 18:58
 * @Description
 */
public class MySentinelTest {

    public static void main(String[] args) {
        //配置规则
        initFlowRules();

        int n = 5000;
        //定义资源
        while (true) {
            try (Entry entry = SphU.entry("HelloWorld")) {
                System.out.println("hello world");
            } catch (BlockException ex) {
                System.out.println("blocked!");
            }
        }

    }

    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

}
