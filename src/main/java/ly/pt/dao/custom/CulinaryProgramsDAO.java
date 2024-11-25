package ly.pt.dao.custom;

import ly.pt.entity.CulinaryPrograms;

import java.util.ArrayList;

public interface CulinaryProgramsDAO {
    boolean save (CulinaryPrograms program);
    boolean Update (CulinaryPrograms program);
    boolean Delete (String Id,CulinaryPrograms program);
    ArrayList<CulinaryPrograms> getAll();
}
