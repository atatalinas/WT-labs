package entity;

import java.util.HashMap;

public enum UserType {
    CLIENT, MANAGER;

    public static UserType fromString(String s) throws InvalidUserTypeException {
        switch (s){
            case "client"->{return CLIENT;}
            case "manager"->{return MANAGER;}
        }
        throw new InvalidUserTypeException();
    }
    public int toInt(){
        switch (this){
            case CLIENT->{return 1;}
            case MANAGER->{return 2;}
        }
        return 0;
    }
    public static UserType fromInt(int userType) throws InvalidUserTypeException {
        switch (userType){
            case 1->{return CLIENT;}
            case 2->{return MANAGER;}
        }
        throw new InvalidUserTypeException();
    }
}
