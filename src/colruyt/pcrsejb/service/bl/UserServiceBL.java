package colruyt.pcrsejb.service.bl;

import java.util.regex.*;

public class UserServiceBL{
    
   private boolean controlOnInt(String string){
       boolean checkStringonInt = false;
       if(!string.matches("-?(0|[1-9]\\d*)")){
           checkStringonInt = true;
       }
       return checkStringonInt;
   }
   
   public boolean checkFirstName(String fName){
       return controlOnInt(fName);
   }
   
    public boolean checkLastName(String lName){
        return controlOnInt(lName);
    }
    
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }
    
    public boolean Password(String pasword){
       return true;
    }
    
    public boolean hasPrivilege(){
    
    }
    
   
    

}
