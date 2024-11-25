package ly.pt.bo.custom.impl;

import ly.pt.bo.custom.CulinaryProgramBO;
import ly.pt.dao.custom.CulinaryProgramsDAO;
import ly.pt.dao.custom.impl.CulinaryProgramDAOImpl;
import ly.pt.entity.CulinaryPrograms;
import ly.pt.model.CulinaryProgramsDTO;

import java.util.ArrayList;
import java.util.List;

public class CulinaryProgramBOImpl implements CulinaryProgramBO {
    @Override
    public boolean SaveProgram(CulinaryProgramsDTO culinaryProgramsDTO) {
        CulinaryProgramsDAO culinaryProgramDAO = new CulinaryProgramDAOImpl();
        return culinaryProgramDAO.save(new CulinaryPrograms(culinaryProgramsDTO.getProgramId(), culinaryProgramsDTO.getProgramName(), culinaryProgramsDTO.getDuration(),culinaryProgramsDTO.getFee()));
    }

    @Override
    public boolean UpdateProgram(CulinaryProgramsDTO culinaryProgramsDTO) {
        CulinaryProgramsDAO culinaryProgramDAO = new CulinaryProgramDAOImpl();
        return culinaryProgramDAO.Update(new CulinaryPrograms(culinaryProgramsDTO.getProgramId(),culinaryProgramsDTO.getProgramName(),culinaryProgramsDTO.getDuration(),culinaryProgramsDTO.getFee()));
    }

    @Override
    public boolean DeleteProgram(String programId, CulinaryProgramsDTO culinaryProgramsDTO) {
        CulinaryProgramsDAO culinaryProgramDAO = new CulinaryProgramDAOImpl();
        return culinaryProgramDAO.Delete(programId,new CulinaryPrograms(culinaryProgramsDTO.getProgramId(),culinaryProgramsDTO.getProgramName(),culinaryProgramsDTO.getDuration(),culinaryProgramsDTO.getFee()));
    }

    @Override
    public ArrayList<CulinaryProgramsDTO> getAllPrograms() {
        CulinaryProgramsDAO culinaryProgramDAO = new CulinaryProgramDAOImpl();
        List<CulinaryPrograms> culinaryProgramsList = culinaryProgramDAO.getAll();
        ArrayList<CulinaryProgramsDTO> culinaryProgramsDTOList = new ArrayList<>();

        for (CulinaryPrograms culinaryPrograms : culinaryProgramsList) {
            culinaryProgramsDTOList.add(new CulinaryProgramsDTO(culinaryPrograms.getProgramId(), culinaryPrograms.getProgramName(), culinaryPrograms.getDuration(), culinaryPrograms.getFee()));
        }
        return culinaryProgramsDTOList;
    }
}
