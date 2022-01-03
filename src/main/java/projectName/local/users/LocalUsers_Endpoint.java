package projectName.local.users;

import common.BaseEndpoint;
import common.IEndpoint;
import projectName.local.users.dataModel.LocalUsers;
import projectName.local.users.dataModel.LocalUsers_DataVault;
import projectName.local.users.dataModel.LocalUsers_Datamodel;

public class LocalUsers_Endpoint extends BaseEndpoint implements IEndpoint {

    private final Class<LocalUsers_Datamodel[]> classType = LocalUsers_Datamodel[].class;
    LocalUsers_DataVault localUsers_dataVault = new LocalUsers_DataVault();

    public final String path = "/users";

    //Endpoint region
    public LocalUsers_Endpoint() {
        super.initRequestBody(classType, "projectName/local/local.json");
    }

    public void convertResponseToDataModel(String response) {
        super.convertJsonToDataModelArray(response, classType);
    }
    //End of Endpoint region

    //DataModel region
    public LocalUsers_Datamodel getUserDataModel() {
        return super.getDataModelAsArray(classType)[0];
    }

    public String getEmail() {
        return super.getValueFromField("email", super.getDataModelAsArray(classType)[0]);
    }

    public String getFirstName() {
        return super.getValueFromField("first_name", super.getDataModelAsArray(classType)[0]);
    }

    public String getLastName() {
        return super.getValueFromField("last_name", super.getDataModelAsArray(classType)[0]);
    }

    public String getJob() {
        return super.getValueFromField("job", super.getDataModelAsArray(classType)[0]);
    }

    public String getId() {
        return super.getValueFromField("id", super.getDataModelAsArray(classType)[0]);
    }

    public void setUserDataByKeyName(String key, String value) {
        super.setValueOfField(key, value, super.getDataModelAsArray(classType)[0]);
    }
    //End of DataModel region

    //LocalUsers region
    public LocalUsers getResultsFromDataModel() {
        LocalUsers_Datamodel localUsers_datamodel = super.getDataModelAsArray(classType)[0];
        LocalUsers localUsers = new LocalUsers();
        localUsers.setEmail(localUsers_datamodel.getEmail());
        localUsers.setFirst_name(localUsers_datamodel.getFirst_name());
        localUsers.setLast_name(localUsers_datamodel.getLast_name());
        localUsers.setJob(localUsers_datamodel.getJob());
        localUsers.setId(Integer.parseInt(localUsers_datamodel.getId()));
        return localUsers;
    }

    public LocalUsers setLocalUserWithDataFromDataVault() {
        LocalUsers_DataVault localUsers_dataVault = getLocalUsersDataVault();
        LocalUsers localUsers = new LocalUsers();
        localUsers.setEmail(localUsers_dataVault.getEmail());
        localUsers.setFirst_name(localUsers_dataVault.getFirst_name());
        localUsers.setLast_name(localUsers_dataVault.getLast_name());
        localUsers.setJob(localUsers_dataVault.getJob());
        localUsers.setId(Integer.parseInt(localUsers_dataVault.getId()));
        return localUsers;
    }
    //End of LocalUsers region

    //DataVault
    public LocalUsers_DataVault getLocalUsersDataVault() {
        return localUsers_dataVault;
    }

    public String getIdFromDataVault() {
        return localUsers_dataVault.getId();
    }

    public void saveResultsFromDataModelToDataVault() {
        LocalUsers_Datamodel localUsers_datamodel = super.getDataModelAsArray(classType)[0];
        localUsers_dataVault.setEmail(localUsers_datamodel.getEmail());
        localUsers_dataVault.setFirst_name(localUsers_datamodel.getFirst_name());
        localUsers_dataVault.setLast_name(localUsers_datamodel.getLast_name());
        localUsers_dataVault.setJob(localUsers_datamodel.getJob());
        localUsers_dataVault.setId(localUsers_datamodel.getId());
    }
    //End of DataVault region

}







