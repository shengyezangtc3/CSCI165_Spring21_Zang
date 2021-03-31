/**
 * Author: Shengye Zang
 * Date: March 25, 2021
 * Assignment: Week 8 Lab
 */

public class Customer {
    private String name;
    private String email;
    private String phone;

    public Customer() {}

    public Customer(String name, String email, String phone) {
        this.name = name;
        setEmail(email);
        setPhone(phone);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        int index = email.lastIndexOf("@");
        String prefix = email.substring(0, index);
        int dotIndex = email.indexOf(".");
        int dotIndex2 = email.lastIndexOf(".");

        String validCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789#!%$‘&+*–/=?^_`.{|}~";
        // @ not at first or last
        if (index == 0 || index == email.length()-1) return;
        // @ not after the last .
        if (index > dotIndex2) return;
        // prefix not longer than 64
        if (prefix.length() > 64) return;
        // No . at the first or last position of prefix
        if (dotIndex == 0 || dotIndex == prefix.length()-1) return;

        // check for existence of two consecutive periods and invalid characters
        for(int i=0; i<prefix.length(); i++) {
            if (email.charAt(i) == '.' && email.charAt(i) == email.charAt(i+1)) {
                return;
            }
            if (validCharacters.indexOf(email.charAt(i)) == -1) {
                return;
            }
        }
        // check for existence of two consecutive periods after prefix
        for(int i=prefix.length(); i<email.length(); i++) {
            if (email.charAt(i) == '.' && email.charAt(i) == email.charAt(i+1)) {
                return;
            }
        }

        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhone(String phone) {
        /**
         * try {
            int phoneNumber = Integer.parseInt(phone);
            if(phone.length() != 10) {
                this.phone = "Not on file";
            }
            else
                this.phone = phone;
        } catch (NumberFormatException nfe) {
            this.phone = "Not on file";
        }
         */
        
        if(phone.length() != 10) {
            this.phone = "Not on file";
            return;
        }
        for(char current : phone.toCharArray()) {
            if(!Character.isDigit(current)) {
                this.phone = "Not on file";
                return;
            }
        }
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public String toString() {
        return "Name: " + this.name + " Email: " + this.email + " Phone: " + this.phone;
    }

    public boolean equals(Customer otherCustomer) {
        return this.name.equals(otherCustomer.name) && this.email.equals(otherCustomer.email) && this.phone.equals(otherCustomer.phone);
    }

}
