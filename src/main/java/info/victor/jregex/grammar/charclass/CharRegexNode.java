package info.victor.jregex.grammar.charclass;

import info.victor.jregex.grammar.CharClassRegexNode;

public class CharRegexNode extends CharClassRegexNode {
    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    private Character character;

    public CharRegexNode(Character character) {
        this.character = character;
    }


}
