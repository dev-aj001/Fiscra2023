/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

/**
 *
 * @author jairi
 */
public class PasswordStrength {
    public static int checkScore(String pass){
        int score = 0;
        if(pass.length()>=8){
            score++;
        }
        boolean hasUppercase=!pass.equals(pass.toLowerCase());
        if(hasUppercase){
            score++;
        }
        
        boolean hasLowercase=!pass.equals(pass.toUpperCase());
        if(hasLowercase){
            score++;
        }
        
        boolean hasDigit=pass.matches(".*\\d.*");
        if(hasDigit){
            score++;
        }
        
        boolean hasSpecialChar=!pass.matches("[A-Za-z]");
        if(hasSpecialChar){
            score++;
        }
        
        if(score<3)
            return 1;
        else if(score<5)
            return 2;
        else 
            return 3;
    }
}
