package service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dto.SectionDto;
import dao.main.Section;
import dao.main.SectionCatalog;
import service.SectionService;
@Service
public class SectionServiceImpl implements SectionService {
	@Autowired
	private SectionCatalog sectionCatalog;
	@Override
	public List<SectionDto> querySection() {
		// TODO Auto-generated method stub
		List<Section> list=sectionCatalog.getSectionCatalog();
		int size=list.size();
		List<SectionDto> result=new ArrayList<SectionDto>();
		for(int i=0;i<size;i++){
			SectionDto sectionDto=new SectionDto(list.get(i));
			result.add(sectionDto);
		}
		return result;
	}
}
