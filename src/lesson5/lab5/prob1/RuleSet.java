package lesson5.lab5.prob1;

import java.awt.Component;

import lesson5.lab5.prob1.rulesets.RuleException;

public interface RuleSet {
	public void applyRules(Component ob) throws RuleException;
}
