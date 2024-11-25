package ly.pt.bo.custom;

import ly.pt.model.CulinaryProgramsDTO;

import java.util.ArrayList;

public interface CulinaryProgramBO {
    boolean SaveProgram(CulinaryProgramsDTO culinaryProgramsDTO);
    boolean UpdateProgram(CulinaryProgramsDTO culinaryProgramsDTO);
    boolean DeleteProgram(String programId, CulinaryProgramsDTO culinaryProgramsDTO);
    ArrayList<CulinaryProgramsDTO> getAllPrograms();
}
