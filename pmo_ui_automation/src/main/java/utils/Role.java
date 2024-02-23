package utils;

public enum Role {
    Super_Admin("Super Admin"),
    Admin("Admin"),
    Project_Manager("Project Manager"),
    Resource_Manager("Resource Manager"),
    General_User("General User");

    private final String display;

    Role(String display){
        this.display = display;
    }

    public String getText(){
        return display;
    }
}
