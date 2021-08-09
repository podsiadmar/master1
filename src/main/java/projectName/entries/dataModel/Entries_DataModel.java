package projectName.entries.dataModel;

import lombok.Data;

import java.util.List;

@SuppressWarnings("unused")
@Data
public class Entries_DataModel {
    private Integer count;
    private List<Entries> entries;
}
