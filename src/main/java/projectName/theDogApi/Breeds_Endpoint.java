package projectName.theDogApi;

import common.BaseEndpoint;
import common.IEndpoint;
import projectName.entries.dataModel.Entries;
import projectName.theDogApi.dataModel.Breeds.Breeds;
import projectName.theDogApi.dataModel.Breeds.Breeds_Datamodel;

public class Breeds_Endpoint extends BaseEndpoint implements IEndpoint {

    private final Class<Breeds_Datamodel[]> classType = Breeds_Datamodel[].class;

    public final String path = "/breeds/{id}";

    public void convertResponseToDataModel(String response)  {super.convertJsonToDataModelArray(response, classType);}

    public Breeds getBreedsResultByName(String name) {
        for (Breeds breeds : super.getDataModelAsArray(classType)[0].getBreeds()) {
            if (breeds.getName().equals(name)) {
                return breeds;
            }
        }
        return null;
    }

    public Breeds getResultsFromBreedsDataModel(){
        Breeds_Datamodel breedsDM = new Breeds_Datamodel();
        Breeds breeds = new Breeds();
        breeds.setId(breedsDM.getId());
        breeds.setName(breedsDM.getName());
        breeds.setBred_for(breedsDM.getBred_for());
        breeds.setBreed_group(breedsDM.getBreed_group());
        breeds.setLife_span(breedsDM.getLife_span());
        breeds.setTemperament(breedsDM.getTemperament());
        breeds.setOrigin(breedsDM.getOrigin());
        return breeds;
    }
}
