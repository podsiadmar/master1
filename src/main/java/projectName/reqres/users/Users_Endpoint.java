package projectName.reqres.users;

import common.BaseEndpoint;
import common.IEndpoint;
import projectName.entries.dataModel.Entries;
import projectName.entries.dataModel.Entries_DataModel;
import projectName.reqres.users.dataModel.Users;
import projectName.reqres.users.dataModel.Users_DataModel;

public class Users_Endpoint extends BaseEndpoint implements IEndpoint {

    private final Class<Users_DataModel[]> classType = Users_DataModel[].class;

    public final String path = "/users";

    public Users_Endpoint() {
        super.initRequestBody(classType, "projectName/reqres/users/usersDefaultPost.json");
    }

    public void convertResponseToDataModel(String response) {
        super.convertJsonToDataModelArray(response, classType);
    }


    public Users getUserResultByID(int id){
        for (Users users : super.getDataModelAsArray(classType)[0].getUsers()) {
            if (users.getId() == id) {
                return users;
            }
        }
        return null;
    }

    public String getEmail() {
        return super.getDataModelAsArray(classType)[0].getUsers().get(0).getEmail();
    }

    public String getName() {
        return super.getDataModelAsArray(classType)[0].getName();
    }

    public String getJob() {
        return super.getDataModelAsArray(classType)[0].getJob();
    }

    public Users getUserData() {
        return super.getDataModelAsArray(classType)[0].getUsers().get(0);
    }

    public Users_DataModel getUserDataModel() {
        return super.getDataModelAsArray(classType)[0];
    }


    public void setUserDataByKeyName(String key, String value) {
        super.setValueOfField(key, value, super.getDataModelAsArray(classType)[0]);
    }

    public String getUserDataTEST(String key) {
        return super.getValueFromField(key, super.getDataModelAsArray(classType)[0]);
    }

}
