/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.italberto.sugarreference.str;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author italberto
 */
public class Util {
    
    public String text;

    public Util(String text) {
        this.text = text;
    }

    public boolean existPatternIn(String p){
        Pattern pt = Pattern.compile(p);
        Matcher m = pt.matcher(this.text);
        
        if (m.find()){
            return true;
        }
        
        return false;
    }
    
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
        
}
