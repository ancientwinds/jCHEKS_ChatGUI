package com.archosResearch.jCHEKS.gui.chat.view;

import javafx.scene.control.TextField;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class SpecificTextField extends TextField{
    private String pattern;
    
    public SpecificTextField(){
        this.pattern = "(.*?)";
    }
    
    @Override
    public void replaceText(int start, int end, String text)
    {
        if (validate(text))
        {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text)
    {
        if (validate(text))
        {
            super.replaceSelection(text);
        }
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    private boolean validate(String text)
    {
        return ("".equals(text) || text.matches(this.getPattern()));
    }
}
