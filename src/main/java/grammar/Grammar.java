package grammar;

import grammar.atom.*;

import java.util.*;
import java.util.stream.Collectors;

public class Grammar {
    private String grammarName;
    private Code header;
    private List<Rule> rules;
    private List<TokenDef> tokens;
    private List<TokenDef> skipTokens;
    private Set<String> keepInTree;

    private String EPSILON = "EPS";
    private String EOF = "EOF";
    private Map<String, Rule> ruleMap = new HashMap<>();
    private Map<String, Set<String>> first = new HashMap<>();
    private Map<String, Set<String>> follow = new HashMap<>();

    public Grammar(String grammarName, Code header, List<Rule> rules, List<TokenDef> tokens, List<TokenDef> skipTokens, Set<String> keepInTree) {
        this.grammarName = grammarName;
        this.header = header;
        this.rules = rules;
        this.tokens = tokens;
        this.skipTokens = skipTokens;
        this.keepInTree = keepInTree;
    }

    public void check() throws GrammarException {
        if(grammarName.contains("<")) {
            throw new GrammarException("Grammar name must contain only latin letters or _");
        }

        for (final Rule rule : rules) {
            if (ruleMap.containsKey(rule.getName())) {
                throw new GrammarException("Found duplicate in rules with name: " + rule.getName());
            }
            ruleMap.put(rule.getName(), rule);
            first.put(rule.getName(), new HashSet<>());
            follow.put(rule.getName(), new HashSet<>());
        }

        Set<String> tokenNames = new HashSet<>();
        for (final TokenDef token : tokens) {
            if (tokenNames.contains(token.getName())) {
                throw new GrammarException("Found duplicate in tokens with name: " + token.getName());
            }
            if (token.getName().equals(EOF) || token.getName().equals(EPSILON)) {
                throw new GrammarException("Found token with forbidden name: " + token.getName() + "(forbidden names are:" + EPSILON + " and " + EOF + ")");
            }
            tokenNames.add(token.getName());
        }
    }

    public void init() throws GrammarException {
        check();
        calcAllFirst();
        calcFollow();
    }

    private void calcAllFirst() {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (final Rule rule : rules) {
                changed |= calcFirstForRule(rule);
            }
        }
    }

    private boolean calcFirstForRule(Rule rule) {
        String name = rule.getName();
        int sizeBefore = first.get(name).size();

        for (final Option option : rule.getOptions()) {
            first.get(name).addAll(calcFirstForOption(option));
        }

        return first.get(name).size() != sizeBefore;
    }

    public Set<String> calcFirstForOption(Option option) {
        Set<String> res = new HashSet<>();
        List<Atom> atoms = option.getAtoms().stream().filter(atom -> !(atom instanceof Code)).collect(Collectors.toList());

        if (atoms.size() == 0) {
            res.add(EPSILON);
            return res;
        }

        int index = 0;
        while (index < atoms.size()) {
            Atom curAtom = atoms.get(index);

            if (!(curAtom instanceof RuleInv)) {
                break;
            }

            Set<String> curAtomFirst = first.get(((RuleInv) atoms.get(index)).getRuleName());

            if (!curAtomFirst.contains(EPSILON)) {
                break;
            }

            res.addAll(first.get(((RuleInv) curAtom).getRuleName()));
            index++;
        }

        if (index == atoms.size()) {
            return res;
        }

        res.remove(EPSILON);

        Atom notEps = atoms.get(index);
        switch (notEps.getType()) {
            case TOKEN:
                res.add(((TokenInv) notEps).getName());
                break;
            case RULE:
                res.addAll(first.get(((RuleInv) notEps).getRuleName()));
                break;
        }

        return res;
    }

    private void calcFollow() {
        follow.get("start").add(EOF);

        boolean changed = true;
        while (changed) {
            changed = false;

            for (final Rule rule : rules) {
                String ruleName = rule.getName();
                Set<String> ruleFollow = follow.get(ruleName);

                for (final Option option : rule.getOptions()) {
                    List<Atom> atoms = option.getAtoms();
                    for (int i = 0; i < atoms.size(); i++) {
                        Atom cur = atoms.get(i);

                        if (!(cur instanceof RuleInv)) {
                            continue;
                        }

                        int j = i + 1;
                        Atom next = j < atoms.size() ? atoms.get(j) : null;
                        while (j < atoms.size() && next instanceof Code) {
                            next = atoms.get(j);
                            j++;
                        }

                        if (next instanceof Code) {
                            next = null;
                        }

                        Set<String> curRuleFollow = follow.get(((RuleInv) cur).getRuleName());
                        int sizeBefore = curRuleFollow.size();

                        if (next == null) {
                            curRuleFollow.addAll(ruleFollow);
                            changed |= (sizeBefore != curRuleFollow.size());
                            continue;
                        }

                        switch (next.getType()) {
                            case RULE: {
                                RuleInv nextRule = (RuleInv) next;

                                curRuleFollow.addAll(first.get(nextRule.getRuleName()));
                                curRuleFollow.remove(EPSILON);

                                if (first.get(nextRule.getRuleName()).contains(EPSILON)) {
                                    curRuleFollow.addAll(ruleFollow);
                                }
                                break;
                            }
                            case TOKEN:
                                curRuleFollow.add(((TokenInv) next).getName());
                                break;
                        }

                        changed |= (sizeBefore != curRuleFollow.size());
                    }
                }
            }
        }
    }

    public Code getHeader() {
        return header;
    }

    public void setHeader(Code header) {
        this.header = header;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public List<TokenDef> getTokens() {
        return tokens;
    }

    public void setTokens(List<TokenDef> tokens) {
        this.tokens = tokens;
    }

    public List<TokenDef> getSkipTokens() {
        return skipTokens;
    }

    public void setSkipTokens(List<TokenDef> skipTokens) {
        this.skipTokens = skipTokens;
    }

    public String getGrammarName() {
        return grammarName;
    }

    public void setGrammarName(String grammarName) {
        this.grammarName = grammarName;
    }

    public Map<String, Set<String>> getFirst() {
        return first;
    }

    public Map<String, Set<String>> getFollow() {
        return follow;
    }

    public String getEOF() {
        return EOF;
    }

    public String getEPSILON() {
        return EPSILON;
    }

    public Set<String> getKeepInTree() {
        return keepInTree;
    }
}
