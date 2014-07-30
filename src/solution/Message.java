/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package solution;

/**
 *
 * @author jsingh
 */
public class Message {
    private String about;
    private boolean status;
    
    public Message(String about, boolean status) {
        this.about = about;
        this.status = status;
    }

    public String getAbout() {
        return about;
    }

    public boolean isStatus() {
        return status;
    }
}
