package lesson5.lab5.prob1.rulesets;

import java.awt.Component;
import java.util.HashMap;

import lesson5.lab5.prob1.RuleSet;
import lesson5.lab5.prob1.samplecode.AddrWindow;
import lesson5.lab5.prob1.samplecode.ProfileWindow;


final public class RuleSetFactory {
	private RuleSetFactory(){}
	
	static HashMap<Class<? extends Component>, RuleSet> map = new HashMap<>();
	
	static {
		map.put(AddrWindow.class, new AddressRuleSet());
		map.put(ProfileWindow.class, new CustomerProfileRuleSet());
	}
	
	public static RuleSet getRuleSet(Component c) {
		Class<? extends Component> cl = c.getClass();
		if(!map.containsKey(cl)) {
			throw new IllegalArgumentException("No RuleSet found for this Component");
		}
		return map.get(cl);
	}
}
