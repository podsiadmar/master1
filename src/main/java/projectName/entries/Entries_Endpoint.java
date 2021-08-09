package projectName.entries;

import common.BaseEndpoint;
import common.IEndpoint;
import projectName.entries.dataModel.Entries;
import projectName.entries.dataModel.Entries_DataModel;

public class Entries_Endpoint extends BaseEndpoint implements IEndpoint {

    private final Class<Entries_DataModel[]> classType = Entries_DataModel[].class;

    public final String path = "/entries";

    public void convertResponseToDataModel(String response) {
        super.convertJsonToDataModelArray(response, classType);
    }

    public Entries getEntriesResultByApiName(String apiName) {
        for (Entries entries : super.getDataModelAsArray(classType)[0].getEntries()) {
            if (entries.getApi().equals(apiName)) {
                return entries;
            }
        }
        return null;
    }
}
